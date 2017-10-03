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
public enum ConseguiuAcessar {
    SIM("Funcionário conseguiu acessar."),
    NAO("Funcionário não conseguiu acessar");
    
    private final String descricao;

    private ConseguiuAcessar(String descricao) {
        this.descricao = descricao;
    }
    
    
}
