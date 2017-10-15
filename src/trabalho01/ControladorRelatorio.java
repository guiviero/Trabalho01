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
public class ControladorRelatorio {
    private TelaRelatorio tela;
    private static ControladorRelatorio instance;
    
    public ControladorRelatorio() {
        this.tela = new TelaRelatorio();
    }
    
    public static ControladorRelatorio getInstance() {
	if (instance == null) {
            instance = new ControladorRelatorio();
        }

        return instance;
    }
    
    public ArrayList<Funcionario> listaFuncionarios(){
        ArrayList<Funcionario> listaFuncionarios = ControladorFuncionario.getInstance().getFuncionarios();
        return listaFuncionarios;
    }
    
        
    public void exibeTelaRelatorio() {
        tela.exibeTela();
    }

}
