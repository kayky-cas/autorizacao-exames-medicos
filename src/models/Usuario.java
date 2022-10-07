package models;

public abstract class Usuario {
	private static int actualId = 0;
	private int id;
	private String nome;

	public Usuario(String nome) {
		id = actualId++;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
