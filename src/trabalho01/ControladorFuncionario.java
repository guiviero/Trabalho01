/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private static ControladorFuncionario instance;
    
    private ControladorFuncionario() {
        this.funcionarios = new ArrayList<>();
        this.tela = new TelaFuncionario();
    }
    
    public static ControladorFuncionario getInstance() {
        if(instance == null) {
            instance = new ControladorFuncionario();
        }
        return instance;
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
        if(cargo != null){
            Funcionario novoFuncionario = new Funcionario(matricula, nome, nascimento, telefone, salario, cargo, cpf, errosAcesso);
            this.funcionarios.add(novoFuncionario);
        }
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
        this.ultimaMatricula++;
        return ultimaMatricula;
    }
    
    public ArrayList<Funcionario> getFuncionarios(){
        return this.funcionarios;
    }
    
    public Date converterData(String dataNascimento) throws ParseException{
        SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");
        Date dataConvertida = dataSimples.parse(dataNascimento);
        return dataConvertida;
    }

    public void exibeTelaFuncionario() {
        tela.exibeTela();
    }
}
