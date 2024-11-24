package PIMIV.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "funcionarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_funcionario;

    @Column(nullable = true)
    private String nome;

    @Column(nullable = true)
    private String cargo;

    @Column(nullable = true, unique = true)
    private String email;

    @Column(nullable = true,unique = true)
    private String senha;

    @Column(nullable = true)
    private String telefone;

    @Column(name = "data_admissao", nullable = true)
    private Date data_admissao;

    @Column(nullable = true)
    private double salario;

}
