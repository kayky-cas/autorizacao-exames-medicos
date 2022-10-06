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

	public ArrayList<Autorizacao> searchAutorizacaoPorNome(String cpf) {
		for (Usuario usuario : usuarios)
			if (usuario instanceof TemAutorizacoes && usuario.getCPF().equals(cpf))
				return ((TemAutorizacoes) usuario).getAutorizacoes();

		return null;
	}

	public int quantMedico() {
		int quant = 0;
		for (Usuario usuario : usuarios) {
			if (usuario.isMedico())
				quant++;
		}
		return quant;
	}

	public int quantMedico() {
		int quant = 0;
		for (Usuario usuario : usuarios) {
			if (usuario.isMedico())
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
