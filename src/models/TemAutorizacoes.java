package models;

import java.util.ArrayList;

public interface TemAutorizacoes {
    ArrayList<Autorizacao> getAutorizacoes();

    boolean addAutorizacao(Autorizacao autorizacao);

    boolean removeAutorizacao(int codigoAutorizacao);
}
