package libs;

import enums.TipoExames;
import exceptions.UserException;
import models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class SistemaInterno {
    private final ArrayList<Usuario> usuarios;
    private Usuario usuario;
    private final ArrayList<Autorizacao> autorizacoes;

    private int estacionamento;

    public SistemaInterno(int estacionamento) {
        this.usuarios = new ArrayList<>();
        this.usuario = null;
        this.autorizacoes = new ArrayList<>();
        this.estacionamento = estacionamento;
    }

    private void isLogado() throws UserException {
        if (usuario == null)
            throw new UserException("Nenhum usuário logado!");
    }

    public void login(int id) throws UserException {
        if (usuario != null)
            throw new UserException("Usuário já logado!");

        for (Usuario u : usuarios)
            if (u.getId() == id) {
                usuario = u;
                return;
            }

        throw new UserException("Identificador inválido");
    }

    public void logout() throws UserException {
        isLogado();
        this.usuario = null;
    }

    private void validUsuario(boolean condicao) throws UserException {
        if (!condicao)
            throw new UserException("Tipo de usuário inválido!");
    }

    private void validAdmin() throws UserException {
        validUsuario(this.usuario.isFuncionario() && ((Funcionario) this.usuario).isAdministrador());
    }

    private void validMedico() throws UserException {
        validUsuario(usuario.isFuncionario() && ((Funcionario) usuario).isMedico());
    }

    public boolean addUsuario(Usuario usuario) throws UserException {
        validAdmin();
        return usuarios.add(usuario);
    }

    public TemAutorizacoes listPacienteMedicoPorNome(String nome) throws UserException {
        validAdmin();

        for (Usuario usuario : usuarios)
            if (usuario instanceof TemAutorizacoes && usuario.getNome().equals(nome))
                return (TemAutorizacoes) usuario;

        throw new IllegalArgumentException("Nome não encontrado!");
    }

    public int quantMedico() throws UserException {
        validAdmin();

        int quant = 0;

        for (Usuario usuario : usuarios)
            if (usuario.isFuncionario() && ((Funcionario) usuario).isMedico())
                quant++;

        return quant;
    }

    public int quantPaciente() throws UserException {
        validAdmin();

        int quant = 0;

        for (Usuario usuario : usuarios)
            if (usuario.isPaciente())
                quant++;

        return quant;
    }

    public int quantAutorizacoes() throws UserException {
        validAdmin();

        return autorizacoes.size();
    }

    public double percentualAutorizacoesRealizadas() throws UserException {
        validAdmin();

        int cont = 0;

        for (Autorizacao autorizacao : autorizacoes)
            if (autorizacao.getExame().isRealizado())
                cont++;

        return ((double) cont) * 100 / autorizacoes.size();
    }

    public double folhaSalarial() throws UserException {
        validAdmin();

        double folha = 0;

        for (Usuario usuario : usuarios)
            if (usuario.isFuncionario())
                folha += ((Funcionario) usuario).getSalario();

        return folha;
    }

    public boolean addAutorizacao(Autorizacao autorizacao) throws UserException {
        validMedico();

        if (autorizacoes.add(autorizacao)
                && autorizacao.getMedico().addAutorizacao(autorizacao)
                && autorizacao.getPaciente().addAutorizacao(autorizacao)) {
            Collections.sort(autorizacoes);
            return true;
        }

        return false;
    }

    public ArrayList<Autorizacao> listaAutorizacaoPaciente(String cpf) throws UserException {
        validMedico();

        ArrayList<Autorizacao> autorizacoesPorPaciente = new ArrayList<>();

        for (Autorizacao autorizacao : autorizacoes)
            if (autorizacao.getPaciente().getCpf() == cpf)
                autorizacoesPorPaciente.add(autorizacao);

        return autorizacoesPorPaciente;
    }

    public ArrayList<Autorizacao> listaAutorizacaoTipo(TipoExames tipo) throws UserException {
        validMedico();

        ArrayList<Autorizacao> autorizacoesPorTipo = new ArrayList<>();

        for (Autorizacao autorizacao : autorizacoes)
            if (autorizacao.getExame().getTipo() == tipo)
                autorizacoesPorTipo.add(autorizacao);

        return autorizacoesPorTipo;
    }

    public boolean realizarExame(int codigoAutorizacao, Date dataAtual) throws UserException {
        validUsuario(usuario.isPaciente());

        Paciente paciente = (Paciente) usuario;

        for (Autorizacao autorizacao : paciente.getAutorizacoes()) {
            if (autorizacao.getCodigo() == codigoAutorizacao) {
                if (autorizacao.getDataCadastro().after(dataAtual) &&
                        diferencaEntreDias(autorizacao.getDataCadastro(), dataAtual) <= 30) {
                    autorizacao.getExame().realizarExame();
                    return true;
                } else
                    return false;

            }
        }

        return false;
    }

    public ArrayList<Autorizacao> listarMinhasAutorizacoes() throws UserException {
        validUsuario(usuario.isPaciente());
        validMedico();

        return ((Paciente) usuario).getAutorizacoes();
    }

    private int diferencaEntreDias(Date date1, Date date2) {
        long mili = date2.getTime() - date1.getTime();
        return (int) (mili / 1000 / 60 / 60 / 24);
    }

    private int vagasLivresNoEstacionamento() throws UserException {
        validAdmin();

        int quant = 0;

        for (Usuario usuario : usuarios)
            if (usuario.isFuncionario() && ((Funcionario) usuario).estaEstacionado())
                quant++;

        return estacionamento - quant;
    }
}
