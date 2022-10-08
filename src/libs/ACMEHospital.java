package libs;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import enums.Especializacao;
import enums.TipoExames;
import exceptions.UserException;
import models.*;

public class ACMEHospital {

    public final int MAX_ESTACIONAMENTO = 1000;

    private SistemaInterno sistemaInt = new SistemaInterno(MAX_ESTACIONAMENTO);

    private final Scanner entrada = new Scanner(System.in);

    public void inicializa() {
        Medico medico = new Medico("Jorge", 5500.0, Especializacao.CARDIOLOGISTA, true);
        Paciente paciente = new Paciente("Carlos", "000.000.000-00");
        Administrador adm = new Administrador("Marcela", 11000.0, true, 1);

        ArrayList<Usuario> usuarios = new ArrayList<>();

        usuarios.add(medico);
        usuarios.add(paciente);
        usuarios.add(adm);

        sistemaInt = new SistemaInterno(MAX_ESTACIONAMENTO, usuarios);

        System.out.printf("""
                        Usuários pré-cadastrados:\s
                        \tid: %d %s (Médico)
                        \tid: %d %s (Paciente)
                        \tid: %d %s (Administrador (Código de Autorização: %d))""",
                medico.getId(),
                medico.getNome(),
                paciente.getId(),
                paciente.getNome(),
                adm.getId(),
                adm.getNome(),
                adm.getAuthNumber());
    }

    public void executa() {
        int opcao = 0;
        do {
            if (sistemaInt.getUsuario() == null) {
                opcao = semUsuario();
                continue;
            }
            if (sistemaInt.getUsuario().isPaciente()) {
                opcao = escolhaPac();
                continue;
            }
            if (sistemaInt.getUsuario().isFuncionario()) {
                Funcionario funcionario = (Funcionario) sistemaInt.getUsuario();

                if (funcionario.isMedico()) {
                    opcao = escolhaMed();
                    continue;
                }
                if (funcionario.isAdministrador()) {
                    opcao = escolhaAdmin();
                }
            }
        } while (opcao != 0);
    }

    public int semUsuario() {
        int opcao;
        menuInicial();
        opcao = entrada.nextInt();
        switch (opcao) {
            case 0 -> {
                System.out.println("""
                        							 
                        Muito obrigado por utilizar ACME Hospital!\s
                        Volte sempre :)""");
            }
            case 1 -> {
                System.out.print("Id do usuário: ");
                try {
                    sistemaInt.login(entrada.nextInt());
                } catch (UserException e) {
                    System.out.println("Usuário inválido");
                    break;
                }
                if (sistemaInt.getUsuario() instanceof Administrador administrador) {
                    System.out.print("Código de Autorização: ");
                    int codigo = digitaOpcaoInt();

                    if (codigo != administrador.getAuthNumber()) {
                        System.out.println("Administrador incorreto!");
                        try {
                            sistemaInt.logout();
                        } catch (UserException ignore) {
                        }
                    }
                }
            }
        }
        return opcao;
    }

    public void menuInicial() {
        System.out.println("""                				
                \n[0] Sair do sistema\s
                [1] Login\s""");
    }

    public void menuAdm() {
        System.out.println(""" 				
                > MENU ADMINISTRADOR\s
                				
                O que deseja fazer?\s
                (Selecione a opcao abaixo digitando o numero indicado)\s
                				
                [0] Sair do sistema\s
                [1] Cadastrar novo usuario\s
                [2] Buscar por nome\s
                [3] Estatisticas gerais\s
                [4] Ver folha salarial dos funcionarios\s
                [5] Checar vagas do estacionamento do hospital\s
                [6] Trocar de usuario\s
                				
                Digite a opcao desejada:\s""");
    }

