package models;

import models.Autorizacao;

import java.util.ArrayList;


public class Paciente extends Usuario {

	private String cpf;

	private ArrayList<Autorizacao> autorizacoes;

	public Paciente(String cpf, String nome){
		super(nome);
		this.cpf = cpf;
		autorizacoes = new ArrayList<>();
	}
}
