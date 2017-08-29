/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.CtrlE;

import java.io.IOException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author junior
 */
public class SistemaCtrlE {

    public static void main(String[] args) throws jaExisteParticipanteException, ParticipanteNaoExisteException, MinicursoNaoExisteException, MinicursoJaExisteException {
        boolean sair = false;
        
        Gravador gravador = new Gravador();
        SistemaInscricao ctrle = new SistemaInscricoesList();

        while (sair == false) {

            int menu = Integer.parseInt(JOptionPane.showInputDialog("########### MENU SISTEMA CTRL+E ###########\n1. Cadastrar um participante.\n2.Pesquisar participante pela Instituição.\n3. Pesquisar participante por estado.\n4. Pesquisar participante por email.\n5. Criar um minicurso.\n6. pesquisar minicursos: \n7. Inscrever participante em um Mini curso.\n8. remover participante.\n9. Pesquisa Participantes do Minicurso.\n10. Gravar dados.\n11. Recuperar dados.\n0. Sair."));
            if (menu == 0) {
                sair = true;
            } else if (menu == 1) {
                String nome = JOptionPane.showInputDialog("Qual o nome do particiante: ");
                String email = JOptionPane.showInputDialog("Qual o email do particiante: ");
                String instituicao = JOptionPane.showInputDialog("Qual a instituição do particiante: ");
                String logradouro = JOptionPane.showInputDialog("Qual o logradouro do participante?");
                String numero = JOptionPane.showInputDialog("Qual o numero do participante");
                String cidade = JOptionPane.showInputDialog("qual a cidade do participante");
                String estado = JOptionPane.showInputDialog("Qual o Estado do participante");
                Endereco end = new Endereco(logradouro, cidade, estado, numero);
                Participante um = new Participante(nome, email, instituicao, end);
                try {
                    ctrle.cadastrarParticipante(um);
                } catch (jaExisteParticipanteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else if (menu == 2) {
                String instituicao = JOptionPane.showInputDialog("Qual a instituição do particiante: ");
                try {
                    List<Participante> encontrados = ctrle.pesquisaParticipanteDaInstituicao(instituicao);
                    for (Participante p : encontrados) {
                        JOptionPane.showMessageDialog(null, p.toString());
                    }
                } catch (ParticipanteNaoExisteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else if (menu == 3) {
                String estado = JOptionPane.showInputDialog("Qual o Estado do particiante: ");
                try {
                    List<Participante> encontrados = ctrle.pesquisaParticipanteDoEstado(estado);
                    for (Participante p : encontrados) {
                        JOptionPane.showMessageDialog(null, p.toString());
                    }
                } catch (ParticipanteNaoExisteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else if (menu == 4) {
                String email = JOptionPane.showInputDialog("Qual o Email do particiante: ");
                try {
                    Participante encontrado = ctrle.pesquisaParticipante(email);
                    JOptionPane.showMessageDialog(null, encontrado.toString());
                } catch (ParticipanteNaoExisteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else if (menu == 5) {
                int maxParticipantes = Integer.parseInt(JOptionPane.showInputDialog("Qual o numero máximo de participates?"));
                String nome = JOptionPane.showInputDialog("qual o nome do Mini curso: ");
                Minicurso minicurso = new Minicurso(nome, maxParticipantes);
                try{
                    ctrle.cadastraMinicurso(minicurso);
                    JOptionPane.showMessageDialog(null, "Mini curso criado com sucesso!");
                }catch(MinicursoJaExisteException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else if (menu == 6) {
                String nome = JOptionPane.showInputDialog("Qual o título do minicurso? ");
                try{
                    Minicurso m = ctrle.pesquisaMinicurso(nome);
                    JOptionPane.showMessageDialog(null, m.getTituloMinicurso());
                }catch(MinicursoNaoExisteException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else if (menu == 7) {
                String email = JOptionPane.showInputDialog("Qual o email do participante: ");
                String nomeM = JOptionPane.showInputDialog("Qual o nome do mini curso: ");
                try{
                    ctrle.inscreveParticipanteEmUmCurso(email, nomeM);
                    JOptionPane.showMessageDialog(null, "Participante cadastrado com sucesso!");
                }
                catch(MinicursoNaoExisteException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }catch(ParticipanteNaoExisteException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            } else if (menu == 8) {
                String email = JOptionPane.showInputDialog("Qual o email do participante: ");
                try {
                    ctrle.removeParticipante(email);
                } catch (ParticipanteNaoExisteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }else if(menu == 9){
                String tituloMinicurso = JOptionPane.showInputDialog("Insira o Tituo do miniCurso: ");
                try{
                    List<Participante> participantesEnc = ctrle.getParticipantesDoMinicurso(tituloMinicurso);
                    for(Participante p: participantesEnc){
                        JOptionPane.showMessageDialog(null, p.getNome());
                    }
                }catch(MinicursoNaoExisteException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                
            }else if(menu == 10){
                
                List<String> participantesString = ctrle.InfoParticipanteString();
                String nomeDoArquivo = JOptionPane.showInputDialog("Quao o nome do arquivo: ");
                try{
                    gravador.gravaTextoEmArquivo(participantesString, nomeDoArquivo);
                }catch(IOException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }else if(menu == 11){
                String nomeDoArquivo = JOptionPane.showInputDialog("Qual o nome do arquivo: ");
                try {
                    List<String> participantesStringEncontrados = gravador.recuperaTextoDeArquivo(nomeDoArquivo);
                    int cont = 0;
                    int cont2 = 0;
                    
                    int max = participantesStringEncontrados.size();
                    int max2 = max/7;
                    while(cont2 < max2){
                        
                        String nome =(String) participantesStringEncontrados.get(cont);
                        cont++;
                        String email = participantesStringEncontrados.get(cont);
                        cont++;
                        String instituicao = participantesStringEncontrados.get(cont);
                        cont++;
                        String logradouro = participantesStringEncontrados.get(cont);
                        cont++;
                        String cidade = participantesStringEncontrados.get(cont);
                        cont++;
                        String estado = participantesStringEncontrados.get(cont);
                        cont++;
                        String numero = participantesStringEncontrados.get(cont);
                        cont++;
                        Endereco end = new Endereco(logradouro, cidade, estado, numero);
                        Participante um = new Participante(nome, email, instituicao, end);
                        ctrle.cadastrarParticipante(um);
                        cont2+=1;

                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(SistemaCtrlE.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}
