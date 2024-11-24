package PIMIV.demo.model;

import PIMIV.demo.entity.FornecedoresEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstoquedeSementes {

    private int id_semente;
    private String nome;
    private String tipo_cultura;
    private int quantidade;
    private Fornecedores fornecedor;

}

