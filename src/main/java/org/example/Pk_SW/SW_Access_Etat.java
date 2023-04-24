package org.example.Pk_SW;



import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.Pk_Process.Lancement;
import org.example.Pk_Process.StrucEntrees;
import org.example.Pk_Process.StrucProcess;
import org.example.Pk_Process.StrucSorties;

@Path("/k8055_Etat")
public class SW_Access_Etat {

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
	@GET
	@Path("/StrucEntrees")
	@Produces(MediaType.APPLICATION_JSON)
	public StrucEntrees LireStrucEntrees() {
		return SW_Access_Action.lancement.STE;
	}

	// lecture des sorties (Version navigateur)
	//.
	//.
	//.
	@GET
	@Path("/Sorties")
	@Produces(MediaType.TEXT_PLAIN)
	public String LireSorties() {
		String Str="S";
		Str = "S1 : " + SW_Access_Action.lancement.STS.DS1 + " - " + "S2 : " + SW_Access_Action.lancement.STS.DS2 + " - " +
				"S3 : " + SW_Access_Action.lancement.STS.DS3 + " - " + "S4 : " + SW_Access_Action.lancement.STS.DS4 + " - " +
				"S5 : " + SW_Access_Action.lancement.STS.DS5;
		return Str;
	}

	// lecture de l'objet StrucSorties
	//.
	//.
	//.
	@GET
	@Path("/StrucSorties")
	@Produces(MediaType.APPLICATION_JSON)
	public StrucSorties LireStrucSorties() {
		return SW_Access_Action.lancement.STS;
	}

	// lecture du Process (Version navigateur)
	//.
	//.
	//.
	@GET
	@Path("/Process")
	@Produces(MediaType.TEXT_PLAIN)
	public String LireProcess() {
		String Str = "Etape : " + SW_Access_Action.lancement.STP.Etape;
		return Str;
	}

	// lecture de l'objet StrucProcess
	//.
	//.
	//.
	@GET
	@Path("/StrucProcess")
	@Produces(MediaType.APPLICATION_JSON)
	public StrucProcess LireStrucProcess() {
		return SW_Access_Action.lancement.STP;
	}

}

