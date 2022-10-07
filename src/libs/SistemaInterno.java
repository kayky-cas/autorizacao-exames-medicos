package libs;

import enums.TipoExames;
import models.*;

import java.util.ArrayList;

public class SistemaInterno {
	private ArrayList<Usuario> usuarios;
	private Administrador adm;
	private ArrayList<Autorizacao> autorizacoes;

	SistemaInterno(Administrador adm) {
		this.adm = adm;
		usuarios = new ArrayList<Usuario>();
		autorizacoes = new ArrayList<Autorizacao>();
	}

	void trocaUsuario(Usuario usuario) {

	}

	// • Métodos para Médicos

	boolean addAutorizacao(Autorizacao autorizacao) {
		return autorizacoes.add(autorizacao);
	}

	Autorizacao searchAutorizacao(Paciente paciente) {
		for (Autorizacao autorizacao : autorizacoes) {
			if (autorizacao.getPaciente().equals(paciente)){
				return autorizacao;
			}
		}
		return null;
	}

	Autorizacao searchAutorizacao(TipoExames tipoExame) {
		for (Autorizacao autorizacao : autorizacoes) {
			if(autorizacao.getExame().getTipo().equals(tipoExame)) {
				return autorizacao;
			}
		}
		return null;
	}

	// • Métodos para Pacientes

	boolean exameRealizado(Exame exame) {
		if(exame.isRealizado() == false){
			exame.setRealizado(true);
			return true;
		}
		return false;
	}

	// • Métodos para Administradores

	boolean addUsuario(Usuario usuario) {
		return usuarios.add(usuario);
	}

	Medico searchUsuario(Medico medico) {
		for (Usuario usuario : usuarios) {
			if(usuario instanceof Medico) {
				return (Medico) usuario;
			}
		}
		return null;
	}

	Paciente searchUsuario(Paciente paciente) {
		for (Usuario usuario : usuarios) {
			if(usuario instanceof Paciente) {
				return (Paciente) usuario;
			}
		}
		return null;
	}

	/* - feito na ACMEHospital
	Usuario[] verEstatisticasGerais(Usuario usuario) {
		return null;
	}
	 */

	int quantMedico() {
		int cont = 0;
		for (Usuario usuario : usuarios) {
			if(usuario instanceof Medico) {
				cont++;;
			}
		}
		return cont;
	}

	int quantPaciente() {
		int cont = 0;
		for (Usuario usuario : usuarios) {
			if(usuario instanceof Paciente) {
				cont++;;
			}
		}
		return cont;
	}

	int quantAutorizacao() {
		return autorizacoes.size();
	}

	double examesRealizados() {
		int cont = 0;
		for (Autorizacao autorizacao : autorizacoes) {
			if(autorizacao.getExame().isRealizado()) {
				cont++;
			}
		}
		return cont;
	}

	double folhaSalarial() {
		return 0;
	}

	Paciente[] pacientesPorExame(TipoExames tipoExame) {
		return null;
	}

	public Administrador getAdm() {
		return adm;
	}
}


/*
 1 - Escolher Usuario - a qualquer momento!
 2 - Incluir nova autorização
 3 -
 */
