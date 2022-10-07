package models;

import models.Exame;

import java.util.Date;

public class Autorizacao implements Comparable<Autorizacao> {
	private static int actualCodigo = 0;

	private int codigo;

	private Date dataCadastro;

	private Medico medico;

	private Paciente paciente;

	private Exame exame;

	public Autorizacao(Date dataCadastro, Medico medico, Paciente paciente, Exame exame){
		this.codigo = actualCodigo++;
		this.dataCadastro = dataCadastro;
		this.medico = medico;
		this.paciente = paciente;
		this.exame = exame;
	}

	public int getCodigo(){
		return codigo;
	}

	public Date getDataCadastro(){
		return dataCadastro;
	}

	public Medico getMedico(){
		return medico;
	}

	public Paciente getPaciente(){
		return paciente;
	}

	public Exame getExame(){
		return exame;
	}

	@Override
	public int compareTo(Autorizacao o) {
		return this.dataCadastro.compareTo(o.getDataCadastro());
	}
}
