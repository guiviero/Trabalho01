/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Guilherme
 */
public class ControladorAcesso {
    private ArrayList<Acesso> acessos;
    private int acessosSemMatricula;
    private ControladorCargo ctrlCargo;
    private TelaAcesso tela;
    private static ControladorAcesso instance;
    private Date horarioDoSistema;
    
    
    private ControladorAcesso() {
	this.horarioDoSistema = new Date();
        this.tela = new TelaAcesso();
        this.acessos = new ArrayList<>();
        this.acessosSemMatricula = 0;
    }
    
    public static ControladorAcesso getInstance() {
	if (instance == null) {
            instance = new ControladorAcesso();
        }

        return instance;
    }
    
    //EU meio que ja criei o horario do sistema aqui
    public Date getHorarioDoSistema() {
        return horarioDoSistema;
    }

    public void setHorarioDoSistema(Date horarioDoSistema) {
        this.horarioDoSistema = horarioDoSistema;
    }
    
    public void tentativaDeAcesso(int matriculaFuncionario) {
        Funcionario funcionario = ControladorFuncionario.getInstance().buscarFuncionarioPelaMatricula(matriculaFuncionario);
        if(funcionario == null){
            /*Dentro do acesso precisa ter o funcionario, horario de acesso e talz, só que se não existe matricula
            não existe funcionario, por isso eu coloquei acessoSemMatricula como int */
            this.acessosSemMatricula++;
            
        }else if(funcionario.getCargo().getNIVELACESSO().equals(NivelAcesso.NULO)){
            Acesso novoAcesso = new Acesso(getHorarioDoSistema(), funcionario, false);
            novoAcesso.setMotivoNaoAcesso(MotivoAcessoNegado.SEMACESSO);
            this.acessos.add(novoAcesso);
            
        }else if(funcionario.getCargo().getNIVELACESSO().equals(NivelAcesso.COMUM)){
            
            
        }else if(funcionario.getCargo().getNIVELACESSO().equals(NivelAcesso.ESPECIAL)){
            
        }
        
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
    
    public int listarAcessosNegadosMatriculaInexistente() {
        return this.acessosSemMatricula;
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

    public void exibeTelaAcesso() {
        tela.exibeTela();
    }
    
    public void horarioDoSistema() throws ParseException {
        tela.horarioDoSistema();
    }
    
}
