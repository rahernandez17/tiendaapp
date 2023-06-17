package co.edu.usbcali.tiendaapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 19, precision = 2)
    private BigDecimal cantidad;

    @Column(nullable = false, length = 19, precision = 2)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "pedi_id", referencedColumnName = "id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "prod_id", referencedColumnName = "id", nullable = false)
    private Producto producto;

}
