package it.uniclam.progettoOfficinaMeccanica.dao;

import java.util.List;

import it.uniclam.progettoOfficinaMeccanica.entity.SchedaRiparazione;

public interface SchedaRiparazioneDAO {

	public void insertSchedaRiparazione(SchedaRiparazione i) throws DAOException;
	public void updateSchedaRiparazione(SchedaRiparazione i)  throws DAOException;
	public List<SchedaRiparazione> showSchedaRiparazione(SchedaRiparazione i)  throws DAOException;
	public List<SchedaRiparazione> showAllSchedeRiparazione()  throws DAOException;
	public void deleteSchedaRiparazione(SchedaRiparazione i)  throws DAOException;
	public List<SchedaRiparazione> findSchedaRiparazioneByEmail(String email_cliente) throws DAOException;
}
