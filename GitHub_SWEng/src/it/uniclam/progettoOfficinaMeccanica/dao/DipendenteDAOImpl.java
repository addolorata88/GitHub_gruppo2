package it.uniclam.progettoOfficinaMeccanica.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.uniclam.progettoOfficinaMeccanica.entity.Dipendente;

public class DipendenteDAOImpl implements DipendenteDAO{

	private DipendenteDAOImpl(){}
	
	private static DipendenteDAO dao = null;
	
	public static DipendenteDAO getInstance(){
		if (dao == null){
			dao = new DipendenteDAOImpl();
		}
		return dao;
	}
	
	@Override
	public void insertDipendente(Dipendente d) throws DAOException {
		try {
			if (	d.getNome() == null ||
					d.getCognome() == null ||
					d.getTelefono() == null ||
					d.getEmail() == null ||
					d.getDataAssunzione() == null ||
					d.getScadenzaContratto() == null ) {
				throw new DAOException("In insertDipendente: no one field can be empty");
			}
				
			Statement stm = DAOSettings.getStatement();
			String sql_insert = "INSERT INTO meccanico VALUES ('', '";
					sql_insert += d.getNome() + "', '" + d.getCognome() + "', '";
					sql_insert += d.getTelefono() + "', '" + d.getEmail() + "', '";
					sql_insert += d.getDataAssunzione() + "', '" + d.getScadenzaContratto() + "')";
							
			ResultSet rs = stm.executeQuery(sql_insert);
			DAOSettings.closeStatement(stm);
			
		} catch (SQLException sqle) {
			throw new DAOException("In insertDipendente: " + sqle);
		}	
	}
	

	@Override
	public void updateDipendente(Dipendente d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Dipendente> getDipendenti(Dipendente d) throws DAOException {
		ArrayList<Dipendente> elenco = new ArrayList<Dipendente>();
		try {
			if (	d.getNome() == null ||
					d.getCognome() == null ||
					d.getTelefono() == null ||
					d.getEmail() == null ||
					d.getDataAssunzione() == null ||
					d.getScadenzaContratto() == null ) {
				throw new DAOException("In getDipendenti: no one field can be empty");
			}
				
			Statement stm = DAOSettings.getStatement();
			String sql_find = "SELECT * FROM meccanico WHERE nome LIKE '";
				sql_find += d.getNome() + "%' AND cognome LIKE '" + d.getCognome() + "%' AND telefono LIKE '";
				sql_find += d.getTelefono() + "%' AND email LIKE '" + d.getEmail() + "%' AND data_assunzione LIKE '";
				sql_find += d.getDataAssunzione() + "%' AND scadenza_contratto LIKE '" + d.getScadenzaContratto() + "%'";
							
			ResultSet rs = stm.executeQuery(sql_find);
			while(rs.next()){
				elenco.add(new Dipendente(rs.getString("nome"),
						rs.getString("cognome"),
						rs.getString("telefono"),
						rs.getString("email"),
						rs.getString("data_assunzione"),
						rs.getString("scadenza_contratto")));
			}
			DAOSettings.closeStatement(stm);
			
		} catch (SQLException sqle) {
			throw new DAOException("In insertDipendente: " + sqle);
		}	
		return elenco;
	}

	@Override
	public List<Dipendente> getAllDipendenti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dipendente findByMail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDipendente(Dipendente d) {
		// TODO Auto-generated method stub
		
	}

	
}
