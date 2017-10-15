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
public enum MotivoAcessoNegado {
    SEMACESSO("Esse cargo não permite acesso."),
    HORARIONAOPERMITIDO("Esse cargo não permite acesso neste horário."),
    ACESSOBLOQUEADO("Acesso bloqueado após três tentativas inválidas.");
    
    private final String descricao;

    private MotivoAcessoNegado(String descricao) {
        this.descricao = descricao;
    }
}
