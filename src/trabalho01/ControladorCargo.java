/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Guilherme
 */
public class ControladorCargo {
    private ArrayList<Cargo> cargos;
    
    public void inserirCargo(Cargo cargo) {
        try {
            this.verificaCodigo(cargo.getCodigo());
        } catch (CadastroIncorretoException e) {
            System.out.println("Cargo Existente");
            return;
        }
	this.cargos.add(cargo);
    }
    
    public void alterarNivelCargoPeloCodigo (int codigoCargo) {
        
    }
    
    public void buscarCargoPeloCodigo (int codigoCargo) {
        
    }
    
    public void deletarCargoPeloCodigo (int codigoCargo) {
        
    }
    
    public ArrayList<Cargo> listarCargos() {
        return this.cargos;
    } 

    private void verificaCodigo(int codigo)throws CadastroIncorretoException {
        for (Cargo cargo : this.cargos) {
            if (cargo.getCodigo() == codigo) {
		throw new CadastroIncorretoException("Codigo existente!");
            }
	}
    }
}
