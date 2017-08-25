package SistemaDeBula;

import java.util.ArrayList;
import java.util.List;

public class Medicamento {
	private String nome;
	Fabricante fabricante;
	List<Medicamento> interacoesMedicamentosas;
	List<indicacaoMedicamento> indicacoes;
	
	public Medicamento() {
		this.nome = "";
		this.indicacoes = new ArrayList<>();
		this.interacoesMedicamentosas = new ArrayList<>();
	}public Medicamento(String nome, Fabricante fabricante){
		this.fabricante = fabricante;
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public List<Medicamento> getInteracoesMedicamentosas() {
		return interacoesMedicamentosas;
	}
	public List<indicacaoMedicamento> getIndicacoes() {
		return indicacoes;
	}
}
