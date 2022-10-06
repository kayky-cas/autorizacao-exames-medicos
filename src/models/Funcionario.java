package models;

public abstract class Funcionario extends Usuario{
	private double salario;

	private boolean estacionamento;

	public Funcionario(String nome, double salario) {
		super(nome);
		this.salario = salario;
		estacionamento = true;
	}

	public boolean isMedico() {
		return this instanceof Medico;
	}

	public boolean isAdministrador() {
		return this instanceof Medico;
	}
}
