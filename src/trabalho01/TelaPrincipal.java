/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class TelaPrincipal {
    private Scanner sc;
    
    public TelaPrincipal() {
        this.sc = new Scanner(System.in);
    }
    
    public void exibirTela() {
        int opcao = 0;        
        do{
            System.out.println("\nBem vindo ao sistema!");;
            System.out.println("-----------------------------------");
            System.out.println("1 - Menu de Funcionarios");
            System.out.println("2 - Menu de Cargos");
            System.out.println("3 - Menu de Acesso");
            System.out.println("4 - Menu de Relatórios");            
            System.out.println("0 - Encerrar");
            System.out.println("Selecione uma opção:");
            opcao = sc.nextInt();
            trataOpcao(opcao);
        } while(opcao != 0);     
        System.exit(0);
        
    }
    
    public void trataOpcao(int opcao){
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
        default:
            break;
        }
    }
}
