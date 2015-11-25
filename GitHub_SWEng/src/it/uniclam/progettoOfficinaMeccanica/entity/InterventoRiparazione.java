package it.uniclam.progettoOfficinaMeccanica.entity;

public class InterventoRiparazione {

	private String marcaVeicolo;
	private String modelloVeicolo;
	private String dataEntrataInOfficina;
	private String dataImmatricolazione;

	public InterventoRiparazione(String marcaVeicolo, String modelloVeicolo, String dataEntrataInOfficina,
			String dataImmatricolazione) {
		super();
		this.marcaVeicolo = marcaVeicolo;
		this.modelloVeicolo = modelloVeicolo;
		this.dataEntrataInOfficina = dataEntrataInOfficina;
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

	public void setDataEntrataInOfficina(String dataEntrataInOfficina) {
		this.dataEntrataInOfficina = dataEntrataInOfficina;
	}

	public String getDataImmatricolazione() {
		return dataImmatricolazione;
	}

	public void setDataImmatricolazione(String dataImmatricolazione) {
		this.dataImmatricolazione = dataImmatricolazione;
	}


}
