package PIMIV.demo.entity;

import PIMIV.demo.model.Fornecedores;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estoque_sementes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoquedeSementesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_semente;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo_cultura;

    @Column(nullable = false)
    private int quantidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private FornecedoresEntity fornecedor;

}
