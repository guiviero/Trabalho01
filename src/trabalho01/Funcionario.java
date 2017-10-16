/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.util.Date;

/**
 *
 * @author Guilherme
 */
public class Funcionario extends Pessoa{
    private int matricula;
    private String nome;
    private String nascimento;
    private int telefone;
    private double salario;
    private Cargo cargo;
    private int cpf;
    private int errosAcesso;

    public Funcionario(int matricula, String nome, String nascimento, int telefone, double salario, Cargo cargo, int cpf, int errosAcesso) {
        this.matricula = matricula;
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.salario = salario;
        this.cargo = cargo;
        this.cpf = cpf;
        this.errosAcesso = errosAcesso;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getErrosAcesso() {
        return errosAcesso;
    }

    public void setErrosAcessoAutomatico() {
        this.errosAcesso++;
    }
    
    
}
