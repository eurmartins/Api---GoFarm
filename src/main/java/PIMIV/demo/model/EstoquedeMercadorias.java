package PIMIV.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoquedeMercadorias {

    private int id_mercadoria;
    private String nome;
    private String tipo_cultura;
    private int quantidade_por_caixa;
    private int quantidade_caixas;
    private Date data_colheita;
    private double preco;

}
