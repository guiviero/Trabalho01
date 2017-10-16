/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class TelaAcesso {
    
    private ControladorAcesso owner;
    private Scanner sc;
    private static TelaAcesso instance;
    

    public TelaAcesso() {
        this.sc = new Scanner(System.in);
    }
    
    public static TelaAcesso getInstance() {
        if(instance == null) {
            instance = new TelaAcesso();
        }
        return instance;
    }
        
    public void exibeTela() throws ParseException, CadastroIncorretoException, FuncionarioComCargoException {
        int opcao = 0;        
        do{
            System.out.println("\nMenu dos Acessos!");
            System.out.println("-----------------------------------");
            System.out.println("1 - Entrar no setor financeiro");
            System.out.println("2 - Lista de todos os acessos");
            System.out.println("0 - Voltar");
            System.out.println("Selecione uma opção:");
            opcao = sc.nextInt();
            trataOpcao(opcao);
        } while(opcao != -1);
    }
    
    public void trataOpcao(int opcao) throws ParseException, CadastroIncorretoException, FuncionarioComCargoException {
        switch(opcao){
        case 1:
            ControladorAcesso.getInstance().tentativaDeAcesso(opcao);
        case 2:
            //Nesse metodo eu tive a ideia de pegar os dados da classe relatorio
            ControladorRelatorio.getInstance().exibeTelaRelatorio();
            break;
        case 0:
            ControladorPrincipal.getInstance().exibeTelaPrincipal();
            break;
        default:
            break;
        }
    }
    
    public void acessarSetorFinanceiro() throws CadastroIncorretoException, ParseException{
        System.out.println("\n Bem vindo ao setor financeiro, para continuar digite a sua matricula:");
        int matricula = sc.nextInt();
        ControladorAcesso.getInstance().tentativaDeAcesso(matricula);
        
    }
    
    public void acessoPermitido() {
        System.out.println("Acesso permitido");
    }
    
    public void acessoNegado() {
        System.out.println("Acesso negado");
    }
}
