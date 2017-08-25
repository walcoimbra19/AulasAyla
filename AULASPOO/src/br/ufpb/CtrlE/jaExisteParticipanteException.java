/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.CtrlE;

/**
 *
 * @author junior
 */
class jaExisteParticipanteException extends Exception {
    
    private static  final long serialVersionUID = 1L;

    jaExisteParticipanteException(String msgErro) {
        super (msgErro);
    }
    
}
