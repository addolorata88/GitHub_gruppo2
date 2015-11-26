package it.uniclam.progettoOfficinaMeccanica.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InterventoRiparazione {

	private String marcaVeicolo;
	private String modelloVeicolo;
	private String dataEntrataInOfficina;
	private String dataImmatricolazione;
	private String descrizioneIntervento;


	public InterventoRiparazione(String marcaVeicolo, String modelloVeicolo, String dataImmatricolazione) {
		super();
		this.marcaVeicolo = marcaVeicolo;
		this.modelloVeicolo = modelloVeicolo;
		// Valutare se questa data è la stessa di quella presente in Richiesta.java
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.dataEntrataInOfficina = sdf.format(today);
		
		this.dataImmatricolazione = dataImmatricolazione;
	}

	public String getMarcaVeicolo() {
		return marcaVeicolo;
	}

	public void setMarcaVeicolo(String marcaVeicolo) {
		this.marcaVeicolo = marcaVeicolo;
	}

	public String getModelloVeicolo() {
		return modelloVeicolo;
	}

	public void setModelloVeicolo(String modelloVeicolo) {
		this.modelloVeicolo = modelloVeicolo;
	}

	public String getDataEntrataInOfficina() {
		return dataEntrataInOfficina;
	}

	public String getDataImmatricolazione() {
		return dataImmatricolazione;
	}

	public void setDataImmatricolazione(String dataImmatricolazione) {
		this.dataImmatricolazione = dataImmatricolazione;
	}

	public String getDescrizioneIntervento() {
		return descrizioneIntervento;
	}

	public void setDescrizioneIntervento(String descrizioneIntervento) {
		this.descrizioneIntervento = descrizioneIntervento;
	}
}
