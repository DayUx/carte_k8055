package org.example.Pk_SW;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.Pk_Process.Lancement;


@Path("/k8055_Action")
public class SW_Access_Action {

	public static Lancement lancement = new Lancement();



	
	//Cr�ation de l'objet Lancement (1 seule instance possible par Carte)
	//.
	//.
	//.
	
	public SW_Access_Action()
	{
		//
	}
	
	// Lancement du process (Version navigateur)
	@GET
	@Path("/Lance")
	@Produces(MediaType.TEXT_PLAIN)
	public String LanceProcess() {
		if (lancement.Lance() == 0)
			return "Process Lance";
		else
			return "Process en cours";	
	}
	
	// Arr�t du process (Version navigateur)
	@GET
	@Path("/Arret")
	@Produces(MediaType.TEXT_PLAIN)
	public String ArretProcess() {
		lancement.Arret();
		return "Process Arrete";
	}
	
	// RAZ du process (Version navigateur)
	@GET
	@Path("/Raz")
	@Produces(MediaType.TEXT_PLAIN)
	public String RazProcess() {
		lancement.Raz();
		return "Raz Process OK";
	}

}
