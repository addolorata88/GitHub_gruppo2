package it.uniclam.progettoEsame;
import it.uniclam.progettoOfficinaMeccanica.dao.DAOException;
import it.uniclam.progettoOfficinaMeccanica.dao.DipendenteDAOImpl;
import it.uniclam.progettoOfficinaMeccanica.entity.Dipendente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
	// "req_..." sono le richieste
	// "res_..." sono le risposte
	public static String OK					= "Ok";
	
	public static String QUERY_DIPENDENTI 	= "req_query_dipendenti";
	public static String INSERT_DIPENDENTI 	= "req_insert_dipendenti";
	public static String DELETE_DIPENDENTI 	= "req_delete_dipendenti";
	public static String UPDATE_DIPENDENTI 	= "req_update_dipendenti";
	//public static String FIND_DIPENDENTE	= "req_find_by_email_dipendenti";
	// TODO: altre voci per il protocollo

	public static String LIST_DIPENDENTI 	= "res_list_dipendenti";
	// TODO: altre voci per il protocollo
			
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
			
			if (command.equals(QUERY_DIPENDENTI)){
				
				String nome = in.readLine().replace("nome:", "").replace("\n", "");
				String cognome = in.readLine().replace("cognome:", "").replace("\n", "");		
				String telefono = in.readLine().replace("telefono:", "").replace("\n", "");
				String email = in.readLine().replace("email:", "").replace("\n", "");
				String data_assunzione = in.readLine().replace("data_assunzione:", "").replace("\n", "");
				String scadenza_contratto = in.readLine().replace("scadenza_contratto:", "").replace("\n", "");
				
				try{	
					//List<Amico> lista = AmicoDAOImpl.getInstance().getAllAmici();	
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
				
				try{	
					Dipendente nuovoDipendente = new Dipendente(nome, cognome, telefono, email, data_assunzione, scadenza_contratto);
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
					Dipendente nuovoDipendente = new Dipendente(nome, cognome, telefono, email, data_assunzione, scadenza_contratto);
					DipendenteDAOImpl.getInstance().updateDipendente(nuovoDipendente);
					
					response = "Ok\n";				
					out.println(response);
										
				} catch (DAOException daoe){
					System.out.println("Exception in connection (Update)");
					out.println(response + " " + daoe);
				}				
				s.close();
				
			} else {
				response = "Messaggio di protocollo non valido\n";				
				out.println(response);
			}
		}		// Chiudo il while
	}			// Chiudo il main
}
