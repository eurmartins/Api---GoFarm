package PIMIV.demo.entity;

import PIMIV.demo.model.Fornecedores;
import jakarta.persistence.*;

@Entity
@Table(name = "estoque_sementes")
public class EstoquedeSementesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_semente;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo_cultura;

    @Column(nullable = false)
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private FornecedoresEntity fornecedor_id;

    public EstoquedeSementesEntity(){
    }

    public int getId_semente() {
        return id_semente;
    }

    public void setId_semente(int id_semente) {
        this.id_semente = id_semente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_cultura() {
        return tipo_cultura;
    }

    public void setTipo_cultura(String tipo_cultura) {
        this.tipo_cultura = tipo_cultura;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public FornecedoresEntity getFornecedor_id() {
        return fornecedor_id;
    }

    public void setFornecedor_id(FornecedoresEntity fornecedor_id) {
        this.fornecedor_id = fornecedor_id;
    }
}
