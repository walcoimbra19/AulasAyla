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
class MinicursoNaoExisteException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MinicursoNaoExisteException(String str){
        super(str);
    }
}
