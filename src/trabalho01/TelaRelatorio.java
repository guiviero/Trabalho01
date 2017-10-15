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
public class TelaRelatorio {
    private Scanner sc;
    private ControladorRelatorio owner;
    
    
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
            System.out.println("4 - Lista com os acessos negados por matrícula inválida");
            System.out.println("5 - Lista com os acessos negados por funcionários sem acesso");
            System.out.println("6 - Lista com os acessos negados por horário não permitido");
            System.out.println("7 - Lista com os acessos negados pela matrícula");
            System.out.println("0 - Encerrar");
            System.out.println("Selecione uma opção:");
            opcao = sc.nextInt();
            trataOpcao(opcao);
        } while(opcao != 0);     
        System.exit(0);        
    }

    private void trataOpcao(int opcao) {
        switch(opcao){
        case 1:
            owner.listarFuncionarios();
            break;
        case 2:
            owner.listarCargos();
            break;
        case 3:
            owner.listarAcessos();
            break;
        case 4:
            ControladorPrincipal.getInstance().exibeTelaRelatório();
            break;
        default:
            break;
        }
    }
}
