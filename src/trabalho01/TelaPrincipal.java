/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class TelaPrincipal {
    private Scanner sc;
    private static TelaPrincipal instance;
    
    public TelaPrincipal() {
        this.sc = new Scanner(System.in);
    }
    
    public void exibeTela() throws CadastroIncorretoException, ParseException, FuncionarioComCargoException, Exception {
        int opcao = 0;        
        do{
            System.out.println("\nBem vindo ao sistema!");;
            System.out.println("-----------------------------------");
            System.out.println("1 - Menu de Funcionarios");
            System.out.println("2 - Menu de Cargos");
            System.out.println("3 - Menu de Acesso");
            System.out.println("4 - Menu de Relatórios");
            System.out.println("5 - Alterar horário do sistema");
            System.out.println("0 - Encerrar");
            System.out.println("Selecione uma opção:");
            while (!sc.hasNextInt()) sc.next();
            opcao = sc.nextInt();
            trataOpcao(opcao);
        } while(opcao != 0);     
        System.exit(0);
        
    }
    
    
    public void trataOpcao(int opcao) throws CadastroIncorretoException, ParseException, FuncionarioComCargoException, Exception{
        switch(opcao){
        case 1:
            ControladorPrincipal.getInstance().exibeTelaFuncionario();
            break;
        case 2:
            ControladorPrincipal.getInstance().exibeTelaCargo();
            break;
        case 3:
            ControladorPrincipal.getInstance().exibeTelaAcesso();
            break;
        case 4:
            ControladorPrincipal.getInstance().exibeTelaRelatório();
            break;
        case 5:
            ControladorPrincipal.getInstance().horarioDoSistema();
            break;
        default:
            break;
        }
    }
    
    public static TelaPrincipal getInstance() {
        if(instance == null) {
            instance = new TelaPrincipal();
        }
        
        return instance;
    }
}
