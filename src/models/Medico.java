package models;

import enums.Especializacao;
import enums.TipoExames;
import models.Autorizacao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Medico extends Funcionario implements TemAutorizacoes{
	private double salario;
	private boolean estacionamento;
	private Especializacao especializacao;

	private ArrayList<Autorizacao> autorizacoes;

	public Medico(String nome, double salario, Especializacao especializacao, boolean estacionamento){
		super(nome, salario, estacionamento);
		this.especializacao = especializacao;
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
