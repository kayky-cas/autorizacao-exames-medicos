package models;

import models.Autorizacao;

import java.util.ArrayList;

public class Paciente extends Usuario implements TemAutorizacoes {

	private String cpf;
	private ArrayList<Autorizacao> autorizacoes;

	public Paciente(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
		autorizacoes = new ArrayList<>();
	}

	

	public boolean realizarExame(int codigoAutorizacao) {
		for (Autorizacao autorizacao : autorizacoes) {
			if (autorizacao.getCodigo() == codigoAutorizacao) {
				autorizacao.getExame().realizarExame();
				return true;
			}
		}

		return false;
	}

	@Override
	public ArrayList<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}
}
