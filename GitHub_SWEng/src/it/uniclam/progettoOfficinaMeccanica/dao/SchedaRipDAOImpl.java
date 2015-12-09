package it.uniclam.progettoOfficinaMeccanica.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.uniclam.progettoOfficinaMeccanica.entity.SchedaRip;

public class SchedaRipDAOImpl implements SchedaRipDAO{

	private SchedaRipDAOImpl(){};

	private static SchedaRipDAO dao = null;

	public static SchedaRipDAO getInstance(){
		if (dao == null){
			dao = new SchedaRipDAOImpl();
		}
		return dao;
	}

	@Override
	public void insertInterventoRiparazione(SchedaRip i) throws DAOException{
		try {
			if (	i.getMarcaVeicolo() == null ||
					i.getModelloVeicolo() == null ||
					i.getDataEntrataInOfficina() == null ||
					i.getDataImmatricolazione() == null ||
					i.getDescrizioneIntervento() == null ||
					i.getDataEvasioneRichiesta()== null ||
					i.getNomeCliente() == null ||
					i.getCognomeCliente() == null ||
					i.getTelCliente()== null) {
				throw new DAOException("In insertInterventoRiparazione: no one field can be empty");
			}

			Statement stm = DAOSettings.getStatement();

			String sql_insert = "INSERT INTO intervento_riparazione (marca_veicolo, modello_veicolo, "
					+ "data_entrata_officina, data_immatricolazione, descrizione_intervento, "
					+ "data_evasione_richiesta, nome_cliente, cognome_cliente, tel_cliente) VALUES ('";
			sql_insert += i.getMarcaVeicolo() + "', '" + i.getModelloVeicolo() + "', '";
			sql_insert += i.getDataEntrataInOfficina() + "', '" + i.getDataImmatricolazione() + "', '";
			sql_insert += i.getDescrizioneIntervento() + "', '" + i.getDataEvasioneRichiesta() + "', '";
			sql_insert += i.getNomeCliente() + "', '" + i.getCognomeCliente() + "', '";
			sql_insert += i.getTelCliente() + "')";

			int inserimento = stm.executeUpdate(sql_insert);
			DAOSettings.closeStatement(stm);

		} catch (SQLException sqle) {
			throw new DAOException("In insertInterventoRiparazione: " + sqle);
		}	
	}

	@Override
	public void updateInterventoRiparazione(SchedaRip i)  throws DAOException{
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
					i.getIdMeccanico() == 0){
				throw new DAOException("In updateInterventoRiparazione: no one field can be empty");
			}

			Statement stm = DAOSettings.getStatement();

			String sql_update = "UPDATE intervento_riparazione SET";
			sql_update += "marca_veicolo='" + i.getMarcaVeicolo() + "',";
			sql_update += "modello_veicolo='" + i.getModelloVeicolo() + "',";
			sql_update += "data_entrata_officina='" + i.getDataEntrataInOfficina() + "',";
			sql_update += "data_immatricolazione='" + i.getDataImmatricolazione() + "',";
			sql_update += "descrizione_intervento='" + i.getDescrizioneIntervento() + "',";
			sql_update += "data_evasione_richiesta='" + i.getDataEvasioneRichiesta() + "'";
			sql_update += "nome_cliente='" + i.getNomeCliente() + "'";
			sql_update += "cognome_cliente='" + i.getCognomeCliente() + "'";
			sql_update += "tel_cliente='" + i.getTelCliente() + "'";
			sql_update += "id_meccanico='" + i.getIdMeccanico() + "'";

			int aggiornamento = stm.executeUpdate(sql_update);  //come in insert. Modificare anche in DipDAOImpl(ResultSet->int)
			DAOSettings.closeStatement(stm);

		} catch (SQLException sqle) {
			throw new DAOException("In updateInterventoRiparazione: " + sqle);
		}			
	}

	@Override
	public List<SchedaRip> showInterventoRiparazione(SchedaRip i)  throws DAOException{
		ArrayList<SchedaRip> elenco = new ArrayList<SchedaRip>();

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
					i.getIdMeccanico() == 0) {
				throw new DAOException("In showInterventoRiparazione: no one field can be empty");
			}

			Statement stm = DAOSettings.getStatement();
			String sql_find = "SELECT * FROM intervento_riparazione WHERE marca_veicolo LIKE '";
			sql_find += i.getMarcaVeicolo() + "%' AND modello_veicolo LIKE '" + i.getModelloVeicolo();
			sql_find += "%' AND data_entrata_officina LIKE '" + i.getDataEntrataInOfficina();
			sql_find += "%' AND data_immatricolazione LIKE '" + i.getDataImmatricolazione();
			sql_find += "%' AND descrizione_intervento LIKE '" + i.getDescrizioneIntervento();
			sql_find += "%' AND data_evasione_richiesta LIKE '" + i.getDataEvasioneRichiesta();
			sql_find += "%' AND nome_cliente LIKE '" + i.getNomeCliente();
			sql_find += "%'AND cognome_cliente LIKE '" + i.getCognomeCliente();
			sql_find += "%'AND tel_cliente LIKE '" + i.getTelCliente();
			sql_find += "%'AND id_meccanico LIKE' "+ i.getIdMeccanico() + "%'";

			ResultSet rs = stm.executeQuery(sql_find);
			while(rs.next()){
				elenco.add(new SchedaRip(rs.getString("marca_veicolo"),
						rs.getString("modello_veicolo"),
						rs.getString("data_immatricolazione"),
						rs.getString("descrizione_intervento"),
						rs.getString("data_evasione_richiesta"),
						rs.getString("nome_cliente"),
						rs.getString("cognome_cliente"),
						rs.getString("tel_cognome"),
						rs.getInt("idMeccanico")));
			}
			DAOSettings.closeStatement(stm);

		} catch (SQLException sqle) {
			throw new DAOException("In showInterventoRiparazione: " + sqle);
		}	
		return elenco;
	}

	@Override
	public List<SchedaRip> showAllInterventiRiparazione()  throws DAOException{
		ArrayList<SchedaRip> elenco = new ArrayList<SchedaRip>();

		try {
			Statement stm = DAOSettings.getStatement();
			String sql="SELECT * FROM intervento_riparazione";
			ResultSet rs=stm.executeQuery(sql);

			while(rs.next()){
				SchedaRip i = new SchedaRip(rs.getString("marca_veicolo"),
						rs.getString("modello_veicolo"),
						rs.getString("data_immatricolazione"),
						rs.getString("descrizione_intervento"),
						rs.getString("data_evasione_richiesta"),
						rs.getString("nome_cliente"),
						rs.getString("cognome_cliente"),
						rs.getString("tel_cognome"),
						rs.getInt("idMeccanico"));
				elenco.add(i);
			}	
		} catch (SQLException sq) {
			throw new DAOException(
					"In showAllInterventiRiparazione" + sq.getMessage());
		}	
		return elenco;
	}

	@Override
	public void deleteDipendente(SchedaRip i)  throws DAOException{
		try {
			if (i.getCognomeCliente() == null) {
				throw new DAOException("In deleteInterventoRiparazione: cognomeCliente field can not be empty");
			}

			Statement stm = DAOSettings.getStatement();
			String sql_delete = "DELETE FROM intervento_riparazione WHERE cognome_cliente LIKE '";
			sql_delete +=  i.getCognomeCliente() + "%'";

			ResultSet rs = stm.executeQuery(sql_delete);
			DAOSettings.closeStatement(stm);

		} catch (SQLException sqle) {
			throw new DAOException("In deleteInterventoRiparazione: " + sqle);
		}	
	}
}