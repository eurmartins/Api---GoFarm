package PIMIV.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    private int id;
    private String nome;
    private String cargo;
    private String email;
    private String senha;
    private String telefone;
    private Date data_admissao;
    private double salario;
}
