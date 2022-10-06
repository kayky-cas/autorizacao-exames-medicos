package models;

import enums.Especializacao;
import enums.TipoExames;
import models.Autorizacao;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Medico extends Funcionario implements TemAutorizacoes{
	private double salario;
	private boolean estacionamento;
	private Especializacao especializacao;

	private ArrayList<Autorizacao> autorizacoes;

	public Medico(String nome, double salario, Especializacao especializacao, boolean estacionamento){
		super(nome, salario, estacionamento);
		this.especializacao = especializacao;
	}

	public ArrayList<Autorizacao> listaAutorizacaoPaciente(String cpf){
		ArrayList<Autorizacao> autorizacoesPorPaciente = new ArrayList<>();

		for (Autorizacao autorizacao : autorizacoes)
			if (autorizacao.getPaciente().getCpf() == cpf)
				autorizacoesPorPaciente.add(autorizacao);

		return autorizacoesPorPaciente;
	}
	
	public ArrayList<Autorizacao> listaAutorizacaoTipo(TipoExames tipo) {
		ArrayList<Autorizacao> autorizacoesPorTipo = new ArrayList<>();

		for (Autorizacao autorizacao : autorizacoes)
			if (autorizacao.getExame().getTipo() == tipo)
				autorizacoesPorTipo.add(autorizacao);

		return autorizacoesPorTipo;
	}

	@Override
	public ArrayList<Autorizacao> getAutorizacoes() {
		return null;
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
