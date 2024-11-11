package PIMIV.demo.model;

public class Fornecedores {

    private int id_fornecedor;
    private String nome;
    private String contato;
    private String telefone;
    private String endereco;
    private String historico_pedidos;

    public Fornecedores(){
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHistorico_pedidos() {
        return historico_pedidos;
    }

    public void setHistorico_pedidos(String historico_pedidos) {
        this.historico_pedidos = historico_pedidos;
    }
}
