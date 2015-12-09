package it.uniclam.progettoOfficinaMeccanica.dao;

import java.util.List;

import it.uniclam.progettoOfficinaMeccanica.entity.InterventoRiparazione;

public interface InterventoRiparazioneDAO {

	public void insertInterventoRiparazione(InterventoRiparazione i) throws DAOException;
	public void updateInterventoRiparazione(InterventoRiparazione i)  throws DAOException;
	public List<InterventoRiparazione> showInterventoRiparazione(InterventoRiparazione i)  throws DAOException;
	public List<InterventoRiparazione> showAllInterventiRiparazione()  throws DAOException;
	public void deleteDipendente(InterventoRiparazione i)  throws DAOException;
}
