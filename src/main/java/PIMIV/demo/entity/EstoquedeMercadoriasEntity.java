package PIMIV.demo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "estoque_mercadorias")
public class EstoquedeMercadoriasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_mercadoria;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo_cultura;

    @Column(nullable = false)
    private int quantidade_por_caixa;

    @Column(nullable = false)
    private int quantidade_caixas;

    @Column(nullable = false)
    private Date data_colheita;

    @Column(nullable = false)
    private double preco;

    public EstoquedeMercadoriasEntity(){
    }

    public int getId_mercadoria() {
        return id_mercadoria;
    }

    public void setId_mercadoria(int id_mercadoria) {
        this.id_mercadoria = id_mercadoria;
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

    public int getQuantidade_por_caixa() {
        return quantidade_por_caixa;
    }

    public void setQuantidade_por_caixa(int quantidade_por_caixa) {
        this.quantidade_por_caixa = quantidade_por_caixa;
    }

    public int getQuantidade_caixas() {
        return quantidade_caixas;
    }

    public void setQuantidade_caixas(int quantidade_caixas) {
        this.quantidade_caixas = quantidade_caixas;
    }

    public Date getData_colheita() {
        return data_colheita;
    }

    public void setData_colheita(Date data_colheita) {
        this.data_colheita = data_colheita;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
