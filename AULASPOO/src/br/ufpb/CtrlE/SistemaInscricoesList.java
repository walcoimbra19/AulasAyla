/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.CtrlE;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author junior
 */
public class SistemaInscricoesList implements SistemaInscricao {

    private List<Participante> participantes;
    private List<Minicurso> minicursos;

    public SistemaInscricoesList() {
        this.minicursos = new ArrayList<>();
        this.participantes = new ArrayList<>();
    }

    @Override
    public void removeParticipante(String emailParticipante) throws ParticipanteNaoExisteException {
        boolean excluir = false;
        for (Participante p : this.participantes) {
            if (p.getEmail().equals(emailParticipante)) {
                participantes.remove(p);
                excluir = true;
                break;
            }
        }
        if (excluir == false) {
            throw new ParticipanteNaoExisteException("Não existe nenhum participante cadastrado com esse email: " + emailParticipante);
        }

    }

    @Override
    public List<Participante> pesquisaParticipanteDaInstituicao(String nomeDaInstituicao)throws ParticipanteNaoExisteException {
        boolean excluir = false;
        List<Participante> pEncontradosInst = new ArrayList<>();
        for (Participante p : this.participantes) {
            if (p.getInstituicao().equalsIgnoreCase(nomeDaInstituicao)) {
                pEncontradosInst.add(p);
                excluir = true;
            }
        }if (excluir == false) {
            throw new ParticipanteNaoExisteException("Não existe nenhum participante cadastrado com essa Instituição: " + nomeDaInstituicao);
        }else{
            return pEncontradosInst;
        }
        
    }

    @Override
    public List<Participante> pesquisaParticipanteDoEstado(String nomeDoEstado)throws ParticipanteNaoExisteException {
        boolean excluir = false;
        List<Participante> pEncontradosInst = new ArrayList<>();
        for (Participante p : this.participantes) {
            if (p.getEndereco().getEstado().equalsIgnoreCase(nomeDoEstado)) {
                pEncontradosInst.add(p);
                excluir = true;
                break;
            }
        }if (excluir == false) {
            throw new ParticipanteNaoExisteException("Não existe nenhum participante cadastrado com esse estado: " + nomeDoEstado);
        }else{
            return pEncontradosInst;
        }
        
    }

    @Override
    public Participante pesquisaParticipante(String EmailParticipante) throws ParticipanteNaoExisteException {
        boolean excluir = false;
        Participante g = new Participante();
        for (Participante p : this.participantes) {
            if (p.getEmail().equalsIgnoreCase(EmailParticipante)) {
                excluir = true;
                g = p;
                
            }
        }
        if (excluir == false) {
            throw new ParticipanteNaoExisteException("Não existe nenhum participante cadastrado com esse email: " + EmailParticipante);
        }return g;
    }

    @Override
    public void inscreveParticipanteEmUmCurso(String email, String tituloDoMinicurso) throws ParticipanteNaoExisteException, MinicursoNaoExisteException{
        boolean excluirMinicurso = false;
        boolean excluirParticipante = false;
        for (Minicurso m : this.minicursos) {
            if (m.getTituloMinicurso().equals(tituloDoMinicurso)) {
                excluirMinicurso = true;
                for(Participante p: this.participantes){
                    if(p.getEmail().equals(email)){
                        excluirParticipante = true;
                        try {
                            m.addParticipantes(pesquisaParticipante(email));
                        } 
                        catch (ParticipanteNaoExisteException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    }
                }
            }
            
        }
        if(excluirMinicurso == false){
                throw new MinicursoNaoExisteException("Não existe este Minicurso: "+tituloDoMinicurso);
            }else if(excluirParticipante == false){
                throw new ParticipanteNaoExisteException("Este participante não existe: "+email);
            }
    }

    @Override
    public List<Participante> getParticipantes() {
        return participantes;
    }

    @Override
    public List<Minicurso> getMinicursos() {
        return minicursos;
    }

    public List<Participante> getParticipantes(String tituloMinicurso) {
        List<Participante> pEncontrados = new ArrayList<>();
        for (Minicurso m : this.minicursos) {
            if (m.getTituloMinicurso().equals(tituloMinicurso)) {
                pEncontrados = (m.getParticipantes());
            }
        }
        return pEncontrados;
    }

    @Override
    public void cadastrarParticipante(Participante part) throws jaExisteParticipanteException {
        for (Participante p : this.participantes) {
            if (p.getEmail().equals(part.getEmail())) {
                throw new jaExisteParticipanteException("Já existe participante com esse email: " + part.getEmail());
            }

        }

        this.participantes.add(part);

    }

    @Override
    public void cadastraMinicurso(Minicurso min) throws MinicursoJaExisteException{
        for(Minicurso m: this.minicursos){
            if(m.getTituloMinicurso().equals(min.getTituloMinicurso())){
                throw new MinicursoJaExisteException("Já existe este miniCurso: "+min.getTituloMinicurso());
            }
        }
        minicursos.add(min);
    }
    public List<Participante> getParticipantesDoMinicurso(String tituloMinicurso) throws MinicursoNaoExisteException{
        boolean excluir = false;
        List<Participante> encontrados = new ArrayList<>();
        for (Minicurso m: this.minicursos){
            if(m.getTituloMinicurso().equals(tituloMinicurso)){
                excluir =true;
                encontrados = m.getParticipantes();
            }
        }
        if(excluir == false){
            throw new MinicursoNaoExisteException("Minicuro não existe: "+tituloMinicurso);
        }return encontrados;
    }

    /**
     *
     * @param titulo
     * @return
     * @throws MinicursoNaoExisteException
     */
    @Override
    public Minicurso pesquisaMinicurso(String titulo) throws MinicursoNaoExisteException{
        boolean excluir = false;
        Minicurso min = null;
        for (Minicurso m : this.minicursos) {
            if(m.getTituloMinicurso().equals(titulo)){
                excluir = true;
                min = m;
            }
                        
        }if(excluir == false){
            throw new MinicursoNaoExisteException("Exte Minicurso Não existe: "+titulo);
        }return min;
    }

    /**
     *
     * @return
     */
    @Override
    public List<String> InfoParticipanteString(){
        List<String> infoParticipante = new ArrayList<>();
        for (Participante p: this.participantes){
            infoParticipante.add(p.toString2());
            
        }return infoParticipante;
    }
}
