package it.uniclam.progettoOfficinaMeccanica.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.uniclam.progettoOfficinaMeccanica.*;
public class NavigationPanel extends JPanel {
	
	/*Dichiarazione dei pulsanti necessari all'interfaccia che gestisce le operazione sulla tabella dipendenti*/
	
	private JButton cercaDipendenti = new JButton(ClientGUI.CERCA_DIPENDENTI_PANEL);
	private JButton inserisciDipendenti = new JButton(ClientGUI.INSERISCI_DIPENDENTI_PANEL);
	private JButton updateDipendenti = new JButton(ClientGUI.UPDATE_DIPENDENTI_PANEL);	
	private JButton settings = new JButton(ClientGUI.SETTINGS_PANEL);
	private ClientGUI clientGUI = null;
	
	/*Dichiarazione dei pulsanti necessari all'interfaccia che gestisce le operazione sulla tabella scheda_riparazione*/
	
	private JButton inserisciSchedaRip = new JButton(AmmGestSchedeGUI.INSERISCI_SCHEDA_PANEL);
	private JButton cercaSchedaRip = new JButton(AmmGestSchedeGUI.CERCA_SCHEDA_PANEL);
	private AmmGestSchedeGUI ammGestSchedeGUI = null;
	
	/*A questo punto si gestisce la navcigazione fra i pannelli riferiti alle operazioni sui dipendenti*/
	
	public NavigationPanel(ClientGUI clientGUI){
		setLayout(new FlowLayout());
		add(cercaDipendenti);
		add(inserisciDipendenti);
		add(updateDipendenti);
		add(settings);
		this.clientGUI = clientGUI;
		
		cercaDipendenti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientGUI.changePanel(ClientGUI.CERCA_DIPENDENTI_PANEL);
			}
		});
		
		inserisciDipendenti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientGUI.changePanel(ClientGUI.INSERISCI_DIPENDENTI_PANEL);
			}
		});
		
		updateDipendenti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientGUI.changePanel(ClientGUI.UPDATE_DIPENDENTI_PANEL);
			}
		});
		
		settings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientGUI.changePanel(ClientGUI.SETTINGS_PANEL);
			}
		});
	}

	/*A questo punto si gestisce la navcigazione fra i pannelli riferiti alle operazioni sulle schede di riparazione*/
	
	public NavigationPanel(AmmGestSchedeGUI ammGestSchedeGUI) {
		setLayout(new FlowLayout());
		add(inserisciSchedaRip);
		add(cercaSchedaRip);
		this.ammGestSchedeGUI = ammGestSchedeGUI;
		
		inserisciSchedaRip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ammGestSchedeGUI.changePanel(AmmGestSchedeGUI.INSERISCI_SCHEDA_PANEL);
			}
		});
		
		cercaSchedaRip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ammGestSchedeGUI.changePanel(AmmGestSchedeGUI.CERCA_SCHEDA_PANEL);
			}
		});
	}
}
