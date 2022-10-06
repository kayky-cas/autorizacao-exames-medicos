package models;

import models.Exame;

import java.util.Date;

public class Autorizacao {

	private int codigo;

	private Date dataCadastro;

	private Medico medico;

	private Paciente paciente;

	private Exame exame;

	public Autorizacao(int codigo, Date dataCadastro, Medico medico, Paciente paciente, Exame exame){
		this.codigo = codigo;
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

}
