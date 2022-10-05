package models;

import enums.Especializacao;
import enums.TipoExames;
import models.Autorizacao;

import java.util.ArrayList;

public class Medico {

	private int id;
	private String nome;
	private double salario;
	private boolean estacionamento;
	private Especializacao especializacao;

	private ArrayList<Autorizacao> autorizacoes;

	public Medico(int id, String nome, double salario, boolean estacionamento, Especializacao especializacao){
		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.estacionamento = estacionamento;
		this.especializacao = especializacao;
	}

	public boolean incluirAutorizacao(Autorizacao autorizacao){
		for(Autorizacao a : autorizacoes){
			if(a.getCodigo() == autorizacao.getCodigo()){
				return false;
			}
		}
		autorizacoes.add(a);
		return true;
	}

	public ArrayList<Autorizacao> listaAutorizacaoPaciente(String cpf){
		ArrayList<Autorizacao> autorizacoes = new ArrayList<>();
		for (Autorizacao autorizacao : a) {
			if(a.getPaciente().getCpf().equals(cpf)){
				autorizacoes.add(a);	
			}	
		}
		return autorizacoes;
	}
	
	public ArrayList<Autorizacao> listaAutorizacaoTipo(TipoExames tipo){
		ArrayList<Autorizacao> autorizacoes = new ArrayList<>();
		for (Autorizacao autorizacao : a) {
			if(a.getExame().getTipo().equals(tipo)){
				autorizacoes.add(a);	
			}	
		}
		return autorizacoes;
	}
}
