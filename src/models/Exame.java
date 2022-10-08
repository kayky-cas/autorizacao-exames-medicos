package models;

import enums.TipoExames;

import java.util.Date;

public class Exame {

    private TipoExames tipo;

    private boolean realizado;

    private Date data;

    public Exame(TipoExames tipo) {
        this.tipo = tipo;
        realizado = false;
        this.data = null;
    }

    public TipoExames getTipo() {
        return tipo;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public Date getData() {
        return data;
    }

    public void realizarExame() {
        realizado = true;
        data = new Date();
    }

    @Override
    public String toString() {
        return String.format("""
                Exame:\s
                \t\tTipo: %s
                \t\t%s""", tipo.getNome(), isRealizado() ? "Realizado: Sim\n\tData: " + data.toString() : "Realizado: Não");
    }
}
