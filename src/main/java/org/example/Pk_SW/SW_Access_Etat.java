package org.example.Pk_SW;



import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.Pk_Process.Lancement;

@Path("/k8055_Etat")
public class SW_Access_Etat {
	Lancement lancement = new Lancement();
	
	public SW_Access_Etat()
	{
		
	}

	
	// lecture des entr�es (Version navigateur)
	@GET
	@Path("/Entrees")
	@Produces(MediaType.TEXT_PLAIN)
	public String LireEntrees() {
		String Str="E";
		Str = "E1 : " + SW_Access_Action.lancement.STE.DE1 + " - " + "E2 : " + SW_Access_Action.lancement.STE.DE2 + " - " +
			  "E3 : " + SW_Access_Action.lancement.STE.DE3 + " - " + "E4 : " + SW_Access_Action.lancement.STE.DE4 + " - " +
			  "E5 : " + SW_Access_Action.lancement.STE.DE5;
		return Str;	
	}
	
	// lecture de l'objet StrucEntrees
	//.
	//.
	//.
	
	// lecture des sorties (Version navigateur)
	//.
	//.
	//.
	
	// lecture de l'objet StrucSorties
	//.
	//.
	//.
	
	// lecture du Process (Version navigateur)
	//.
	//.
	//.	
	
	// lecture de l'objet StrucProcess
	//.
	//.
	//.
	
}

