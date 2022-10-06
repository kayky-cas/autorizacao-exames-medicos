package libs;

import models.*;

import java.util.ArrayList;

public class SistemaInterno {
	private final ArrayList<Usuario> usuarios;
	private Administrador administrador;
	private final ArrayList<Autorizacao> autorizacoes;

	public SistemaInterno() {
		this.usuarios = new ArrayList<>();
		this.administrador = null;
		this.autorizacoes = new ArrayList<>();
	}

	public boolean addUsuario(Usuario usuario) {
		return usuarios.add(usuario);
	}

	public ArrayList<Autorizacao> searchAutorizacaoPorNome(String nome) {
		ArrayList<Autorizacao> autorizacoes = new ArrayList<>();
		for (Usuario usuario : usuarios)
			if (usuario instanceof TemAutorizacoes && usuario.getNome().equals(nome))
				autorizacoes.addAll(((TemAutorizacoes) usuario).getAutorizacoes());

		return autorizacoes;
	}

	public int quantMedico() {
		int quant = 0;
		for (Usuario usuario : usuarios) {
			if (usuario.isFuncionario() && ((Funcionario) usuario).isMedico())
				quant++;
		}
		return quant;
	}

	public int quantPaciente() {
		int quant = 0;
		for (Usuario usuario : usuarios) {
			if (usuario.isPaciente())
				quant++;
		}
		return quant;
	}
}
