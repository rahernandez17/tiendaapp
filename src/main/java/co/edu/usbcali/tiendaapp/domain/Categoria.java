package co.edu.usbcali.tiendaapp.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 10)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    // @OneToMany(mappedBy = "categoria")
    // private List<Producto> productos;
}
