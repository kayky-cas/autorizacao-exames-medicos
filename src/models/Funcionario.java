package models;

public abstract class Funcionario extends Usuario{

	private double salario;

	private boolean estacionamento;

	public Funcionario (String nome, double salario, boolean estacionamento) {
		super(nome);
		this.salario = salario;
		this.estacionamento = estacionamento;
		}
	}
