package org.example.Pk_Process;

public class Th_IHM extends Thread{
	
	private
	
	// Gestion de la fin du thread
	boolean Term= true;
	// Temps de Cycle du thread Process (en ms) 
	int CycleIHM = 10;
	// R�f�rence sur l'objet Lancement
	Lancement m_L;
	
	// Copie de l'objet m_L.STE
	StrucEntrees m_STE; 
	// Copie de l'objet m_L.STS
	StrucSorties m_STS;
	// Copie de l'objet m_L.STP
	StrucProcess m_STP;
	
	public void Finish()
	{
		Term = false;
	}
	
	public Th_IHM(Lancement L)
	{
		m_L = L;
	}
	
	public void run() {
		
        System.out.println("Demarrage du Thread IHM");
		
        while (Term)
        {
        	// Copie synchonis�e des objets  m_L.STE, m_L.STS m_STP dans m_STE m_STS et m_STP

			synchronized (m_L.STE) {
				m_STE = m_L.STE;
			}
			synchronized (m_L.STS) {
				m_STS = m_L.STS;
			}
			synchronized (m_L.STP) {
				m_STP = m_L.STP;
			}

        	
        	try {
				Thread.sleep(CycleIHM);
				
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
        }
        System.out.println("Fin du thread IHM!");
    }
}
