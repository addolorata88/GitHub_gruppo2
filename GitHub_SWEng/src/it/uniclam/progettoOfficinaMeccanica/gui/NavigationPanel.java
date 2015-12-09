package it.uniclam.progettoOfficinaMeccanica.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.uniclam.progettoOfficinaMeccanica.*;
public class NavigationPanel extends JPanel {
	private JButton cercaDipendenti = new JButton(ClientGUI.CERCA_DIPENDENTI_PANEL);
	private JButton inserisciDipendenti = new JButton(ClientGUI.INSERISCI_DIPENDENTI_PANEL);
	private JButton updateDipendenti = new JButton(ClientGUI.UPDATE_DIPENDENTI_PANEL);	
	private JButton settings = new JButton(ClientGUI.SETTINGS_PANEL);
	private ClientGUI clientGUI = null;
	
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
}
