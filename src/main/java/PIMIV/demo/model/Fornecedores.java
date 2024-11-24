package PIMIV.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fornecedores {

    private int id_fornecedor;
    private String nome;
    private String contato;
    private String telefone;
    private String endereco;
    private String historico_pedidos;

}
