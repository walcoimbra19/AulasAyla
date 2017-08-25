/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.CtrlE;

import java.util.List;

/**
 *
 * @author junior
 */
public interface SistemaInscricao {
    public void removeParticipante(String emailParticipante) throws ParticipanteNaoExisteException;
    public List<Participante> pesquisaParticipanteDaInstituicao(String nomeDaInstituicao)throws ParticipanteNaoExisteException;
    public List<Participante> pesquisaParticipanteDoEstado(String nomeDoEstado)throws ParticipanteNaoExisteException;
    public Participante pesquisaParticipante(String EmailParticipante)throws ParticipanteNaoExisteException;
    public void inscreveParticipanteEmUmCurso(String email, String tituloDoMinicurso)throws ParticipanteNaoExisteException, MinicursoNaoExisteException;
    /**
     *
     * @param part
     * @throws jaExisteParticipanteException
     */
    public void cadastrarParticipante(Participante part)throws jaExisteParticipanteException;
    public void cadastraMinicurso(Minicurso m) throws MinicursoJaExisteException;
    public List<Minicurso> getMinicursos();
    public List<Participante> getParticipantes();
    public List<Participante> getParticipantesDoMinicurso(String tituloMinicurso) throws MinicursoNaoExisteException;
    public Minicurso pesquisaMinicurso(String titulo) throws MinicursoNaoExisteException;
    public List<String> InfoParticipanteString();
}
