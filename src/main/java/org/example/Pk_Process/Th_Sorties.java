package org.example.Pk_Process;

public class Th_Sorties extends Thread {

    // Temps de Cycle d'�criture des sorties (en ms)
    int CycleSorties = 10;
    // R�f�rence sur l'objet Lancement
    Lancement m_L;
    private

    // Gestion de la fin du thread
    boolean Term = true;

    public Th_Sorties(Lancement L) {
        m_L = L;
    }

    public void Finish() {
        Term = false;
    }

    public void setCycleSorties(int Val) {
        CycleSorties = Val;
    }

    public void run() {

        System.out.println("Demarrage du Thread Sorties");

        while (Term) {

            // Mise � jour synchronis� des sorties physiques de la carte USB
            // en fonction de l'�tat des donn�es membres de l'objet m_L.STS
            //.
            //.
            //.
            synchronized (m_L.Carte) {
                if (m_L.STS.DS1) {
                    m_L.Carte.SetDigitalChannel(1);
                } else {
                    m_L.Carte.ClearDigitalChannel(2);
                }
                if (m_L.STS.DS2) {
                    m_L.Carte.SetDigitalChannel(2);
                } else {

                    m_L.Carte.ClearDigitalChannel(2);

                }
                if (m_L.STS.DS3) {
                    m_L.Carte.SetDigitalChannel(3);
                } else {
                    m_L.Carte.ClearDigitalChannel(3);
                }
                if (m_L.STS.DS4) {
                    m_L.Carte.SetDigitalChannel(4);
                } else {
                    m_L.Carte.ClearDigitalChannel(4);
                }
                if (m_L.STS.DS5) {
                    m_L.Carte.SetDigitalChannel(5);
                } else {
                    m_L.Carte.ClearDigitalChannel(5);
                }
                if (m_L.STS.DS6) {
                    m_L.Carte.SetDigitalChannel(6);
                } else {
                    m_L.Carte.ClearDigitalChannel(6);
                }
                if (m_L.STS.DS7) {
                    m_L.Carte.SetDigitalChannel(7);
                } else {
                    m_L.Carte.ClearDigitalChannel(7);
                }
                if (m_L.STS.DS8) {
                    m_L.Carte.SetDigitalChannel(8);
                } else {
                    m_L.Carte.ClearDigitalChannel(8);
                }
            }


            try {
                Thread.sleep(CycleSorties);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
        System.out.println("Fin du thread Sorties!");
    }
}
