package PIMIV.demo.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "funcionarios")
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_funcionario;

    @Column(nullable = true)
    private String nome;

    @Column(nullable = true)
    private String cargo;

    @Column(nullable = true, unique = true)
    private String email;

    @Column(nullable = true,unique = true)
    private String senha;

    @Column(nullable = true)
    private String telefone;

    @Column(name = "data_admissao", nullable = true)
    private Date data_admissao;

    @Column(nullable = true)
    private double salario;


    public FuncionarioEntity(){
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(Date data_admissao) {
        this.data_admissao = data_admissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
