/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.CtrlE;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author junior
 */
public class Minicurso {
    private List<Participante> participantes = new ArrayList<>();
    private int maxParticipantes;
    private String tituloMinicurso;
    
    public Minicurso(String t, int mP){
        this.maxParticipantes = mP;
        this.tituloMinicurso = t;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }
    public void addParticipantes(Participante part){
        if (this.participantes.size()<this.maxParticipantes){
              this.participantes.add(part);
        }
      
    }

    public int getMaxParticipantes() {
        return maxParticipantes;
    }

    public void setMaxParticipantes(int maxParticipantes) {
        this.maxParticipantes = maxParticipantes;
    }

    public void setTituloMinicurso(String tituloMinicurso) {
        this.tituloMinicurso = tituloMinicurso;
    }

    public String getTituloMinicurso() {
        return tituloMinicurso;
    }
    
}
