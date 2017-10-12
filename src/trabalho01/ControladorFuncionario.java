/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Guilherme
 */
public class ControladorFuncionario {
    
    private static ArrayList<Funcionario> funcionarios;
    private int ultimaMatricula = 10000;
    private TelaFuncionario tela;
    
    public ControladorFuncionario() {
        this.funcionarios = new ArrayList<>();
        this.tela = new TelaFuncionario();
    }
    
    public void inserirFuncionario(Funcionario funcionario) {
        try {
            this.verificaMatricula(funcionario.getMatricula());
        } catch (CadastroIncorretoException e) {
            System.out.println("Funcionario Existente");
            return;
        }
	this.funcionarios.add(funcionario);
    }
    
    public void cadastrarFuncionario(String nome, String nascimento, int telefone, double salario, Cargo cargo, int cpf) {
	int errosAcesso = 0;
        int matricula = gerarMatricula();
	Funcionario novoFuncionario = new Funcionario(matricula, nome, nascimento, telefone, salario, cargo, cpf, errosAcesso);
	this.funcionarios.add(novoFuncionario);
    }
    
    public void alterarCargoFuncionarioPelaMatricula (int matriculaFuncionario, Cargo cargo) {
        for (Funcionario funcionario : this.funcionarios){
            if (funcionario.getMatricula() == matriculaFuncionario){
                funcionario.setCargo(cargo);
                break;
            }
        }
    }
    
    public Funcionario buscarFuncionarioPelaMatricula (int matriculaFuncionario) {
        for (Funcionario funcionario : this.funcionarios) {
            if (funcionario.getMatricula() == matriculaFuncionario) {
                return funcionario;
            }
	}
	return null;
    }
    
    public void deletarFuncionarioPelaMatricula (Funcionario funcionario) {
        if (funcionario != null && this.funcionarios.contains(funcionario)) {
            this.funcionarios.remove(funcionario);
	}
    }
    
    
    public void verificaMatricula(int matricula) throws CadastroIncorretoException {
	for (Funcionario funcionario : this.funcionarios) {
            if (funcionario.getMatricula() == matricula) {
		throw new CadastroIncorretoException("matricula existente!");
            }
	}
    }
    
    public int gerarMatricula() {
        int novaMatricula = this.ultimaMatricula++;
        this.ultimaMatricula = novaMatricula;
        return novaMatricula;
    }
    
    public ArrayList<Funcionario> getFuncionarios(){
        return this.funcionarios;
    }

    public void exibeTelaFuncionario() {
        tela.exibeTela();
    }
}
