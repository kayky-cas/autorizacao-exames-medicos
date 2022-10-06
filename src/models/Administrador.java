package models;

public class Administrador extends Funcionario{

	private int authNumber;

	public Administrador(String nome, double salario, boolean estacionamento, int authNumber) {
		super(nome, salario, estacionamento);
		this.authNumber = authNumber;
	}
}
