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
    
    private ArrayList<Funcionario> funcionarios;

    public ControladorFuncionario() {
        
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
    
    public void cadastraFuncionario(int matricula, String nome, Date nascimento, int telefone, double salario, Cargo cargo, int cpf, int errosAcesso) {
	try {
            this.verificaMatricula(matricula);
	} catch (CadastroIncorretoException e) {
            System.out.println("Funcionario Existente");
            return;
        }

	Funcionario novoFuncionario = new Funcionario(matricula, nome, nascimento, telefone, salario, cargo, cpf, errosAcesso);
	this.funcionarios.add(novoFuncionario);
    }
    
    public void alterarCargoFuncionarioPelaMatricula (int matriculaFuncionario, Cargo cargo) {
        
        // Perguntar se precisa do != cargo
        for (Funcionario funcionario : this.funcionarios){
            if (funcionario.getMatricula() == matriculaFuncionario && funcionario.getCargo() != cargo){
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
    
    public ArrayList<Funcionario> listarFuncionarios() {
        return this.funcionarios;
    }
    
    public void verificaMatricula(int matricula) throws CadastroIncorretoException {
		for (Funcionario funcionario : this.funcionarios) {
			if (funcionario.getMatricula() == matricula) {
				throw new CadastroIncorretoException("matricula existente!");
			}
		}
    }
    
}
