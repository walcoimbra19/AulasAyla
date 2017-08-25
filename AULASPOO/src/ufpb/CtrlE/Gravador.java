/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.CtrlE;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; ///extends Exception
import java.util.ArrayList;
import java.util.List;

public class Gravador {

	/**
	 * Recupera o texto que está no arquivo chamado "nomeArquivo"
	 * e retorna o texto como uma lista de Strings, onde
	 * cada elemento da lista é uma linha do arquivo.
	 * 
	 * @param nomeArquivo É o nome do arquivo a ser lido.
	 * @return uma lista de Strings com o conteúdo do arquivo lido.
	 * @throws IOException se houver algum problema na leitura.
	 */
	public List<String> recuperaTextoDeArquivo(String nomeArquivo)
			throws IOException {    
		BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<String>();
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String texto = null;
			do {
				texto = leitor.readLine(); // lê a próxima linha do arquivo
				if (texto != null){
                       textoLido.add(texto);
                }
			} while(texto != null); //vai ser null quando chegar no fim do arquivo
		} finally {
			if (leitor!=null){
				leitor.close(); //fecha o stream(fluxo) de leitura
			}
		}
		return textoLido;
	}

	
	/**
	 * Grava um certo texto passado como parâmetro em um arquivo.
	 * 
	 * @param texto Uma lista de Strings que serão gravadas no
	 * arquivo uma por linha.
	 * 
	 * @param nomeArquivo O nome do arquivo onde vou gravar o texto
	 * @throws IOException se houver algum problema na gravação.
	 */
	public void gravaTextoEmArquivo(List<String> texto, String nomeArquivo)
			throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
                        for (String s: texto){
                              gravador.write(s+"\n");
                        }
		} finally {
			if (gravador!=null){
				gravador.close(); //fecha o stream(fluxo) de escrita
			}
		}
	}	
}