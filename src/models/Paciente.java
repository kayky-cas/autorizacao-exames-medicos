package models;

import models.Autorizacao;

import java.util.ArrayList;
import java.util.Collections;

public class Paciente extends Usuario implements TemAutorizacoes {
	private final String cpf;
	private ArrayList<Autorizacao> autorizacoes;

	public Paciente(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
		autorizacoes = new ArrayList<>();
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public ArrayList<Autorizacao> getAutorizacoes() {
		return new ArrayList<>(this.autorizacoes);
	}

	@Override
	public boolean addAutorizacao(Autorizacao autorizacao) {
		for (Autorizacao autorizacaoEmList : autorizacoes)
			if (autorizacao.getCodigo() == autorizacaoEmList.getCodigo())
				return false;

		if (autorizacoes.add(autorizacao)) {
			Collections.sort(autorizacoes);
			return true;
		}

		return false;
	}

	@Override
	public boolean removeAutorizacao(int codigoAutorizacao) {
		for (Autorizacao autorizacao : autorizacoes)
			if (autorizacao.getCodigo() == codigoAutorizacao)
				 return autorizacoes.remove(autorizacao);

		return false;
	}
}
