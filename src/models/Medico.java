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

	public boolean addAutorizacao(Autorizacao autorizacao){
		return true;
	}

	public ArrayList<Autorizacao> listaAutorizacaoPaciente(String cpf){
		Paciente p = new Paciente();
		if(cpf.equals(p.getCpf())){
			return p.getAutorizacoes();
		}
		return null;
	}
	
	public ArrayList<Autorizacao> listaAutorizacaoTipo(TipoExames tipo){
		Exame e = new Exame(tipo, null);
		Autorizacao a = new Autorizacao();
		if(tipo.equals(e.getTipo())){
			autorizacoes.add(a);			
		}
		return autorizacoes;
	}

}
