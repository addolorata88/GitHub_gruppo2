package it.uniclam.progettoOfficinaMeccanica.entity;

public class Ricambio {

	private boolean garanzia;
	private float prezzo;
	private boolean disponibilita;

	public Ricambio(boolean garanzia, float prezzo, boolean disponibilita) {
		super();
		this.garanzia = garanzia;
		this.prezzo = prezzo;
		this.disponibilita = disponibilita;
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

	public boolean isDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(boolean disponibilita) {
		this.disponibilita = disponibilita;
	}

}