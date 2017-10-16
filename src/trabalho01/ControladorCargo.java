/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import trabalho01.ControladorFuncionario;
/**
 *
 * @author Guilherme
 */
public class ControladorCargo {
    
    private ControladorFuncionario ctrlFuncionario;
    private ArrayList<Cargo> cargos;
    private int ultimoCodigo;
    private TelaCargo telaCargo;
    private static ControladorCargo instance;
    
    
    private ControladorCargo() {
	this.cargos = new ArrayList<>();
        this.ultimoCodigo = 100;
    }
    
    public static ControladorCargo getInstance() {
	if (instance == null) {
            instance = new ControladorCargo();
        }

        return instance;
    }
    
    /*public void inserirCargo(Cargo cargo) {
        try {
            this.verificaCodigo(cargo.getCodigo());
        } catch (CadastroIncorretoException e) {
            System.out.println("Cargo Existente");
            //return;
        }
	this.cargos.add(cargo);
    }*/
    
    public void cadastraCargo(String nomeCargo, NivelAcesso NIVELACESSO) {
        int codigo = gerarCodigo();
        Cargo novoCargo = new Cargo(nomeCargo, codigo, NIVELACESSO);
        this.cargos.add(novoCargo);
        /*
        for(Cargo cargoRef : cargos){
            if(!(novoCargo.getNomeCargo().equalsIgnoreCase(cargoRef.getNomeCargo())) || novoCargo.getCodigo() != cargoRef.getCodigo()){
                
            }
        }*/
    }
    
    public void exibeCargos() {
        if (this.cargos.isEmpty()) {
            TelaCargo.getInstance().mensagemNaoHaCargos();
            return;
        }
        for (Cargo cargo : this.cargos) {
             TelaCargo.getInstance().exibeCargo(cargo);
        }
    }
    
    public Cargo buscarCargoPeloCodigo (int codigoCargo){
        for(Cargo cargo : cargos){
            if(cargo.getCodigo() == codigoCargo){
                return cargo;
            }
        }
        return null;
    }
    
    public void alterarNomeCargoPeloCodigo (String novoNomeCargo, int codigoCargo){
        for(Cargo cargoRef : cargos){
            if(cargoRef.getCodigo() == codigoCargo){
                cargoRef.setNomeCargo(novoNomeCargo);
            }
        }
    }
    
    public boolean haCargos() {
	if (this.cargos.isEmpty()) {
            TelaCargo.getInstance().mensagemNaoHaCargos();
            return false;
	}
	return true;
    }
    
    public void deletarCargoPeloCodigo (int codigoCargo) throws FuncionarioComCargoException{
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
        listaFuncionarios = ControladorFuncionario.getInstance().getFuncionarios();
        for(Funcionario func : listaFuncionarios){
            if(func.getCargo().getCodigo() == codigoCargo){
                throw new FuncionarioComCargoException("Existe Funcionarios com esse cargo");
            }
        }
        
        for(Cargo cargo : cargos){
            if(cargo.getCodigo() == codigoCargo){
                cargos.remove(cargo);
            }
        }        
    }
    
    public ArrayList<Cargo> getCargos() {
        return this.cargos;
    } 

    /*private void verificaCodigo(int codigo)throws CadastroIncorretoException {
        for (Cargo cargo : this.cargos) {
            if (cargo.getCodigo() == codigo) {
		throw new CadastroIncorretoException("Codigo existente!");
            }
	}
    }*/
    
    public int gerarCodigo() {
        this.ultimoCodigo++;
        return ultimoCodigo;
    }

    public int getUltimoCodigo() {
        return ultimoCodigo;
    }

    public void setUltimoCodigo(int ultimoCodigo) {
        this.ultimoCodigo = ultimoCodigo;
    }
    
    public void exibeTelaCargo() throws CadastroIncorretoException, FuncionarioComCargoException, ParseException{
        TelaCargo.getInstance().exibeTela();
    }
}