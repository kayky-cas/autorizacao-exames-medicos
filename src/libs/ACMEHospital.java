package libs;

import java.io.IOException;
import java.util.Scanner;

import enums.Especializacao;
import enums.TipoExames;
import exceptions.InvalidOption;
import models.*;

public class ACMEHospital {

<<<<<<< HEAD
	private final SistemaInterno sistemaInt = new SistemaInterno();

	//private final Sistema sistema = new Sistema();

	private final Scanner entrada = new Scanner(System.in);

=======
>>>>>>> 03cc2b2271e419db92cb2cf2298415b2749dea56
	private Usuario usuarioAtual;

	public void inicializa() {
		Medico medico = new Medico("Jorge", 5500.0, Especializacao.CARDIOLOGISTA, true);
		Paciente paciente = new Paciente("Carlos", "000.000.000-00");
		Administrador adm = new Administrador("Marcela", 11000.0, true, 1);
	}

	public void executa() throws InvalidOption {
		int opcao;
		do {
			menuInicial();
			opcao = entrada.nextInt();
			entrada.nextLine();
			switch(opcao){
				case 0 -> { System.out.println("""
							 
								Muito obrigado por utilizar ACME Hospital!\s
								Volte sempre :)""");
				}
				case 1 -> menuAdm();
				case 2 -> menuMed();
				case 3 -> menuPac();
			}

		} while (opcao!=0);
	}

	public void menuInicial() {
		System.out.println("""
    
				\n>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<\s
				
				Bem-vinde ao ACME Hospital!\s

				Escolha a forma que voce deseja entrar no sistema! \s
								
				[0] Sair do sistema\s
				[1] Entrar como Administrador\s
				[2] Entrar como Medico\s
				[3] Entrar como Paciente\s""");
	}

	public void menuAdm() throws InvalidOption {
		System.out.println("""
    
				\n>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<\s
								
				> Voce entrou como: ADMINISTRADOR\s
								
				>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<\s
								
				> MENU ADMINISTRADOR\s
								
				O que deseja fazer?\s
				(Selecione a opcao abaixo digitando o numero indicado)\s
								
				[0] Sair do sistema\s
				[1] Cadastrar novo usuario\s
				[2] Buscar um medico\s
				[3] Buscar um paciente\s
				[4] Estatisticas gerais\s
				[5] Ver folha salarial dos funcionarios\s
				[6] Checar vagas do estacionamento do hospital\s
				[7] Trocar de usuario\s
								
				Digite a opcao desejada:\s""");
		try {
			escolhaAdmin();
		} catch (Exception a) {
			System.err.println("Ocorreu um erro: " + a);
		}
	}

	private void trocaUsuario() {
	}

	public void escolhaAdmin() throws InvalidOption {
		int opcao;
		do{
			opcao = entrada.nextInt();;
			entrada.nextLine();
			switch (opcao) {
				case 0 -> {
					System.out.println("""
								 
							Muito obrigado por utilizar ACME Hospital!\s
							Volte sempre :)""");
				}
				case 1 -> cadastraUsuario();
				case 2 -> buscaMedico();
				case 3 -> buscaPaciente();
				case 4 -> estatGerais();
				case 5 -> checaFolhaSalarial();
				case 6 -> checaEstacionamento();
				case 7 -> trocaUsuario();
				default -> throw (new InvalidOption("""
						Opcao Invalida :/
						Por favor, digite novamente.
											 
						Reiniciando menu...\s"""));
			}
		} while (opcao!=0);
	}

	private void cadastraUsuario() {
	}

	private void buscaMedico() {
	}

	private void buscaPaciente() {
	}

	private void estatGerais() {
	}

	private void checaFolhaSalarial(){
	}

	private void checaEstacionamento(){
	}

	public void menuMed() {
		System.out.println("""
    
				\n>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<\s
				
				> Voce entrou como: MEDICO\s
				
				>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<\s
				
				> MENU MEDICO\s
				
				O que deseja fazer?\s
				(Selecione a opcao abaixo digitando o numero indicado)\s
				
				[0] Sair do sistema\s
				[1] Listar TODAS autorizacoes de exames\s
				[2] Listar autorizacoes de exame POR PACIENTE\s
				[3] Listar autorizacoes de exame POR TIPO DE EXAME\s
				[4] Trocar de usuario\s
				
				Digite a opcao desejada:\040""");
		try {
			escolhaMed();
		} catch (Exception a) {
			System.err.println("Ocorreu um erro: " + a);
		}
	}

	public void escolhaMed() throws InvalidOption {
		int opcao;
		Paciente p = null;
		TipoExames te = null;
		do {
			opcao = digitaOpcaoInt();
			entrada.nextLine();
			switch (opcao) {
				case 0 -> {
					System.out.println("""
								 
							Muito obrigado por utilizar ACME Hospital!\s
							Volte sempre :)""");
				}
				case 1 -> listaAutorizacoes();
				case 2 -> listaAutorizacoes(p);
				case 3 -> listaAutorizacoes(te);
				case 4 -> trocaUsuario();
				default -> throw (new InvalidOption("""
						Opcao Invalida :/
						Por favor, digite novamente.
											 
						Reiniciando menu...\s"""));
			}
		} while (opcao != 0);
	}

	private void listaAutorizacoes() {
	}

	private void listaAutorizacoes(Paciente paciente) {
	}

	private void listaAutorizacoes(TipoExames tipo) {
	}

	public void menuPac() {
		System.out.println("""
    
				\n>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<\s
				
				> Voce entrou como: PACIENTE\s
				
				>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<\s
				
				> MENU PACIENTE\s
				
				O que deseja fazer?\s
				(Selecione a opcao abaixo digitando o numero indicado)\s
				
				[0] Sair do sistema\s
				[1] Marcar exame como realizado\s
				[2] Listar minhas autorizacoes de exame\s
				[3] Trocar de usuario\s
				
				Digite a opcao desejada:\040""");

		try {
			escolhaPac();
		} catch (Exception a) {
			System.err.println("Ocorreu um erro: " + a);
		}
	}

	public void escolhaPac() throws InvalidOption {
		int opcao;
		Paciente p = null;
		do {
			opcao = digitaOpcaoInt();
			entrada.nextLine();
			switch (opcao) {
				case 0 -> {
					System.out.println("""
								 
							Muito obrigado por utilizar ACME Hospital!\s
							Volte sempre :)""");
				}
				case 1 -> exameRealizado();
				case 2 -> listaMinhasAutorizacoes(p);
				case 3 -> trocaUsuario();
				default -> throw (new InvalidOption("""
						Opcao Invalida :/
						Por favor, digite novamente.
											 
						Reiniciando menu...\s"""));
			}
		} while (opcao != 0);
	}

	private void exameRealizado() {
	}

	private void listaMinhasAutorizacoes(Paciente p) {
	}

	private int digitaOpcaoInt(){
		return entrada.nextInt();
	}

	private char digitaOpcaoChar() {
		return entrada.next().charAt(0);
	}
}