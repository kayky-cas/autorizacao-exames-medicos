package models;

import enums.TipoExames;

import java.util.Date;

public class Exame {

	private TipoExames tipo;

	private boolean realizado;

	private Date data;

	public TipoExames getTipo() {
		return tipo;
	}

	public boolean isRealizado() {
		return realizado;
	}

	public Date getData() {
		return data;
	}

	
}
