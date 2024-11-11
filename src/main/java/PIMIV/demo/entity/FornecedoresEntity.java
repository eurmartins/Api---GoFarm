package PIMIV.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fornecedores")
public class FornecedoresEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int id_fornecedor;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String contato;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String historico_pedidos;

    public FornecedoresEntity(){
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
