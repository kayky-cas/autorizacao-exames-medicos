package libs;

import models.Administrador;
import models.Autorizacao;
import models.Paciente;
import models.Usuario;

import java.util.ArrayList;

public class SistemaInterno {
	private ArrayList<Usuario> usuarios;
	private Administrador administrador;
	private ArrayList<Autorizacao> autorizacoes;

	public SistemaInterno() {
		this.usuarios = new ArrayList<>();
		this.administrador = null;
		this.autorizacoes = new ArrayList<>();
	}
}
