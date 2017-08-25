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
public class Participante {
    private String nome;
    private String email;
    private String instituicao;
    private Endereco endereco;
    
    public Participante(){
        this.nome = "";
        this.email = "";
        this.instituicao = "";
        this.endereco = null;
    }
    public Participante(String n, String e, String i, Endereco end){
        this.nome = n;
        this.email = e;
        this.instituicao = i;
        this.endereco = end;
    }

    public String getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return ("Nome: "+this.nome+"\nEmail: "+this.email+"\nInstituição: "+this.instituicao+"\n####Endereço####\nCidade: "+this.endereco.getCidade()+"\nEstado: "+this.endereco.getEstado()+"\nLogradouro: "+this.endereco.getLogradouro()+"\nNumero: "+this.endereco.getNumero());
    }
    public String toString2() {
        return (this.nome+"\n"+this.email+"\n"+this.instituicao+"\n"+this.endereco.getCidade()+"\n"+this.endereco.getEstado()+"\n"+this.endereco.getLogradouro()+"\n"+this.endereco.getNumero());
    }
}
