package PIMIV.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fornecedores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FornecedoresEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int id_fornecedor;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String contato;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String historico_pedidos;
}
