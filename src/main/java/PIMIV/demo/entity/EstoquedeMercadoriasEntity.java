package PIMIV.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "estoque_mercadorias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoquedeMercadoriasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_mercadoria;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo_cultura;

    @Column(nullable = false)
    private int quantidade_por_caixa;

    @Column(nullable = false)
    private int quantidade_caixas;

    @Column(nullable = false)
    private Date data_colheita;

    @Column(nullable = false)
    private double preco;

}
