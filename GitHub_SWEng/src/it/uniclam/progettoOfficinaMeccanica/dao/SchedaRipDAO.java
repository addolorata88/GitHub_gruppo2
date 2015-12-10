package it.uniclam.progettoOfficinaMeccanica.dao;

import java.util.List;

import it.uniclam.progettoOfficinaMeccanica.entity.SchedaRip;

public interface SchedaRipDAO {

	public void insertSchedaRip(SchedaRip i) throws DAOException;
	public void updateSchedaRip(SchedaRip i)  throws DAOException;
	public List<SchedaRip> showSchedaRip(SchedaRip i)  throws DAOException;
	public List<SchedaRip> showAllSchedeRip()  throws DAOException;
	public void deleteSchedaRip(SchedaRip i)  throws DAOException;
}
