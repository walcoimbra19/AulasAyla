
package br.ufpb.CtrlE;

public class Endereco {
    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;
    
    public Endereco(){
        this.cidade = "";
        this.estado = "";
        this.logradouro = "";
        this.numero = "";
       
    }
    public Endereco(String l, String c, String e, String num){
        this.logradouro = l;
        this.cidade = c;
        this.estado = e;
        this.numero = num;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    @Override
    public String toString(){
        return ("A cidade e: "+this.cidade+", O estado é: "+this.estado+", o logradouro é: "+this.logradouro+"e o número é: "+this.numero);
    }
}
