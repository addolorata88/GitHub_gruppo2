package it.uniclam.progettoOfficinaMeccanica.dao;

import java.util.List;

import it.uniclam.progettoOfficinaMeccanica.entity.InterventoRiparazione;

public interface InterventoRiparazioneDAO {

	public void insertInterventoRiparazione(InterventoRiparazione i);
	public List<InterventoRiparazione> showInterventoRiparazione();
	public void updateInterventoRiparazione(InterventoRiparazione i);
	
}