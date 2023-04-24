package org.example.Pk_Process;

import java.time.LocalDateTime;

public class Th_Process extends Thread {

    // Temps de Cycle du thread Process (en ms)
    int CycleProcess = 10;
    // R�f�rence sur l'objet Lancement
    Lancement m_L;
    // Copie de l'objet m_L.STE
    StrucEntrees m_STE;
    // Copie de l'objet m_L.STS
    StrucSorties m_STS;

    LocalDateTime date;
    LocalDateTime dateIterateur;

    private

    // Gestion de la fin du thread
    boolean Term = true;

    public Th_Process(Lancement L) {
        m_L = L;
    }

    public void Finish() {
        Term = false;
    }

    public void run() {

        System.out.println("Demarrage du Thread Process");

        while (Term) {

            // Copie synchonis�e des objets  m_L.STE et m_L.STS dans m_STE et m_STS
            //.
            //.
            //.

            synchronized (m_L.STE) {
                m_STE = m_L.STE;
            }
            synchronized (m_L.STS) {
                m_STS = m_L.STS;
            }

            // Test D�faut
            if (true) {
                //.
                //.
                //.
            }


            // Gestion des �tapes du process
            switch (m_L.STP.Etape) {
                case 0:
                    m_STS.DS1 = false;
                    m_STS.DS2 = false;
                    m_STS.DS3 = false;
                    m_STS.DS4 = false;
                    m_STS.DS5 = false;
                    m_STS.DS6 = false;
                    m_STS.DS7 = false;
                    m_STS.DS8 = false;
                    if (m_STE.DE1) {
                        m_STS.DS1 = true;
                        m_L.STP.Etape = 1;
                        System.out.println("Machine en marche !");
                    }
                    break;

                case 1:
                    if (date == null) {
                        date = LocalDateTime.now().plusSeconds(5);
                    }
                    if (dateIterateur == null) {
                        dateIterateur = LocalDateTime.now().plusSeconds(1);
                    }
                    if (LocalDateTime.now().isAfter(dateIterateur)) {
                        m_STS.DS2 = !m_STS.DS2;
                        dateIterateur = LocalDateTime.now().plusSeconds(1);
                    }
                    if (LocalDateTime.now().isAfter(date)) {
                        m_STS.DS2 = true;
                        m_L.STP.Etape = 2;
                        date = null;
                        dateIterateur = null;
                    }
                    break;
                case 2:
                    System.out.println("Niveau de remplissage : " + m_STE.AnaE1);
                    if (m_STE.AnaE1 > m_L.STP.Niveau_Remplissage_Min && m_STE.AnaE1 < m_L.STP.Niveau_Remplissage_Max) {
                        m_STS.DS3 = true;
                        if (m_STE.DE2) {
                            m_STS.DS2 = false;
                            m_L.STP.Etape = 3;
                            System.out.println("Machine remplie !");
                        }
                    } else {
                        m_STS.DS3 = false;
                    }
                    break;

                case 3:
                    if (date == null) {
                        date = LocalDateTime.now().plusSeconds(30);
                    }
                    if (dateIterateur == null) {
                        dateIterateur = LocalDateTime.now().plusSeconds(1);
                    }
                    if (LocalDateTime.now().isAfter(dateIterateur)) {
                        m_STS.DS4 = !m_STS.DS4;
                        System.out.println("Clignotement de la LED de remplissage !");
                        dateIterateur = LocalDateTime.now().plusSeconds(1);
                    }
                    if (LocalDateTime.now().isAfter(date)) {
                        m_STS.DS4 = true;
                        m_L.STP.Etape = 4;
                    }
                    break;

                case 4:
                    //.
                    //.
                    //.
                    break;

                case 5:
                    //.
                    //.
                    //.
                    break;

                case 6:
                    //.
                    //.
                    //.
                    break;

                case 7:
                    //.
                    //.
                    //.
                    break;

                case 8:
                    //.
                    //.
                    //.
                    break;

                case 9:
                    //.
                    //.
                    //.
                    break;

                case 10:
                    //.
                    //.
                    //.
                    break;

                case 11:
                    //.
                    //.
                    //.
                    break;

                case 100:
                    // Traitement des d�fauts
                    //.
                    //.
                    //.

                default:

                    break;

            }

            // Mise � jour synchonis�e de l'objet m_L.STS � partir de m_STS
            //.
            //.
            //.

            synchronized (m_L.STS) {
                m_L.STS = m_STS;
            }


            try {
                Thread.sleep(CycleProcess);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fin du thread Process!");
    }


}
