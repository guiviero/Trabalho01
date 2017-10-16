/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.text.ParseException;
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
    
    public void exibeTela() throws CadastroIncorretoException, ParseException, FuncionarioComCargoException, Exception {
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
            while (!sc.hasNextInt()) sc.next();
            opcao = sc.nextInt();
            trataOpcao(opcao);
        } while(opcao != 0);     
        System.exit(0);        
    }

    private void trataOpcao(int opcao) throws CadastroIncorretoException, ParseException, FuncionarioComCargoException, Exception {
        switch(opcao){
        case 1:
            listarFuncionarios();
            break;
        case 2:
            listarCargos();
            break;
        case 3:
            listarAcessos();
            exibeTela();
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

    public void listarFuncionarios() throws CadastroIncorretoException, ParseException, FuncionarioComCargoException {
        ArrayList<Funcionario> funcionarios = ControladorFuncionario.getInstance().getFuncionarios();
        if(funcionarios.isEmpty()){
            System.out.println("Não há funcionários");
        } else {
            for (Funcionario funcRef : funcionarios) {
                System.out.println("Mátricula: "+funcRef.getMatricula()+"| Cargo: "+funcRef.getCargo().getNomeCargo()+"| Funcionário: "+funcRef.getNome());
            }
        }
    }

    private void listarCargos() throws CadastroIncorretoException, ParseException, FuncionarioComCargoException, Exception {
        ArrayList<Cargo> cargos = ControladorCargo.getInstance().getCargos();
        if(cargos.isEmpty()){
            System.out.println("Não há cargos");
        } else {
            for (Cargo cargoRef : cargos) {
                System.out.println("Código: "+cargoRef.getCodigo()+"| Cargo: "+cargoRef.getNomeCargo());
            }
        }
        exibeTela();
    }

    public void listarAcessos() throws CadastroIncorretoException, ParseException, FuncionarioComCargoException {
        ArrayList<Acesso> acessos = ControladorAcesso.getInstance().getAcessos();
        if(acessos.isEmpty()){
            System.out.println("Não há acessos");
        } else {
            String acesso =  "";
            for (Acesso acessoRef : acessos) {
                if(acessoRef.isConseguiuAcessar())
                  acesso = "Conseguiu acessar";
                else
                   acesso = "Não conseguiu acessar";
                
                System.out.println(acessoRef.getHorarioDeAcesso()+" | "+acesso+"| Matrícula: "+acessoRef.getFuncionario().getMatricula()+"| Funcionário: "+acessoRef.getFuncionario().getNome());
            }
        }
    }
    
    private void listarAcessosNegados() throws CadastroIncorretoException, ParseException, FuncionarioComCargoException, Exception {
        ArrayList<Acesso> acessosNegados = ControladorAcesso.getInstance().getAcessosNegados();
        if(acessosNegados.isEmpty()){
            System.out.println("Não há acessos negados");
        }
        for (Acesso acessoRef : acessosNegados) {
            System.out.println(acessoRef.getHorarioDeAcesso()+"| Motivo: "+acessoRef.getMotivoNaoAcesso()+"| Funcionário "+acessoRef.getFuncionario().getMatricula()+" "+acessoRef.getFuncionario().getNome());
        }
        exibeTela();
    }

    private void listarAcessosNegadosPorMatriculaInvalida() throws CadastroIncorretoException, ParseException, FuncionarioComCargoException, Exception {
        System.out.println("Foram feitas "+ControladorAcesso.getInstance().getAcessosNegadosMatriculaInexistente()+" tentativas de acesso com matrículas inexistentes.");
        exibeTela();
    }

    private void listarAcessosNegadosSemAcesso() throws CadastroIncorretoException, ParseException, FuncionarioComCargoException, Exception {
        ArrayList<Acesso> acessosNegados = ControladorAcesso.getInstance().getAcessosNegados();
        int numeroDeImpressoes = 0;
        for (Acesso acessoRef : acessosNegados) {
            if(acessoRef.getMotivoNaoAcesso() == MotivoAcessoNegado.SEMACESSO)
                System.out.println(acessoRef.getHorarioDeAcesso()+"| Matricula: "+acessoRef.getFuncionario().getMatricula()+"| Funcionário: "+acessoRef.getFuncionario().getNome());
                numeroDeImpressoes++;
        }
        if(numeroDeImpressoes == 0){
            System.out.println("Não há acessos negados de funcionários sem acesso");
        }
        exibeTela();
    }

    private void listarAcessosNegadosHorarioNaoPermitido() throws CadastroIncorretoException, ParseException, FuncionarioComCargoException, Exception {
        ArrayList<Acesso> acessosNegados = ControladorAcesso.getInstance().getAcessosNegados();
        int numeroDeImpressoes = 0;
        for (Acesso acessoRef : acessosNegados) {
            if(acessoRef.getMotivoNaoAcesso() == MotivoAcessoNegado.HORARIONAOPERMITIDO)
                System.out.println(acessoRef.getHorarioDeAcesso()+"| Matrícula: "+acessoRef.getFuncionario().getMatricula()+"| Funcionário: "+acessoRef.getFuncionario().getNome());
                numeroDeImpressoes++;
        }
        if(numeroDeImpressoes == 0){
            System.out.println("Não há acessos negados por horário não permitido");
        }
        exibeTela();
    }

    private void listarAcessosNegadosPelaMatricula() throws CadastroIncorretoException, ParseException, FuncionarioComCargoException, Exception {        
        ArrayList<Acesso> acessosNegados = ControladorAcesso.getInstance().getAcessosNegados();
        int matriculaFuncionario;
        int numeroDeImpressoes = 0;
        System.out.println("Digite a matrícula do funcionário:");
        while (!sc.hasNextInt()) sc.next();
        matriculaFuncionario = sc.nextInt();
        for (Acesso acessoRef : acessosNegados){
            if(matriculaFuncionario == acessoRef.getFuncionario().getMatricula()){
                System.out.println(acessoRef.getHorarioDeAcesso()+"| Motivo: "+acessoRef.getMotivoNaoAcesso()+"| Funcionário: "+acessoRef.getFuncionario().getNome());
                numeroDeImpressoes++;
            }
        }
        if(numeroDeImpressoes == 0){
            System.out.println("Esse funcionário não tem nenhum acesso negado");
        }
        exibeTela();  
    }

    private void listarAcessosNegadosAcessoBloqueado() throws CadastroIncorretoException, ParseException, FuncionarioComCargoException, Exception {
        ArrayList<Acesso> acessosNegados = ControladorAcesso.getInstance().getAcessosNegados();
        int numeroDeImpressoes = 0;
        for (Acesso acessoRef : acessosNegados) {
            if(acessoRef.getMotivoNaoAcesso() == MotivoAcessoNegado.ACESSOBLOQUEADO)
                System.out.println(acessoRef.getHorarioDeAcesso()+"| Numero de erros do funcionário: "+acessoRef.getFuncionario().getErrosAcesso()+"| Matrícula: "+acessoRef.getFuncionario().getMatricula()+"| Funcionário: "+acessoRef.getFuncionario().getNome());
                numeroDeImpressoes++;
        }
        if(numeroDeImpressoes == 0){
            System.out.println("Não há acessos negados por acesso bloqueado");
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
