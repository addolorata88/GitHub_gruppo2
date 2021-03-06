package it.uniclam.progettoOfficinaMeccanica.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.uniclam.progettoOfficinaMeccanica.entity.SchedaRiparazione;

public class SchedaRiparazioneDAOImpl implements SchedaRiparazioneDAO{

	private SchedaRiparazioneDAOImpl(){};

	private static SchedaRiparazioneDAO dao = null;

	public static SchedaRiparazioneDAO getInstance(){
		if (dao == null){
			dao = new SchedaRiparazioneDAOImpl();
		}
		return dao;
	}

	@Override
	public void insertSchedaRiparazione(SchedaRiparazione i) throws DAOException{
		try {
			if (	i.getMarcaVeicolo() == null ||
					i.getModelloVeicolo() == null ||
					i.getDataEntrataInOfficina() == null ||
					i.getDataImmatricolazione() == null ||
					i.getDescrizioneIntervento() == null ||
					i.getDataEvasioneRichiesta()== null ||
					i.getNomeCliente() == null ||
					i.getCognomeCliente() == null ||
					i.getTelCliente() == null ||
					i.getEmailCliente() == null ||
					i.getIdMeccanico() == 0){
				throw new DAOException("In insertSchedaRip: no one field can be empty");
			}

			Statement stm = DAOSettings.getStatement();

			String sql_insert = "INSERT INTO scheda_riparazione (marca_veicolo, modello_veicolo, "
					+ "data_entrata_officina, data_immatricolazione, descrizione_intervento, "
					+ "data_evasione_richiesta, nome_cliente, cognome_cliente, tel_cliente, email_cliente, id_meccanico) VALUES ('";
					sql_insert += i.getMarcaVeicolo() + "', '" + i.getModelloVeicolo() + "', '";
					sql_insert += i.getDataEntrataInOfficina() + "', '" + i.getDataImmatricolazione() + "', '";
					sql_insert += i.getDescrizioneIntervento() + "', '" + i.getDataEvasioneRichiesta() + "', '";
					sql_insert += i.getNomeCliente() + "', '" + i.getCognomeCliente() + "', '";
					sql_insert += i.getTelCliente() + "', '" + i.getEmailCliente() + "', '" + i.getIdMeccanico() + "')";

			System.out.println("Debug Query Inserimento: " + sql_insert);
			int inserimento = stm.executeUpdate(sql_insert);
			DAOSettings.closeStatement(stm);

		} catch (SQLException sqle) {
			throw new DAOException("In insertSchedaRiparazione: " + sqle);
		}	
	}

	@Override
	public void updateSchedaRiparazione(SchedaRiparazione i)  throws DAOException{
		try {
			if (	i.getMarcaVeicolo() == null ||
					i.getModelloVeicolo() == null ||
					i.getDataEntrataInOfficina() == null ||
					i.getDataImmatricolazione() == null ||
					i.getDescrizioneIntervento() == null ||
					i.getDataEvasioneRichiesta()== null ||
					i.getNomeCliente() == null ||
					i.getCognomeCliente() == null ||
					i.getTelCliente() == null ||
					i.getEmailCliente() == null ||
					i.getIdMeccanico() == 0){
				throw new DAOException("In updateSchedaRip: no one field can be empty");
			}

			Statement stm = DAOSettings.getStatement();

			String sql_update = "UPDATE scheda_riparazione SET ";
				sql_update += "marca_veicolo='" + i.getMarcaVeicolo() + "',";
				sql_update += "modello_veicolo='" + i.getModelloVeicolo() + "',";
				sql_update += "data_entrata_officina='" + i.getDataEntrataInOfficina() + "',";
				sql_update += "data_immatricolazione='" + i.getDataImmatricolazione() + "',";
				sql_update += "descrizione_intervento='" + i.getDescrizioneIntervento() + "',";
				sql_update += "data_evasione_richiesta='" + i.getDataEvasioneRichiesta() + "',";
				sql_update += "nome_cliente='" + i.getNomeCliente() + "',";
				sql_update += "cognome_cliente='" + i.getCognomeCliente() + "',";
				sql_update += "tel_cliente='" + i.getTelCliente() + "',";
				sql_update += "email_cliente='" + i.getEmailCliente() + "',";
				sql_update += "id_meccanico='" + i.getIdMeccanico() + "' ";
				sql_update += "WHERE email_cliente = '" + i.getEmailCliente() + "'";

			int aggiornamento = stm.executeUpdate(sql_update);  //come in insert. Modificare anche in SchedaRiparazioneDAOImpl(ResultSet->int)
			DAOSettings.closeStatement(stm);

		} catch (SQLException sqle) {
			throw new DAOException("In updateSchedaRiparazione: " + sqle);
		}			
	}

