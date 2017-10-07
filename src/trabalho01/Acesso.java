/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.util.Date;

/**
 *
 * @author Guilherme
 */
public class Acesso {
    private Date horarioDeAcesso;
    private Funcionario funcionario;
    private boolean conseguiuAcessar;
    private MotivoAcessoNegado motivoNaoAcesso;

    public Acesso(Date horarioDeAcesso, Funcionario funcionario, boolean conseguiuAcessar, MotivoAcessoNegado motivoNaoAcesso) {
        this.horarioDeAcesso = horarioDeAcesso;
        this.funcionario = funcionario;
        this.conseguiuAcessar = conseguiuAcessar;
        this.motivoNaoAcesso = motivoNaoAcesso;
    }

    public Date getHorarioDeAcesso() {
        return horarioDeAcesso;
    }

    public void setHorarioDeAcesso(Date horarioDeAcesso) {
        this.horarioDeAcesso = horarioDeAcesso;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public boolean isConseguiuAcessar() {
        return conseguiuAcessar;
    }

    public void setConseguiuAcessar(boolean conseguiuAcessar) {
        this.conseguiuAcessar = conseguiuAcessar;
    }
    
    
}
