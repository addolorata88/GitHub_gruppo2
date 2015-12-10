package it.uniclam.progettoOfficinaMeccanica.entity;

public class Ricambio {

	private String nomeRicambio;
	private boolean garanzia;
	private float prezzo; 
	private int idSchedaRip;

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

	public int getIdSchedaRip() {
		return idSchedaRip;
	}

	public void setIdSchedaRip(int idSchedaRip) {
		this.idSchedaRip = idSchedaRip;
	}
}