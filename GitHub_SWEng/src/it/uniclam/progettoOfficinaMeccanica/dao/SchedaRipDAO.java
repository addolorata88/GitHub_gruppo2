package it.uniclam.progettoOfficinaMeccanica.dao;

import java.util.List;

import it.uniclam.progettoOfficinaMeccanica.entity.SchedaRip;

public interface SchedaRipDAO {

	public void insertInterventoRiparazione(SchedaRip i) throws DAOException;
	public void updateInterventoRiparazione(SchedaRip i)  throws DAOException;
	public List<SchedaRip> showInterventoRiparazione(SchedaRip i)  throws DAOException;
	public List<SchedaRip> showAllInterventiRiparazione()  throws DAOException;
	public void deleteDipendente(SchedaRip i)  throws DAOException;
}
