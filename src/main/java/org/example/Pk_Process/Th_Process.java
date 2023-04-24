package org.example.Pk_Process;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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
    LocalDateTime waitButton;
    boolean clignote;

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
                m_STE = (StrucEntrees) m_L.STE.clone();
            }
            synchronized (m_L.STS) {
                m_STS = (StrucSorties) m_L.STS.clone();
            }

            // Test D�faut
            if (true) {
                //.
                //.
                //.
            }


            if (m_L.STE.DE1 && m_L.STP.Etape != 0 && LocalDateTime.now().isAfter(waitButton)) {
                m_L.STP.Etape = 9;
                m_STS.DS1 = false;
                m_STS.DS2 = false;
                m_STS.DS3 = false;
                m_STS.DS4 = false;
                m_STS.DS5 = false;
                m_STS.DS6 = false;
                m_STS.DS7 = false;
                m_STS.DS8 = false;
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
                        waitButton = LocalDateTime.now().plusSeconds(1);
                        System.out.println("Machine en marche !");
                    }
                    break;

                case 1:
                    if (date == null) {
                        date = LocalDateTime.now().plusSeconds(30);//30 secondes
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
                        m_STS.DS1 = false;

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
                        date = LocalDateTime.now().plusSeconds(30);//30 secondes
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
                        date = null;
                        dateIterateur = null;
                    }
                    break;
                case 4:
                    if (date == null) {
                        date = LocalDateTime.now().plusSeconds(45); //45 secondes
                    }
                    if (dateIterateur == null) {
                        dateIterateur = LocalDateTime.now().plus(500L, ChronoUnit.MILLIS);
                    }
                    if (LocalDateTime.now().isAfter(dateIterateur) && clignote) {
                        System.out.println("Clignote");
                        m_STS.DS5 = !m_STS.DS5;
                        dateIterateur = LocalDateTime.now().plus(500L, ChronoUnit.MILLIS);
                    }
                    System.out.println("Poids : " + m_STE.AnaE2);

                    if (LocalDateTime.now().isAfter(date)) {
                        if (m_STE.AnaE2 <= m_L.STP.Poids_Maximum && m_STE.AnaE2 >= m_L.STP.Poids_Minimum ) {
                            if (m_STE.DE3){
                                m_L.STP.Etape = 5;
                                m_STS.DS5 = true;
                                m_STS.DS4 = false;
                                date = null;
                                dateIterateur = null;
                            }
                        } else {
                            clignote = true;
                            if (m_STE.DE5) {
                                m_STS.DS5 = false;
                                m_L.STP.Etape = 8;
                                m_STS.DS4 = false;
                                m_STS.DS7 = true;
                                date = null;
                                dateIterateur = null;
                            }
                        }
                    }
                    break;

                case 5:
                    if (date == null) {
                        date = LocalDateTime.now().plusSeconds(30);//30 secondes
                    }
                    if (dateIterateur == null) {
                        dateIterateur = LocalDateTime.now().plusSeconds(1);
                    }
                    if (LocalDateTime.now().isAfter(dateIterateur)) {
                        m_STS.DS6 = !m_STS.DS6;
                        System.out.println("Clignotement de la LED de remplissage !");
                        dateIterateur = LocalDateTime.now().plusSeconds(1);
                    }
                    if (LocalDateTime.now().isAfter(date)) {
                        m_STS.DS6 = true;
                        m_L.STP.Etape = 6;
                        date = null;
                        dateIterateur = null;
                    }
                    break;

                case 6:
                    if (m_STE.DE4) {
                        m_L.STS.DS8 = true;
                        m_L.STP.Etape = 7;
                    }
                    break;
                case 7:
                    if (date == null) {
                        date = LocalDateTime.now().plusSeconds(15); //15secondes
                    }
                    if (LocalDateTime.now().isAfter(date)) {
                        System.out.println("Expedition effectuée");
                        m_STS.DS3 = false;
                        m_STS.DS5 = false;
                        m_STS.DS6 = false;
                        m_STS.DS8 = false;
                        m_L.STP.Etape = 1;
                        date = null;
                        dateIterateur = null;
                    }
                    break;

                case 8:
                    if (m_L.STE.DE4) {
                        m_STS.DS3 = false;
                        m_STS.DS5 = false;
                        m_STS.DS7 = false;
                        m_L.STP.Etape = 1;
                        date = null;
                        dateIterateur = null;
                    }
                    break;

                case 9:

                    if (dateIterateur == null) {
                        dateIterateur = LocalDateTime.now().plusSeconds(2);
                    }
                    if (LocalDateTime.now().isAfter(dateIterateur)) {
                        m_STS.DS1 = !m_STS.DS1;
                        m_STS.DS2 = !m_STS.DS2;
                        m_STS.DS3 = !m_STS.DS3;
                        m_STS.DS4 = !m_STS.DS4;
                        m_STS.DS5 = !m_STS.DS5;
                        m_STS.DS6 = !m_STS.DS6;
                        m_STS.DS7 = !m_STS.DS7;
                        m_STS.DS8 = !m_STS.DS8;
                        System.out.println("Clignotement");
                        dateIterateur = LocalDateTime.now().plusSeconds(2);
                    }

                    if (m_L.STE.DE5) {
                        m_L.Raz();
                        date = null;
                        dateIterateur = null;
                    }
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
                m_L.STS = (StrucSorties) m_STS.clone();
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
