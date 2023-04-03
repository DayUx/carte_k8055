package org.example.Pk_Process;

public class Th_Entrees extends Thread{
	
	private
	
	// Gestion de la fin du thread
	boolean Term = true;
	// Temps de Cycle de lecture des entr�es (en ms) 
	int CycleEntrees = 10;
	// R�f�rence sur l'objet Lancement
	Lancement m_L;

	public Th_Entrees(Lancement L)
	{
		m_L = L;
	}
	
	public void Finish()
	{
		Term = false;
	}
	
	public void setCycleEntrees(int Val)
	{
		CycleEntrees = Val;
	}
	
	public void run() {
		
        System.out.println("Demarrage du Thread Entrees");
        
        while (Term)
        {    
        	
					// Lecture synchronis� des entr�es physiques de la carte USB
					// Mise � jour de l'�tat des donn�es membres de l'objet m_L.STE
					//.
					//.
					//.
    		
	    	        	
	        try {
				Thread.sleep(CycleEntrees);
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
        }
        System.out.println("Fin du thread Entrees!");
    }
}
