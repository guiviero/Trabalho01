/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class TelaRelatorio {
    private Scanner sc;
    private static TelaRelatorio instance;
    
    public TelaRelatorio(){
        this.sc = new Scanner(System.in);
    }
    
    public void exibeTela() {
        int opcao = 0;        
        do{
            System.out.println("\nBem vindo a tela de relatórios!");
            System.out.println("-----------------------------------");
            System.out.println("1 - Lista com todos os funcionários");
            System.out.println("2 - Lista com todos os cargos");
            System.out.println("3 - Lista com todos os acessos");
            System.out.println("4 - Lista com todos os acessos negados");
            System.out.println("5 - Lista com o número de acessos negados por matrícula inexistente");
            System.out.println("6 - Lista com os acessos negados por funcionários sem acesso");
            System.out.println("7 - Lista com os acessos negados por horário não permitido");
            System.out.println("8 - Lista com os acessos negados por acesso bloqueado");
            System.out.println("9 - Buscar os acessos negados pela matrícula do funcionário");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("Selecione uma opção:");
            opcao = sc.nextInt();
            trataOpcao(opcao);
        } while(opcao != 0);     
        System.exit(0);        
    }

    private void trataOpcao(int opcao) {
        switch(opcao){
        case 1:
            listarFuncionarios();
            break;
        case 2:
            listarCargos();
            break;
        case 3:
            listarAcessos();
            break;
        case 4:
            listarAcessosNegados();
            break;
        case 5:
            listarAcessosNegadosPorMatriculaInvalida();
            break;
        case 6:
            listarAcessosNegadosSemAcesso();
            break;
        case 7:
            listarAcessosNegadosHorarioNaoPermitido();
            break;
        case 8:
            listarAcessosNegadosAcessoBloqueado();
            break;
        case 9:
            listarAcessosNegadosPelaMatricula();
        case 0:
            ControladorPrincipal.getInstance().exibeTelaPrincipal();
            break;
        default:
            break;
        }
    }

    private void listarFuncionarios() {
        ArrayList<Funcionario> funcionarios = ControladorFuncionario.getInstance().getFuncionarios();
        for (Funcionario funcRef : funcionarios) {
            System.out.println(funcRef.getMatricula()+" "+funcRef.getCargo()+" "+funcRef.getNome());
        }
        exibeTela();
    }

    private void listarCargos() {
        ArrayList<Cargo> cargos = ControladorCargo.getInstance().getCargos();
        for (Cargo cargoRef : cargos) {
            System.out.println(cargoRef.getCodigo()+" "+cargoRef.getNomeCargo());
        }
        exibeTela();
    }

    private void listarAcessos() {
        ArrayList<Acesso> acessos = ControladorAcesso.getInstance().getAcessos();
        String acesso =  "";
        for (Acesso acessoRef : acessos) {
            if(acessoRef.isConseguiuAcessar())
                acesso = "Conseguiu acessar";
            else
                acesso = "Não conseguiu acessar";
                
            System.out.println(acessoRef.getHorarioDeAcesso()+" "+acesso+" "+acessoRef.getFuncionario().getMatricula()+" "+acessoRef.getFuncionario().getNome());
        }
        exibeTela();
    }
    
    private void listarAcessosNegados() {
        ArrayList<Acesso> acessosNegados = ControladorAcesso.getInstance().getAcessosNegados();
        for (Acesso acessoRef : acessosNegados) {
            System.out.println(acessoRef.getHorarioDeAcesso()+" "+acessoRef.getMotivoNaoAcesso()+" "+acessoRef.getFuncionario().getMatricula()+" "+acessoRef.getFuncionario().getNome());
        }
        exibeTela();
    }

    private void listarAcessosNegadosPorMatriculaInvalida() {
        System.out.println("Foram feitas "+ControladorAcesso.getInstance().getAcessosNegadosMatriculaInexistente()+" tentativas de acesso com matrículas inexistentes.");
        exibeTela();
    }

    private void listarAcessosNegadosSemAcesso() {
        ArrayList<Acesso> acessosNegados = ControladorAcesso.getInstance().getAcessosNegados();
        for (Acesso acessoRef : acessosNegados) {
            if(acessoRef.getMotivoNaoAcesso() == MotivoAcessoNegado.SEMACESSO)
                System.out.println(acessoRef.getHorarioDeAcesso()+" "+acessoRef.getFuncionario().getMatricula()+" "+acessoRef.getFuncionario().getNome());
        }
        exibeTela();
    }

    private void listarAcessosNegadosHorarioNaoPermitido() {
        ArrayList<Acesso> acessosNegados = ControladorAcesso.getInstance().getAcessosNegados();
        for (Acesso acessoRef : acessosNegados) {
            if(acessoRef.getMotivoNaoAcesso() == MotivoAcessoNegado.HORARIONAOPERMITIDO)
                System.out.println(acessoRef.getHorarioDeAcesso()+" "+acessoRef.getFuncionario().getMatricula()+" "+acessoRef.getFuncionario().getNome());
        }
        exibeTela();
    }

    private void listarAcessosNegadosPelaMatricula() {        
        ArrayList<Acesso> acessosNegados = ControladorAcesso.getInstance().getAcessosNegados();
        int matriculaFuncionario;
        System.out.println("Digite a matrícula do funcionário:");
        matriculaFuncionario = sc.nextInt();
        for (Acesso acessoRef : acessosNegados){
            if(matriculaFuncionario == acessoRef.getFuncionario().getMatricula()){
                System.out.println(acessoRef.getHorarioDeAcesso()+" "+acessoRef.getMotivoNaoAcesso()+" "+acessoRef.getFuncionario().getNome());
            }
        }
        exibeTela();  
    }

    private void listarAcessosNegadosAcessoBloqueado() {
        ArrayList<Acesso> acessosNegados = ControladorAcesso.getInstance().getAcessosNegados();
        for (Acesso acessoRef : acessosNegados) {
            if(acessoRef.getMotivoNaoAcesso() == MotivoAcessoNegado.ACESSOBLOQUEADO)
                System.out.println(acessoRef.getHorarioDeAcesso()+" "+acessoRef.getFuncionario().getErrosAcesso()+" "+acessoRef.getFuncionario().getMatricula()+" "+acessoRef.getFuncionario().getNome());
        }
        exibeTela();
    }
    
    public static TelaRelatorio getInstance() {
        if(instance == null) {
            instance = new TelaRelatorio();
        }
        return instance;
    }
}
