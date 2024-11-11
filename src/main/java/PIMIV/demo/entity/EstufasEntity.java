package PIMIV.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "estufas")
public class EstufasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_estufa;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String localizacao;

    public EstufasEntity(){
    }

    public int getId_estufa() {
        return id_estufa;
    }

    public void setId_estufa(int id_estufa) {
        this.id_estufa = id_estufa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}

