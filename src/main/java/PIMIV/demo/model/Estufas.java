package PIMIV.demo.model;

public class Estufas {

    private int id_estufas;
    private String nome;
    private String localizacao;

    public Estufas(){
    }

    public int getId_estufas() {
        return id_estufas;
    }

    public void setId_estufa(int id_estufa) {
        this.id_estufas = id_estufa;
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
