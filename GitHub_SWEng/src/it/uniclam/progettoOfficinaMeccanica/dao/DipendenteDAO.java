package it.uniclam.progettoOfficinaMeccanica.dao;

import java.util.List;

import it.uniclam.progettoOfficinaMeccanica.entity.Dipendente;

public interface DipendenteDAO {

	public void insertDipendente(Dipendente d) throws DAOException;
	public void updateDipendente(Dipendente d)  throws DAOException;
	public List<Dipendente> getDipendenti(Dipendente d)  throws DAOException;
	public List<Dipendente> getAllDipendenti()  throws DAOException;
	public Dipendente findByMail(String mail)  throws DAOException;
	public void deleteDipendente(Dipendente d)  throws DAOException;
}
