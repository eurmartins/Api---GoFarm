package PIMIV.demo.model;

import PIMIV.demo.entity.EstufasEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Culturas {

    private int id_cultura;
    private String nome;
    private String tipo_cultura;
    private String ciclo_vida;
    private String requisitos_solo;
    private String requisitos_agua;
    private String intervalo_temperatura;
    private String requisitos_umidade;
    private String pragas_doencas;
    private int tempo_colheita;
    private Estufas estufa;
}