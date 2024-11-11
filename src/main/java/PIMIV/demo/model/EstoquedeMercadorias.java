package PIMIV.demo.model;

import java.util.Date;

public class EstoquedeMercadorias {

    private int id_mercadoria;
    private String nome;
    private String tipo_cultura;
    private int quantidade_por_caixa;
    private int quantidade_caixas;
    private Date data_colheita;
    private double preco;

    public EstoquedeMercadorias(){
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
