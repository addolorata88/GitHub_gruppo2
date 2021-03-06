package it.uniclam.progettoOfficinaMeccanica.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/*In questa classe � definita l'entit� riferita alla scheda di 
 * riparazione che viene creata all'entrata del veicolo in officina*/
public class SchedaRiparazione {

	private String marcaVeicolo;
	private String modelloVeicolo;
	private String dataEntrataInOfficina;
	private String dataImmatricolazione;
	private String descrizioneIntervento;
	private String dataEvasioneRichiesta;
	private String nomeCliente;
	private String cognomeCliente;
	private String telCliente;
	private String emailCliente;
	private int idMeccanico;

	public SchedaRiparazione(String marcaVeicolo, String modelloVeicolo, String dataEntrataInOfficina,
			String dataImmatricolazione, String descrizioneIntervento, String dataEvasioneRichiesta, 
			String nomeCliente, String cognomeCliente, String telCliente, String emailCliente, int idMeccanico) {
		super();
		this.marcaVeicolo = marcaVeicolo;
		this.modelloVeicolo = modelloVeicolo;
		
		/*Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.dataEntrataInOfficina = sdf.format(today); */
		this.dataEntrataInOfficina = dataEntrataInOfficina;
		
		this.dataImmatricolazione = dataImmatricolazione;
		this.descrizioneIntervento = descrizioneIntervento;
		this.dataEvasioneRichiesta = dataEvasioneRichiesta;
		this.nomeCliente = nomeCliente;
		this.cognomeCliente = cognomeCliente;
		this.telCliente = telCliente;
		this.idMeccanico = idMeccanico;
		this.emailCliente = emailCliente;
	}
	
	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public int getIdMeccanico() {
		return idMeccanico;
	}

	public void setIdMeccanico(int idMeccanico) {
		this.idMeccanico = idMeccanico;
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

	public String getDataEvasioneRichiesta() {
		return dataEvasioneRichiesta;
	}

	public void setData_evasione_richiesta(String dataEvasioneRichiesta) {
		this.dataEvasioneRichiesta = dataEvasioneRichiesta;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCognomeCliente() {
		return cognomeCliente;
	}

	public void setCognomeCliente(String cognomeCliente) {
		this.cognomeCliente = cognomeCliente;
	}

	public String getTelCliente() {
		return telCliente;
	}

	public void setTelCliente(String telCliente) {
		this.telCliente = telCliente;
	}

	public String toString(){
		return this.getMarcaVeicolo() + "," + this.getModelloVeicolo() + "," + 
				this.getDataEntrataInOfficina() + "," + this.getDataImmatricolazione() + "," + 
				this.getDescrizioneIntervento() + "," + this.getDataEvasioneRichiesta() + "," + 
				this.getNomeCliente() + "," + this.getCognomeCliente() + "," +
				this.getTelCliente() + "," + this.getEmailCliente() + "," + this.getIdMeccanico();
	}
	
}
