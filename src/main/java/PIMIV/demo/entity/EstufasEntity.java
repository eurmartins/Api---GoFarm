package PIMIV.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estufas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstufasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_estufa;

    @Column(nullable = false)
    private String nome;


    @Column(nullable = false)
    private String localizacao;

}

