package libs;

import java.io.IOException;
import java.util.Scanner;

import enums.Especializacao;
import enums.TipoExames;
import exceptions.InvalidOption;
import exceptions.UserException;
import models.*;

public class ACMEHospital {

	private final SistemaInterno sistemaInt = new SistemaInterno(1000);

	private final Scanner entrada = new Scanner(System.in);

	private Usuario usuarioAtual;

	public void inicializa() {
		Medico medico = new Medico("Jorge", 5500.0, Especializacao.CARDIOLOGISTA, true);
		Paciente paciente = new Paciente("Carlos", "000.000.000-00");
		Administrador adm = new Administrador("Marcela", 11000.0, true, 1);
	}

	public void executa() throws InvalidOption, UserException {
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

				Escolha a forma que voce deseja entrar no sistema: \s
								
				[0] Sair do sistema\s
				[1] Entrar como Administrador\s
				[2] Entrar como Medico\s
				[3] Entrar como Paciente\s""");
	}

	public void menuTroca() {
		System.out.println("""
    			
				\nVoce quer trocar para: \s
								
				[0] Sair do sistema\s
				[1] Administrador\s
				[2] Medico\s
				[3] Paciente\s""");
	}

	public void menuAdm() throws InvalidOption, UserException {
		sistemaInt.login(usuarioAtual.getId());
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

	private void trocaUsuario() throws InvalidOption, UserException {
		int opcao;
		do {
			menuTroca();
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

	public void escolhaAdmin() throws InvalidOption, UserException {
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
				case 1 -> {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
					cadastraUsuario();
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
				}
				case 2 -> {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
					buscaMedico();
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
				}
				case 3 -> {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
					buscaPaciente();
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
				}
				case 4 -> {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
					estatGerais();
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
				}
				case 5 -> {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
					checaFolhaSalarial();
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
				}
				case 6 -> {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
					checaEstacionamento();
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
				}
				case 7 -> {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
					trocaUsuario();
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
				}
				default -> throw (new InvalidOption("""
						Opcao Invalida :/
						Por favor, digite novamente.
											 
						Reiniciando menu...\s"""));
			}
		} while (opcao!=0);
	}

	private void cadastraUsuario() {
		int opcao = digitaOpcaoInt();
		entrada.nextLine();
		System.out.println("""
				
				Vamos comecar o cadastro de um novo usuario!\s
				
				> Voce quer cadastrar:\s
				[1] Administrador
				[2] Medico\s
				[3] Paciente\s
				""");
		switch (opcao) {
			case 1 -> {
				System.out.print("\nDigite o nome: \n> ");
				String nome = entrada.nextLine();
				entrada.nextLine();
				System.out.print("""

						Digite o cpf:\s
						(digite no formato - 000.000.000-00)

						 >\s""");
				String cpf = entrada.nextLine();
				System.out.println("""
						
						Voce esta estacionado no estacionamento?
						
						[Y] Sim\s
						[N] Nao\s""");

			}
		}
	}

	private void buscaMedico() {
	}

	private void buscaPaciente() {
	}

	private void estatGerais() {
	}

	private void checaFolhaSalarial(){
	}

	private int checaEstacionamento(){
		return 0;
	}

	public void menuMed() throws UserException {
		sistemaInt.login(usuarioAtual.getId());
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

	public void escolhaMed() throws InvalidOption, UserException {
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
				case 1 -> {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
					listaAutorizacoes();
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
				}
				case 2 -> {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
					listaAutorizacoes(p);
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
				}
				case 3 -> {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
					listaAutorizacoes(te);
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
				}
				case 4 -> {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
					trocaUsuario();
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
				}
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

	public void menuPac() throws UserException {
		sistemaInt.login(usuarioAtual.getId());
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

	public void escolhaPac() throws InvalidOption, UserException {
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
				case 1 -> {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
					exameRealizado();
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
				}
				case 2 -> {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
					listaMinhasAutorizacoes(p);
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
				}
				case 3 -> {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
					trocaUsuario();
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
				}
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