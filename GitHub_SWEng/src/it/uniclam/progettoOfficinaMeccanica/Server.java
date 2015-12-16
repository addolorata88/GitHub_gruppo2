package it.uniclam.progettoOfficinaMeccanica;
import it.uniclam.progettoOfficinaMeccanica.dao.DAOException;
import it.uniclam.progettoOfficinaMeccanica.dao.DipendenteDAOImpl;
import it.uniclam.progettoOfficinaMeccanica.dao.SchedaRiparazioneDAOImpl;
import it.uniclam.progettoOfficinaMeccanica.entity.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/*Questa classe serve per instaurare le chiamate da e verso il database. 
 * Non contiene direttamente codice SQL in quanto si � voluto gestire separatamente
 * le richieste implementando le stesse in classi separate(impl). */

public class Server {
	// "req_..." sono le richieste
	// "res_..." sono le risposte
	public static String OK					= "Ok";

	public static String QUERY_DIPENDENTI 	= "req_query_dipendenti";
	public static String INSERT_DIPENDENTI 	= "req_insert_dipendenti";
	public static String DELETE_DIPENDENTI 	= "req_delete_dipendenti";
	public static String UPDATE_DIPENDENTI 	= "req_update_dipendenti";
	//public static String FIND_DIPENDENTE	= "req_find_by_email_dipendenti";

	public static String QUERY_SCHEDA		= "req_query_scheda_rip";
	public static String INSERT_SCHEDA		= "req_insert_scheda_rip";
	public static String UPDATE_SCHEDA		= "req_update_scheda_rip";

	public static String LIST_DIPENDENTI 	= "res_list_dipendenti";

	public static String 	HOST = "localhost";
	public static int 		PORT = 5555;

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(PORT);
		String response = null;

		while(true){
			response = "Error\n\n";
			System.out.println("Server in ascolto sulla porta " + PORT);
			Socket s = ss.accept();

			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);

			String command = in.readLine();

