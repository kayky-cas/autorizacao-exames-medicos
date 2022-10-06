package libs;
import java.util.Scanner;
import models.Usuario;

public class ACMEHospital {

	private SistemaInterno sistema;

	private Usuario usuarioAtual;

	private void selectUser(){
		System.out.println("Bem-vindo ao ACMEHospital");
		line();
		System.out.println("1 - Para entrar como Administrador");
		System.out.println("2 - Para entrar como Medico");
		System.out.println("3 - Para entrar como Paciente");
		line();
		System.out.print("Insira a opcao desejada:");
		String option = writeString();
	}

	private void selectRole(String option){
		switch (option) {
			case "1" -> {
				boolean validLogin = loginAdmin();
				if(validLogin){
					menuAdmin();
				}
				else {
					changeRole("1");
				}
			}
			case "2" -> {
				boolean validLogin = loginDoctor();
				if(validLogin){
					menuDoctor();
				}
				else {
					changeRole("2");
				}
			}
			case "3" -> {
				boolean validLogin = loginUser();
				if(validLogin){
				menuUser();
				}
				else{changeRole("3");}
			}
			default -> {
				System.out.println("Opçao invalida");
				selectUser();
			}
		}
	}
	private boolean loginAdmin(){return false;}
	private boolean loginDoctor(){return false;}
	private boolean loginUser(){return false;}
	private void changeRole(String option){
		System.out.println("Queres alterar o cargo selecionado?");
		System.out.println("Caso queira aperte 1:");
		String s = writeString();
		if (s.equals("1")) {
			selectUser();
		} else {
			selectRole(option);
		}
	}

	private void menuAdmin(){
		System.out.println("Menu do Administrador");
		line();
		System.out.println("1 - Cadastrar novo usuario");
		System.out.println("2 - Buscar um medico");
		System.out.println("3 - Buscar um paciente");
		System.out.println("4 - Estatisticas gerais");
		System.out.println("5 - Trocar Usuario");
		line();
		System.out.print("Insira a opcao desejada:");
		String option = writeString();
		choiceAdmin(option);
	}
	private void choiceAdmin(String option){
		switch (option) {
			case "1" -> {
				addUser();
				menuAdmin();
			}
			case "2" -> {
				searchDoctor();
				menuAdmin();
			}
			case "3" -> {
				searchPacient();
				menuAdmin();
			}
			case "4" -> {
				stats();
				menuAdmin();
			}
			case "5" -> selectUser();
			default -> menuAdmin();
		}
	}
	private void addUser(){}
	private void searchDoctor(){}
	private void searchPacient(){}
	private void stats(){  }
	private void menuUser(){
		System.out.println("Menu do Paciente:");
		line();
		System.out.println("1 - Marcar exame como realizado");
		System.out.println("2 - Listar minhas autorizacoes de exame");
		System.out.println("3 - Trocar Usuario");
		line();
		System.out.print("Insira a opcao desejada:");
		String option = writeString();
		choiceUser(option);
	}

	private void choiceUser(String option){
		switch (option) {
			case "1" -> {
				examDone();
				menuUser();
			}
			case "2" -> {
				listUserExams();
				menuUser();
			}
			case "3" -> selectUser();
			default -> menuUser();
		}
	}
	private void examDone(){}
	private void listUserExams(){}

	private void menuDoctor(){
		System.out.println("Menu do médico");
		line();
		System.out.println("1 - Listar todos as autorizacoes de exames");
		System.out.println("2 - Listar as autorizacoes de exames por paciente");
		System.out.println("3 - Listar as autorizacoes de exames por tipo de exame");
		System.out.println("4 - Trocar Usuario");
		line();
		System.out.print("Insira a opcao desejada:");
		String option = writeString();
		choiceDoctor(option);
	}

	private void choiceDoctor(String option){
		switch (option) {
			case "1" -> {
				listAllExam();
				menuDoctor();
			}
			case "2" -> {
				System.out.println("Insira o nome do paciente:");
				listExamPacient(writeString());
				menuDoctor();
			}
			case "3" -> {
				System.out.println("Insira o tipo do exame");
				listExamType(writeString());
				menuDoctor();}
			case "4" -> selectUser();
			default -> menuDoctor();
		}
	}
	private void listAllExam(){}
	private void listExamPacient(String name){}
	private void listExamType(String type){}


	private int writeInt(){
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	private String writeString(){
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
	private void line(){
		for (int i = 0; i < 51; i++) {
			System.out.print("-");
		}
		System.out.printf("\n");
	}
}