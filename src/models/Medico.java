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

	public Autorizacao[] listaAutorizacaoPaciente(String cpf){
		return null;
	}
	
	public Autorizacao[] listaAutorizacaoTipo(TipoExames tipo){
		return null;
	}

}
