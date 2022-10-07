package models;

import enums.Especializacao;
import models.Autorizacao;

import java.util.ArrayList;

public class Medico extends Usuario {
	private Especializacao especificacao;
	private ArrayList<Autorizacao> autorizacoes;

	public Medico(String nome, Especializacao especificacao) {
		super(nome);
		this.especificacao = especificacao;
		autorizacoes = new ArrayList<Autorizacao>();
	}
}