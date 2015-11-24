package it.uniclam.progettoOfficinaMeccanica.entity;

public class Meccanico extends Dipendente {

	public Meccanico(String nome, String cognome, int telefono, String email, String dataAssunzione,
			String scadenzaContratto) {
		super(nome, cognome, telefono, email, dataAssunzione, scadenzaContratto);
		// TODO Auto-generated constructor stub
	}

	private int caricoLavoro;

	public int getCaricoLavoro() {
		return caricoLavoro;
	}

	public void setCaricoLavoro(int caricoLavoro) {
		this.caricoLavoro = caricoLavoro;
	}


}
