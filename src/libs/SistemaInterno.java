package libs;

import exceptions.UserException;
import models.*;

import java.util.ArrayList;

public class SistemaInterno {
	private final ArrayList<Usuario> usuarios;
	private Usuario administrador;
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
				((TemAutorizacoes) usuario).getAutorizacoes().forEach(a -> {
					if (!autorizacoes.contains(a))
						autorizacoes.add(a);
				});

		return autorizacoes;
	}

	public int quantMedico() {
		int quant = 0;

		for (Usuario usuario : usuarios)
			if (usuario.isFuncionario() && ((Funcionario) usuario).isMedico())
				quant++;

		return quant;
	}

	public int quantPaciente() {
		int quant = 0;

		for (Usuario usuario : usuarios)
			if (usuario.isPaciente())
				quant++;

		return quant;
	}

	public int quantAutorizacoes() {
		return autorizacoes.size();
	}

	public ArrayList<Exame> examesRealizados() {
		ArrayList<Exame> exames = new ArrayList<>();

		for (Autorizacao autorizacao : autorizacoes)
			if (autorizacao.getExame().isRealizado())
				exames.add(autorizacao.getExame());

		return exames;
	}

	public double folhaSalarial() {
		double folha = 0;

		for (Usuario usuario : usuarios)
			if (usuario.isFuncionario())
				folha += ((Funcionario) usuario).getSalario();

		return folha;
	}

	public boolean addAutorizacao(Autorizacao autorizacao) {
		return autorizacoes.add(autorizacao)
				&& autorizacao.getMedico().addAutorizacao(autorizacao)
				&& autorizacao.getPaciente().addAutorizacao(autorizacao);
	}

	public void isLogado() throws UserException {
		if (administrador == null)
			throw new UserException("Invalid user", "O usuário não está logado!");

		if (!administrador.isFuncionario())
			throw new UserException("Invalid user", "O usuário não pode acessar o Sitema Interno");

		if (!((Funcionario) administrador).isAdministrador())
			throw new UserException("Invalid user", "O usuário não pode acessar o Sitema Interno");
	}
}
