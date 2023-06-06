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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 10)
    private String referencia;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column
    private String descripcion;

    @Column(name = "precio_unitario", nullable = false, length = 19, precision = 2)
    private BigDecimal precioUnitario;

    @Column(name = "unidades_disponibles", nullable = false, length = 19, precision = 2)
    private BigDecimal unidadesDisponibles;

    @ManyToOne
    @JoinColumn(name = "cate_id", referencedColumnName = "id", nullable = false)
    private Categoria categoria;
}
