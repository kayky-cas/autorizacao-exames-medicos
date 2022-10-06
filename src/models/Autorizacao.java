package models;

import models.Exame;

import java.util.Date;

public class Autorizacao {

	private int codigo;

	private Date data;

	private Medico medico;

	private Paciente paciente;

	private Exame exame;

	public Autorizacao(int codigo, Date data, Medico medico, Paciente paciente, Exame exame){
		this.codigo = codigo;
		this.data = data;
		this.medico = medico;
		this.paciente = paciente;
		this.exame = exame;
	}

}
