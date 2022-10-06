package models;

import enums.Especializacao;
import enums.TipoExames;
import models.Autorizacao;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Medico extends Funcionario{
	private double salario;
	private boolean estacionamento;
	private Especializacao especializacao;

	private ArrayList<Autorizacao> autorizacoes;

	public Medico(String nome, double salario, Especializacao especializacao){
		super(nome, salario);
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
}
