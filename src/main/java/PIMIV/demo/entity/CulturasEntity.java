package PIMIV.demo.entity;

import PIMIV.demo.model.Estufas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "culturas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CulturasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_cultura;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo_cultura;

    @Column(nullable = false)
    private String ciclo_vida;

    @Column(nullable = false)
    private String requisitos_solo;

    @Column(nullable = false)
    private String requisitos_agua;

    @Column(nullable = false)
    private String intervalo_temperatura;

    @Column(nullable = false)
    private String requisitos_umidade;

    @Column(nullable = false)
    private String pragas_doencas;

    @Column(nullable = false)
    private int tempo_colheita;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estufa", nullable = true)
    private EstufasEntity estufa;

}
