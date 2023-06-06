package co.edu.usbcali.tiendaapp.domain;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private Instant fecha;
	
	@Column(nullable = false, length = 19, precision = 2)
	private BigDecimal total;

	@ManyToOne
	@JoinColumn(name = "clie_id", nullable = false)
	private Cliente cliente;

	@OneToOne
	@JoinColumn(name = "espe_id", nullable = false)
	private EstadoPedido estadoPedido;
}