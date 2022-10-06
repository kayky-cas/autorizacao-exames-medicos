package models;

import models.Exame;

import java.util.Date;

public class Autorizacao {

	private int codigo;

	private Date data_cadastro;

	private Medico medico;

	private Paciente paciente;

	private Exame exame;

	public Autorizacao(int codigo, Date data_cadastro, Medico medico, Paciente paciente, Exame exame){
		this.codigo = codigo;
		this.data_cadastro = data_cadastro;
		this.medico = medico;
		this.paciente = paciente;
		this.exame = exame;
	}

	public int get_codigo(){
		return codigo;
	}

	public Date get_data_cadastro(){
		return data_cadastro;
	}

	public Medico get_medico(){
		return medico;
	}

	public Paciente get_paciente(){
		return paciente;
	}

	public Exame get_exame(){
		return exame;
	}

}
