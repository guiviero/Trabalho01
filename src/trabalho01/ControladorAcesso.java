/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class ControladorAcesso {
    private ArrayList<Acesso> acessos;
    
    public void tentativaDeAcesso (int codigoFuncionario) {
        
    }
    
    public ArrayList<Acesso> listarAcessos() {
        return this.acessos;
    }
    
    public ArrayList<Acesso> listarAcessosNegados() {
        ArrayList<Acesso> acessosNegados = new ArrayList<>();
        for (Acesso acesso: acessos){
            if(acesso.isConseguiuAcessar() == false){
                acessosNegados.add(acesso);
            }
        }
        return acessosNegados;
    }
    
    public ArrayList<Acesso> listarAcessosNegadosMatriculaInexistente() {
        ArrayList<Acesso> acessosNegadosMatriculaInexistente = new ArrayList<>();
        for(Acesso acesso: acessos){
            if(acesso)
        }
        
    }
    
    public ArrayList<Acesso> listarAcessosNegadosSemAcesso() {
        
    }
    
    public ArrayList<Acesso> listarAcessosNegadosHorarioNaoPermitido() {
        
    }
    
    public ArrayList<Acesso> listarAcessosNegadosAcessoBloqueado() {
        
    }
    
    
}
