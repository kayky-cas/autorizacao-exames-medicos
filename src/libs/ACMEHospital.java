package libs;
import java.util.Scanner;

import enums.Especializacao;
import models.*;

public class ACMEHospital {

	private final SistemaInterno sistema = new SistemaInterno();

	private Usuario usuarioAtual;

	public void inicializa() {
		Medico medico = new Medico("Jorge", 5500.0, Especializacao.CARDIOLOGISTA, true);
		Paciente paciente = new Paciente("Carlos", "000.000.000-00");
		Administrador adm = new Administrador("Marcela", 11000.0, true, 1);
	}

	public void executa() {

	}
}