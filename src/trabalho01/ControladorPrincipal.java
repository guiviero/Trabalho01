/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho01;

/**
 *
 * @author Guilherme
 */
public class ControladorPrincipal {
    
    private static ControladorPrincipal instance;
    private ControladorFuncionario ctrlFuncionario;
    private ControladorCargo ctrlCargo;
    private ControladorAcesso ctrlAcesso;
    private ControladorRelatorio ctrlRelatorio;
    
    public static ControladorPrincipal getInstance() {
        if(instance == null) {
            instance = new ControladorPrincipal();
        }
        
        return instance;
    }
    
    public void exibeTelaFuncionario() {
        ctrlFuncionario.exibeTelaFuncionario();
    }

    void exibeTelaCargo() {
        ctrlCargo.exibeTelaCargo();
    }

    void exibeTelaAcesso() {
        ctrlAcesso.exibeTelaAcesso();
    }

    void exibeTelaRelatório() {
        ctrlRelatorio.exibeTelaRelatorio();
    }
}
