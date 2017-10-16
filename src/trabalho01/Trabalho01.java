/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Guilherme
 */
public class Trabalho01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Bem vindo ao sistema!");
        ControladorPrincipal.getInstance().horarioDoSistema();
        ControladorPrincipal.getInstance().exibeTelaPrincipal();
        //System.out.println(ControladorPrincipal.getInstance().getHorarioDoSistema());
    }
    
}
