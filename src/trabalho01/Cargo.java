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
public class Cargo implements ICargo {
    private String nomeCargo;
    private NivelAcesso NIVELACESSO;
    private int codigo;
    private Date horarioInicio;
    private Date horarioFinal;

    public Cargo(String nomeCargo, int codigo, NivelAcesso NIVELACESSO) {
        this.nomeCargo = nomeCargo;
        this.codigo = codigo;
        this.NIVELACESSO = NIVELACESSO;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public NivelAcesso getNIVELACESSO() {
        return NIVELACESSO;
    }

    public void setNIVELACESSO(NivelAcesso NIVELACESSO) {
        this.NIVELACESSO = NIVELACESSO;
    }

}