			//inizio sessione DIPENDENTE
			if (command.equals(QUERY_DIPENDENTI)){

				String nome = in.readLine().replace("nome:", "").replace("\n", "");
				String cognome = in.readLine().replace("cognome:", "").replace("\n", "");		
				String telefono = in.readLine().replace("telefono:", "").replace("\n", "");
				String email = in.readLine().replace("email:", "").replace("\n", "");
				String data_assunzione = in.readLine().replace("data_assunzione:", "").replace("\n", "");
				String scadenza_contratto = in.readLine().replace("scadenza_contratto:", "").replace("\n", "");

				try{	
					Dipendente chiaveRicerca = new Dipendente(nome, cognome, telefono, email, data_assunzione, scadenza_contratto);
					List<Dipendente> lista = DipendenteDAOImpl.getInstance().getDipendenti(chiaveRicerca);

					response = "Ok\n";

					for(Dipendente item: lista){
						response += item.getNome() + ", ";
						response += item.getCognome() + ", ";						
						response += item.getTelefono() + ", ";
						response += item.getEmail() + ", ";
						response += item.getDataAssunzione() + ", ";
						response += item.getScadenzaContratto() + "\n";
					}

					response += "\n";					
					out.println(response);

				} catch (DAOException daoe){
					System.out.println("Exception in connection (Query)");
					out.println(response + " -> " + daoe);
				}				
				s.close();

			} else if (command.equals(INSERT_DIPENDENTI)){
				String nome = in.readLine().replace("nome:", "").replace("\n", "");
				String cognome = in.readLine().replace("cognome:", "").replace("\n", "");		
				String telefono = in.readLine().replace("telefono:", "").replace("\n", "");
				String email = in.readLine().replace("email:", "").replace("\n", "");
				String data_assunzione = in.readLine().replace("data_assunzione:", "").replace("\n", "");
				String scadenza_contratto = in.readLine().replace("scadenza_contratto:", "").replace("\n", "");

				System.out.println("Debug insert dipendenti: " + nome + " " + cognome + " " + telefono + " " + email + " " + data_assunzione + " " + scadenza_contratto);
				try{	
					Dipendente nuovoDipendente = new Dipendente(nome, cognome, telefono, email, data_assunzione, scadenza_contratto);
					System.out.println("oggetto: " + nuovoDipendente);
					DipendenteDAOImpl.getInstance().insertDipendente(nuovoDipendente);

					response = "Ok\n";				
					out.println(response);

				} catch (DAOException daoe){
					System.out.println("Exception in connection (Insert) " + daoe);
					out.println(response + " " + daoe);
				}
				s.close();

			} else if (command.equals(DELETE_DIPENDENTI)){			
				String nome = in.readLine().replace("nome:", "").replace("\n", "");
				String cognome = in.readLine().replace("cognome:", "").replace("\n", "");		
				String telefono = in.readLine().replace("telefono:", "").replace("\n", "");
				String email = in.readLine().replace("email:", "").replace("\n", "");
				String data_assunzione = in.readLine().replace("data_assunzione:", "").replace("\n", "");
				String scadenza_contratto = in.readLine().replace("scadenza_contratto:", "").replace("\n", "");

				try{	
					Dipendente nuovoDipendente = new Dipendente(nome, cognome, telefono, email, data_assunzione, scadenza_contratto);
					DipendenteDAOImpl.getInstance().deleteDipendente(nuovoDipendente);

					response = "Ok\n";				
					out.println(response);

				} catch (DAOException daoe){
					System.out.println("Exception in connection (Delete)");
					out.println(response + " " + daoe);
				}				
				s.close();

			} else if (command.equals(UPDATE_DIPENDENTI)){
				String nome = in.readLine().replace("nome:", "").replace("\n", "");
				String cognome = in.readLine().replace("cognome:", "").replace("\n", "");		
				String telefono = in.readLine().replace("telefono:", "").replace("\n", "");
				String email = in.readLine().replace("email:", "").replace("\n", "");
				String data_assunzione = in.readLine().replace("data_assunzione:", "").replace("\n", "");
				String scadenza_contratto = in.readLine().replace("scadenza_contratto:", "").replace("\n", "");
			
				try{	
					Dipendente updateDipendente = new Dipendente(nome, cognome, telefono, email, data_assunzione, scadenza_contratto);
					DipendenteDAOImpl.getInstance().updateDipendente(updateDipendente);

					response = "Ok\n";				
					out.println(response);

				} catch (DAOException daoe){
					System.out.println("Exception in connection (Update)");
					out.println(response + " " + daoe);
				}				
				s.close();
				//fine sessione DIPENDENTE
				
				// Inizio sessione SCHEDA RIPARAZIONE
			} else if (command.equals(INSERT_SCHEDA)){
				String marca_veicolo = in.readLine().replace("marca_veicolo:", "").replace("\n", "");
				String modello_veicolo = in.readLine().replace("modello_veicolo:", "").replace("\n", "");
				String data_entrata = in.readLine().replace("data_entrata:", "").replace("\n", "");
				String data_immatricolazione = in.readLine().replace("data_immatricolazione:", "").replace("\n", "");
				String descrizione_intervento = in.readLine().replace("descrizione_intervento:", "").replace("\n", "");
				String data_evasione = in.readLine().replace("data_evasione:", "").replace("\n", "");
				String nome_cliente = in.readLine().replace("nome_cliente:", "").replace("\n", "");
				String cognome_cliente = in.readLine().replace("cognome_cliente:", "").replace("\n", "");		
				String tel_cliente = in.readLine().replace("tel_cliente:", "").replace("\n", "");
				String id_meccanico = in.readLine().replace("id_meccanico:", "").replace("\n", "");

				System.out.println("Debug insert SCHEDA: " + marca_veicolo + " " + modello_veicolo + 
						" " + data_entrata + " " + data_immatricolazione + " " + descrizione_intervento + 
						" " + data_evasione + " " + nome_cliente + " " + cognome_cliente + " " + tel_cliente +
						" " + id_meccanico);

				try{	
					SchedaRiparazione nuovaSchedaRiparazione = new SchedaRiparazione(marca_veicolo,modello_veicolo,
							data_entrata, data_immatricolazione,descrizione_intervento,data_evasione,nome_cliente,
							cognome_cliente,tel_cliente,Integer.parseInt(id_meccanico));
					System.out.println("Debug oggetto: " + nuovaSchedaRiparazione);

					SchedaRiparazioneDAOImpl.getInstance().insertSchedaRiparazione(nuovaSchedaRiparazione);

					response = "Ok\n";				
					out.println(response);

				} catch (DAOException daoe){
					System.out.println("Exception in connection (Insert) " + daoe);
					out.println(response + " " + daoe);
				}
				s.close();	

			} else if(command.equals(QUERY_SCHEDA)){
				String marca_veicolo = in.readLine().replace("marca_veicolo:", "").replace("\n", "");
				String modello_veicolo = in.readLine().replace("modello_veicolo:", "").replace("\n", "");
				String data_entrata = in.readLine().replace("data_entrata:", "").replace("\n", "");
				String data_immatricolazione = in.readLine().replace("data_immatricolazione:", "").replace("\n", "");
				String descrizione_intervento = in.readLine().replace("descrizione_intervento:", "").replace("\n", "");
				String data_evasione = in.readLine().replace("data_evasione:", "").replace("\n", "");
				String nome_cliente = in.readLine().replace("nome_cliente:", "").replace("\n", "");
				String cognome_cliente = in.readLine().replace("cognome_cliente:", "").replace("\n", "");		
				String tel_cliente = in.readLine().replace("tel_cliente:", "").replace("\n", "");
				String id_meccanico = in.readLine().replace("id_meccanico:", "").replace("\n", "");
				
				System.out.println("Debug QUERY SCHEDA: " + marca_veicolo + " " + modello_veicolo + 
						" " + data_entrata + " " + data_immatricolazione + " " + descrizione_intervento + 
						" " + data_evasione + " " + nome_cliente + " " + cognome_cliente + " " + tel_cliente +
						" " + id_meccanico);

				try{	
					SchedaRiparazione nuovaSchedaRiparazione = new SchedaRiparazione(marca_veicolo,modello_veicolo, data_entrata,
							data_immatricolazione,descrizione_intervento,data_evasione,nome_cliente,
							cognome_cliente,tel_cliente,Integer.parseInt(id_meccanico));
					List<SchedaRiparazione> lista = SchedaRiparazioneDAOImpl.getInstance().showSchedaRiparazione(nuovaSchedaRiparazione);

					response = "Ok\n";

					for(SchedaRiparazione item: lista){
						response += item.getMarcaVeicolo() + ", ";
						response += item.getModelloVeicolo() + ", ";						
						response += item.getDataEntrataInOfficina() + ", ";
						response += item.getDataImmatricolazione() + ", ";
						response += item.getDescrizioneIntervento() + ", ";
						response += item.getDataEvasioneRichiesta() + "\n";
						response += item.getNomeCliente() + "\n";
						response += item.getCognomeCliente() + "\n";
						response += item.getTelCliente() + "\n";
						response += item.getIdMeccanico() + "\n";
					}

					response += "\n";					
					out.println(response);

				} catch (DAOException daoe){
					System.out.println("Exception in connection (Query)");
					out.println(response + " -> " + daoe);
				}		
				s.close();
				
				// Fine sessione SCHEDA RIPARAZIONE

			} else {
				response = "Messaggio di protocollo non valido\n";				
				out.println(response);
			}
		}		// Chiudo il while
	}			// Chiudo il main
}
