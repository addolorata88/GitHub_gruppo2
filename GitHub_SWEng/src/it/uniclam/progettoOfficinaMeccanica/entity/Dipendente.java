package it.uniclam.progettoOfficinaMeccanica.entity;

public class Dipendente {

	private String nome;
	private String cognome;
	private int telefono;
	private String email;
	private String dataAssunzione;
	private String scadenzaContratto;


	public Dipendente(String nome, String cognome, int telefono, String email, String dataAssunzione,
			String scadenzaContratto) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
		this.dataAssunzione = dataAssunzione;
		this.scadenzaContratto = scadenzaContratto;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDataAssunzione() {
		return dataAssunzione;
	}


	public void setDataAssunzione(String dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}


	public String getScadenzaContratto() {
		return scadenzaContratto;
	}


	public void setScadenzaContratto(String scadenzaContratto) {
		this.scadenzaContratto = scadenzaContratto;
	}



}
