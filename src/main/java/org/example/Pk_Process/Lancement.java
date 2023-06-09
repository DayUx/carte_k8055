package org.example.Pk_Process;

import k8055n.K8055N;


public class Lancement {

    // Objet de synchronisation pour la gestio des acc�s concurents � la carte USB
    public final Object LOCK_OBJ_CARTE = new Object();

    // Cr�ation des classes de d�finissants la carte
    public StrucEntrees STE = new StrucEntrees();
    public StrucSorties STS = new StrucSorties();
    public StrucProcess STP = new StrucProcess();

    // Cr�ation des threads de Gestion de l'application
    public Th_Entrees Th_E;
    public Th_Sorties Th_S;
    public Th_Process Th_P;
    public Th_IHM Th_I;

    // Objet K8055N (La carte USB)
    public K8055N Carte;

    // Constructeur
    // Cr�ation d'une instance de l'objet K8055N (La carte USB)
    public Lancement() {
        Carte = new K8055N();

        System.out.println("Creation de l'objet K8055N !");
    }

    // M�thode pour l'arr�t de l'application
    public void Fin() {
        Th_E.Finish();
        Th_S.Finish();
        Th_P.Finish();
        Th_I.Finish();
    }

    // M�thode pour le lancement de la production
    public int Lance() {
        int Card;
        int retour = 0;

        Card = Carte.OpenDevice(0);
        if (Card == -10) System.out.println("Fichier K8055D.DLL inconnue !");
        if (Card >= 0) {
            System.out.println("Liaison carte OK !");
        } else {
            System.out.println("Carte absente !");
        }

        if (STP.Etape == 0) {

            //Instanciation et lancement des Threads
			//	.
			//	.
			//	.


            Th_E = new Th_Entrees(this);
            Th_E.start();
            Th_S = new Th_Sorties(this);
            Th_S.start();
            Th_P = new Th_Process(this);
            Th_P.start();
            Th_I = new Th_IHM(this);
            Th_I.start();

            System.out.println("Lancement des Thread Ok !");
        } else {
            retour = 1;
            System.out.println("Une fabrication est en cours !");
        }
        return retour;
    }

    // M�thode pour l'arr�t de la ligne production
    public void Arret() {
        System.out.println("Demande arret machine !");
        try {
            Fin();

            // Attente de la fin des threads
            //.
            //.
            //.

            Th_E.join();
            Th_S.join();
            Th_P.join();
            Th_I.join();


            System.out.println("Machine a l'arret !");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Carte.CloseDevice();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Fin liaison carte K8055 !");

    }

    // M�thode pour une RAZ de la production en cours
    public void Raz() {
        // Mise � jour de la variable "STP.Etape"
        //.
        //.
        //.

		STP.Etape = 0;






        System.out.println("Raz du Process !");
    }

}
