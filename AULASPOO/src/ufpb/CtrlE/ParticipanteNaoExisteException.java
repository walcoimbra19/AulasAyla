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
class ParticipanteNaoExisteException extends Exception {
    public ParticipanteNaoExisteException(String msg){
        super(msg);
    }
}
