package models;

import models.Autorizacao;

import java.util.ArrayList;

public class Paciente {

	private int id;
	private String nome;
	private String cpf;
	private ArrayList<Autorizacao> autorizacoes;

	public Paciente(int id, String nome, String cpf) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Paciente() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ArrayList<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(ArrayList<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

}
