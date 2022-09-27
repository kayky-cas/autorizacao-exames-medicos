package models;

public abstract class Usuario {

	private static int actualId = 0;

	private int id;

	private String nome;

	public Usuario(String nome) {
		id = actualId++;
		this.nome = nome;
	}

	public boolean isFucionario() {
		return this instanceof Funcionario;
	}

	public boolean isPaciente() {
		return this instanceof Paciente;
	}
}
