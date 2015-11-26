package it.uniclam.progettoOfficinaMeccanica.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Richiesta {
	
	private String dataRichiesta;
	private String dataEvasione;
	
	public Richiesta() {
		super();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.dataRichiesta = sdf.format(today);
		}
	
	public String getDataRichiesta() {
		return dataRichiesta;
	}

	public String getDataEvasione() {
		return dataEvasione;
	}

	public void setDataEvasione(String dataEvasione) {
		this.dataEvasione = dataEvasione;
	}

}
