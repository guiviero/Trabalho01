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
    private ControladorCargo ctrlCargo;
    private TelaAcesso tela;
    
    public void tentativaDeAcesso(int codigoFuncionario) {
        
    }
    
    public ArrayList<Acesso> getAcessos() {
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
        for(Acesso acessoRef: acessos){
            if(acessoRef.getMotivoNaoAcesso().equals(MotivoAcessoNegado.MATRICULAINEXISTENTE)){
                acessosNegadosMatriculaInexistente.add(acessoRef);
            }
        }
        return acessosNegadosMatriculaInexistente;
    }
    
    public ArrayList<Acesso> listarAcessosNegadosSemAcesso() {
      ArrayList<Acesso> acessosNegadosSemAcessos = new ArrayList<>();
        for(Acesso acessoRef: acessos){
            if(acessoRef.getMotivoNaoAcesso().equals(MotivoAcessoNegado.SEMACESSO)){
                acessosNegadosSemAcessos.add(acessoRef);
            }
        }
        return acessosNegadosSemAcessos;
    }
    
    public ArrayList<Acesso> listarAcessosNegadosHorarioNaoPermitido() {
        ArrayList<Acesso> acessosNegadosHorarioNaoPermitido = new ArrayList<>();
        for(Acesso acessoRef: acessos){
            if(acessoRef.getMotivoNaoAcesso().equals(MotivoAcessoNegado.HORARIONAOPERMITIDO)){
                acessosNegadosHorarioNaoPermitido.add(acessoRef);
            }
        }
        return acessosNegadosHorarioNaoPermitido;
    }
    
    public ArrayList<Acesso> listarAcessosNegadosAcessoBloqueado() {
        ArrayList<Acesso> acessosBloqueados = new ArrayList<>();
        for(Acesso acessoRef: acessos){
            if(acessoRef.getMotivoNaoAcesso().equals(MotivoAcessoNegado.ACESSOBLOQUEADO)){
                acessosBloqueados.add(acessoRef);
            }
        }
        return acessosBloqueados;
    }

    void exibeTelaAcesso() {
        tela.exibeTela();
    }
    
}