	@Override
	public List<SchedaRiparazione> showSchedaRiparazione(SchedaRiparazione i)  throws DAOException{
		ArrayList<SchedaRiparazione> elenco = new ArrayList<SchedaRiparazione>();
		
		System.out.println("Oggetto Scheda Rip: " + i);
		try {
			if (	i.getMarcaVeicolo() == null ||
					i.getModelloVeicolo() == null ||
					i.getDataEntrataInOfficina() == null ||
					i.getDataImmatricolazione() == null ||
					i.getDescrizioneIntervento() == null ||
					i.getDataEvasioneRichiesta()== null ||
					i.getNomeCliente() == null ||
					i.getCognomeCliente() == null ||
					i.getTelCliente()== null ||
					i.getEmailCliente()== null ||
					i.getIdMeccanico() == 0) {
				throw new DAOException("In showSchedaRiparazione: no one field can be empty");
			}

			Statement stm = DAOSettings.getStatement();
			
			String sql_find = "SELECT * FROM scheda_riparazione WHERE marca_veicolo LIKE '";
				sql_find += i.getMarcaVeicolo() + "%' AND modello_veicolo LIKE '" + i.getModelloVeicolo();
				sql_find += "%' AND data_entrata_officina LIKE '" + i.getDataEntrataInOfficina();
				sql_find += "%' AND data_immatricolazione LIKE '" + i.getDataImmatricolazione();
				sql_find += "%' AND descrizione_intervento LIKE '" + i.getDescrizioneIntervento();
				sql_find += "%' AND data_evasione_richiesta LIKE '" + i.getDataEvasioneRichiesta();
				sql_find += "%' AND nome_cliente LIKE '" + i.getNomeCliente();
				sql_find += "%' AND cognome_cliente LIKE '" + i.getCognomeCliente();
				sql_find += "%' AND tel_cliente LIKE '" + i.getTelCliente();
				sql_find += "%' AND email_cliente LIKE '" + i.getEmailCliente();
				sql_find += "%' AND id_meccanico LIKE "+ i.getIdMeccanico();
			
			ResultSet rs = stm.executeQuery(sql_find);
			while(rs.next()){
				elenco.add(new SchedaRiparazione(
						rs.getString("marca_veicolo"),
						rs.getString("modello_veicolo"),
						rs.getString("data_entrata_officina"),
						rs.getString("data_immatricolazione"),
						rs.getString("descrizione_intervento"),
						rs.getString("data_evasione_richiesta"),
						rs.getString("nome_cliente"),
						rs.getString("cognome_cliente"),
						rs.getString("tel_cliente"),
						rs.getString("email_cliente"),
						rs.getInt("id_meccanico"))
						);
			}
			DAOSettings.closeStatement(stm);

		} catch (SQLException sqle) {
			throw new DAOException("In showSchedaRiparazione: " + sqle);
		}	
		return elenco;
	}

	@Override
	public List<SchedaRiparazione> findSchedaRiparazioneByEmail(String email_cliente)  throws DAOException{
		ArrayList<SchedaRiparazione> elenco = new ArrayList<SchedaRiparazione>();
		
		try {
			if (email_cliente.isEmpty()) {
				throw new DAOException("In findSchedaRiparazioneByEmail: email_cliente can NOT be empty");
			}

			Statement stm = DAOSettings.getStatement();
			
			String sql_find = "SELECT * FROM scheda_riparazione WHERE email_cliente LIKE '" + email_cliente + "%'";
			
			System.out.println("Query Generata: " + sql_find);
			ResultSet rs = stm.executeQuery(sql_find);			
			while(rs.next()){
				elenco.add(new SchedaRiparazione(
						rs.getString("marca_veicolo"),
						rs.getString("modello_veicolo"),
						rs.getString("data_entrata_officina"),
						rs.getString("data_immatricolazione"),
						rs.getString("descrizione_intervento"),
						rs.getString("data_evasione_richiesta"),
						rs.getString("nome_cliente"),
						rs.getString("cognome_cliente"),
						rs.getString("tel_cliente"),
						rs.getString("email_cliente"),
						rs.getInt("id_meccanico"))
						);
			}
			DAOSettings.closeStatement(stm);

		} catch (SQLException sqle) {
			throw new DAOException("In showSchedaRiparazione: " + sqle);
		}
		System.out.println("Debug Elenco: " + elenco);
		return elenco;
	}
	
	@Override
	public List<SchedaRiparazione> showAllSchedeRiparazione()  throws DAOException{
		ArrayList<SchedaRiparazione> elenco = new ArrayList<SchedaRiparazione>();

		try {
			Statement stm = DAOSettings.getStatement();
			String sql="SELECT * FROM scheda_riparazione";
			ResultSet rs=stm.executeQuery(sql);

			while(rs.next()){
				SchedaRiparazione i = new SchedaRiparazione(
						rs.getString("marca_veicolo"),
						rs.getString("modello_veicolo"),
						rs.getString("data_entrata"),
						rs.getString("data_immatricolazione"),
						rs.getString("descrizione_intervento"),
						rs.getString("data_evasione_richiesta"),
						rs.getString("nome_cliente"),
						rs.getString("cognome_cliente"),
						rs.getString("tel_cliente"),
						rs.getString("email_cliente"),
						rs.getInt("id_meccanico"));
				elenco.add(i);
			}	
		} catch (SQLException sq) {
			throw new DAOException(
					"In showAllSchedeRiparazione" + sq.getMessage());
		}	
		return elenco;
	}

	@Override
	public void deleteSchedaRiparazione(String email_cliente)  throws DAOException{
		try {
			if (email_cliente.isEmpty()) {
				throw new DAOException("In deleteSchedaRip: email_cliente field can not be empty");
			}

			Statement stm = DAOSettings.getStatement();
			String sql_delete = "DELETE FROM scheda_riparazione WHERE email_cliente LIKE '" + email_cliente + "'";

			int del = stm.executeUpdate(sql_delete);
			DAOSettings.closeStatement(stm);

		} catch (SQLException sqle) {
			throw new DAOException("In deleteSchedaRip: " + sqle);
		}	
	}
}