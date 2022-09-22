package models;

public abstract class Funcionario extends Usuario{

	private double salario;

	private boolean estacionamento;

	public Funcionario(int id, String nome, double salario, boolean estacionamento) {
		super(id, nome);
		this.salario = salario;
		this.estacionamento = estacionamento;
	}
}
