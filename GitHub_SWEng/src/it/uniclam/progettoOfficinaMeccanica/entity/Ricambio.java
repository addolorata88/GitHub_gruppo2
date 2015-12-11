package it.uniclam.progettoOfficinaMeccanica.entity;

/*Entità riferita alla tabella "ricambio" in cui si tiene traccia 
 * di tutti i pezzi di ricambio presenti in magazzino che verranno 
 * utilizzati dai meccanici per effettuare la riparazione*/

public class Ricambio {

	private String nomeRicambio;
	private boolean garanzia;   //Questo attributo riporta la validità o meno 
	                            //della garanzia sul pezzo di ricambio
	private float prezzo; 

	//COSTRUTTORE
	public Ricambio(String nomeRicambio, boolean garanzia, float prezzo) {
		super();
		this.nomeRicambio = nomeRicambio;
		this.garanzia = garanzia;
		this.prezzo = prezzo;
	}

	public boolean isGaranzia() {
		return garanzia;
	}					

	public void setGaranzia(boolean garanzia) {
		this.garanzia = garanzia;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public String getNomeRicambio() {
		return nomeRicambio;
	}

	public void setNomeRicambio(String nomeRicambio) {
		this.nomeRicambio = nomeRicambio;
	}
}