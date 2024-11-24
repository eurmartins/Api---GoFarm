package PIMIV.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estufas {

    private int id_estufas;
    private String nome;
    private String localizacao;

}