    private void trocaUsuario() {
        try {
            sistemaInt.logout();
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    public int escolhaAdmin() {
        menuAdm();
        int opcao = entrada.nextInt();
        switch (opcao) {
            case 0 -> {
                System.out.println("""
                        	 
                        Muito obrigado por utilizar ACME Hospital!\s
                        Volte sempre :)""");
            }
            case 1 -> {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
                try {
                    cadastraUsuario();
                } catch (UserException e) {
                    System.out.println(e.getMessage());
                    Usuario.invalidarUsuario();
                }
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
            }
            case 2 -> {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
                buscaPorNome();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
            }
            case 3 -> {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
                estatGerais();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
            }
            case 4 -> {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
                checaFolhaSalarial();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
            }
            case 5 -> {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
                checaEstacionamento();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
            }
            case 6 -> {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
                trocaUsuario();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
            }
            default -> System.out.println("Opção inválida!");
        }
        return opcao;
    }

    private void cadastraUsuario() throws UserException {
        System.out.println("""
                				
                Vamos comecar o cadastro de um novo usuario!\s
                				
                > Voce quer cadastrar:\s
                [1] Administrador
                [2] Medico\s
                [3] Paciente\s
                """);
        int opcao = digitaOpcaoInt();
        entrada.nextLine();

        switch (opcao) {
            case 1 -> {
                System.out.print("\nDigite o nome: ");
                String nome = entrada.nextLine();
                entrada.nextLine();
                System.out.print("\nDigite o salário: ");
                double salario = entrada.nextDouble();

                System.out.print("\nDigite o código de autenticação: ");
                int authnumber = entrada.nextInt();

                System.out.println("""
                        						
                        Voce esta estacionado no estacionamento?
                        						
                        [Y] Sim\s
                        [N] Nao\s""");
                boolean valido;
                boolean estacionado = false;
                do {
                    valido = true;
                    char c = digitaOpcaoChar();

                    switch (c) {
                        case 'Y' -> {
                            estacionado = true;
                        }
                        case 'N' -> {
                            checaEstacionamento();
                        }
                        default -> valido = false;
                    }
                } while (!valido);
                sistemaInt.addUsuario(new Administrador(nome, salario, estacionado, authnumber));
            }
            case 2 -> {
                System.out.print("\nDigite o nome: ");
                String nome = entrada.nextLine();
                System.out.print("\nDigite o salário: ");
                double salario = entrada.nextDouble();

                int i = 0;

                for (Especializacao e : Especializacao.values()) {
                    System.out.printf("[%d] %s", i++, e.getNome());
                }

                Especializacao especializacao;

                do {
                    try {
                        System.out.print("Especialização: ");
                        especializacao = Especializacao.values()[digitaOpcaoInt()];
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Especialização invalida!");
                        especializacao = null;
                    }
                } while (especializacao == null);

                System.out.println("""
                        						
                        Voce esta estacionado no estacionamento?
                        						
                        [Y] Sim\s
                        [N] Nao\s""");
                boolean valido;
                boolean estacionado = false;
                do {
                    valido = true;
                    char c = digitaOpcaoChar();

                    switch (c) {
                        case 'Y' -> {
                            estacionado = true;
                        }
                        case 'N' -> {
                            checaEstacionamento();
                        }
                        default -> valido = false;
                    }
                } while (!valido);
                sistemaInt.addUsuario(new Medico(nome, salario, especializacao, estacionado));
            }

            case 3 -> {
                System.out.print("\nDigite o nome: ");
                String nome = entrada.nextLine();

                System.out.println("CPF: ");
                String cpf = entrada.nextLine();

                sistemaInt.addUsuario(new Paciente(nome, cpf));

            }
            default -> System.out.println("Opção inválida!");
        }
    }

    private void buscaPorNome() {
        System.out.println("Nome: ");
        entrada.nextLine();
        TemAutorizacoes usuario;
        try {
            usuario = sistemaInt.listPacienteMedicoPorNome(entrada.nextLine());
        } catch (UserException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(usuario);

        for (Autorizacao autorizacao : usuario.getAutorizacoes()) {
            System.out.println(autorizacao);
        }
    }


    private void estatGerais() {
        try {
            System.out.printf("Número de Médicos: %d\n" +
                    "Número de Pacientes: %d\n" +
                    "Número de Autorizações emitidas: %d\n" +
                    "Percentual de exames realizados: %.2f%%\n", sistemaInt.quantMedico(), sistemaInt.quantPaciente(), sistemaInt.quantAutorizacoes(), sistemaInt.percentualAutorizacoesRealizadas());
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checaFolhaSalarial() {
        try {
            System.out.println("Folha salárial: R$ " + sistemaInt.folhaSalarial());
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checaEstacionamento() {
        try {
            System.out.println("Vagas disponíveis: " + sistemaInt.vagasLivresNoEstacionamento());
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    public void menuMed() {
        System.out.println("""			
                > MENU MEDICO\s
                				
                O que deseja fazer?\s
                (Selecione a opcao abaixo digitando o numero indicado)\s
                				
                [0] Sair do sistema\s
                [1] Listar autorizacoes de exame POR PACIENTE\s
                [2] Listar autorizacoes de exame POR TIPO DE EXAME\s
                [3] Adicionar autorização\s
                [4] Trocar de usuario\s
                				
                Digite a opcao desejada:\040""");
    }

    public int escolhaMed() {
        menuMed();
        int opcao = digitaOpcaoInt();
        entrada.nextLine();
        switch (opcao) {
            case 0 -> {
                System.out.println("""
                        	 
                        Muito obrigado por utilizar ACME Hospital!\s
                        Volte sempre :)""");
            }
            case 1 -> {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
                listaAutorizacoesPorPaciente();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
            }
            case 2 -> {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
                listaAutorizacoesPorTipo();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
            }
            case 3 -> {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
                adicionarAutorizacao();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
            }
            case 4 -> {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
                trocaUsuario();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
            }
            default -> System.out.println("Opção inválida!");
        }
        return opcao;
    }

    private void adicionarAutorizacao() {
        Paciente paciente = getPaciente();
        Exame exame = new Exame(getTipoExames());
        Medico medico = (Medico) sistemaInt.getUsuario();

        try {
            sistemaInt.addAutorizacao(new Autorizacao(new Date(), medico, paciente, exame));
        } catch (UserException e) {
            System.out.println(e.getMessage());
            Autorizacao.invalidarAutorizacao();
        }
    }

    private void listaAutorizacoesPorPaciente() {
        Paciente paciente = getPaciente();

        ArrayList<Autorizacao> autorizacaos;

        try {
            autorizacaos = sistemaInt.listaAutorizacaoPaciente(paciente.getCpf());
        } catch (UserException e) {
            System.out.println(e.getMessage());
            return;
        }

        autorizacaos.forEach(System.out::println);
    }

    private Paciente getPaciente() {
        ArrayList<Paciente> pacientes;
        try {
            pacientes = sistemaInt.listarPacientes();
        } catch (UserException e) {
            System.out.println(e.getMessage());
            return null;
        }

        int i = 0;

        for (Paciente p : pacientes)
            System.out.printf("[%d] %s\n", i++, p.getCpf());

        System.out.println("Paciente você deseja ver as autorizações: ");

        Paciente paciente = null;

        do {
            try {
                System.out.print("Paciente: ");
                paciente = pacientes.get(digitaOpcaoInt());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Paciente inválido!");
                pacientes = null;
            }
        } while (paciente == null);
        return paciente;
    }

    private void listaAutorizacoesPorTipo() {
        TipoExames tipoExames = getTipoExames();

        ArrayList<Autorizacao> autorizacaos;

        try {
            autorizacaos = sistemaInt.listaAutorizacaoTipo(tipoExames);
        } catch (UserException e) {
            System.out.println(e.getMessage());
            return;
        }

        autorizacaos.forEach(System.out::println);
    }

    private TipoExames getTipoExames() {
        int i = 0;

        for (TipoExames tipoExames : TipoExames.values()) {
            System.out.printf("[%d] %s\n", i++, tipoExames.getNome());
        }

        System.out.println("Tipo de exame você deseja ver as autorizações: ");

        TipoExames tipoExames;

        do {
            try {
                System.out.print("Tipo de Exame: ");
                tipoExames = TipoExames.values()[digitaOpcaoInt()];
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Tipo de exame inválido!");
                tipoExames = null;
            }
        } while (tipoExames == null);
        return tipoExames;
    }

    public void menuPac() {
        System.out.println("""
                > MENU PACIENTE\s
                				
                O que deseja fazer?\s
                (Selecione a opcao abaixo digitando o numero indicado)\s
                				
                [0] Sair do sistema\s
                [1] Marcar exame como realizado\s
                [2] Listar minhas autorizacoes de exame\s
                [3] Trocar de usuario\s
                				
                Digite a opcao desejada:\040""");
    }

    public int escolhaPac() {
        menuPac();
        int opcao = digitaOpcaoInt();
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
                listaMinhasAutorizacoes();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
            }
            case 3 -> {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
                trocaUsuario();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<\n");
            }
            default -> System.out.println("Opção Inválida!");
        }

        return opcao;
    }

    private void exameRealizado() {
        System.out.print("Código da autorização: ");
        try {
            sistemaInt.realizarExame(digitaOpcaoInt(), new Date());
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listaMinhasAutorizacoes() {
        try {
            sistemaInt.listarMinhasAutorizacoes();
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    private int digitaOpcaoInt() {
        return entrada.nextInt();
    }

    private char digitaOpcaoChar() {
        return entrada.next().charAt(0);
    }
}