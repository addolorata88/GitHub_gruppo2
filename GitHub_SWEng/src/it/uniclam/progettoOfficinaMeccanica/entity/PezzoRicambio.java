package it.uniclam.progettoOfficinaMeccanica.entity;

public class PezzoRicambio {

	private boolean garanzia;
	private float prezzo;
	private int scortaMinima;

	public PezzoRicambio(boolean garanzia, float prezzo, int scortaMinima) {
		super();
		this.garanzia = garanzia;
		this.prezzo = prezzo;
		this.scortaMinima = scortaMinima;
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

	public int getScortaMinima() {
		return scortaMinima;
	}

	public void setScortaMinima(int scortaMinima) {
		this.scortaMinima = scortaMinima;
	}

}
