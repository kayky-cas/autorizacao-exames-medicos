package models;

import models.Autorizacao;

import java.util.ArrayList;

public class Paciente extends Usuario implements TemAutorizacoes {

	private final String cpf;
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

	public String getCpf() {
		return cpf;
	}

	@Override
	public ArrayList<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	@Override
	public boolean addAutorizacao(Autorizacao autorizacao) {
		for (Autorizacao autorizacaoEmList : autorizacoes)
			if (autorizacao.getCodigo() == autorizacaoEmList.getCodigo())
				return false;

		return autorizacoes.add(autorizacao);
	}

	@Override
	public boolean removeAutorizacao(int codigoAutorizacao) {
		for (Autorizacao autorizacao : autorizacoes)
			if (autorizacao.getCodigo() == codigoAutorizacao)
				 return autorizacoes.remove(autorizacao);

		return false;
	}
}
