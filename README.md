# Projet K8055

## Travail de groupe

* Corentin Maheo
* Paul Coignac
* Gillian Le Pevedic

## Lancement

* Run sur la classe Lancement
* chemin tomcat : http://localhost:8080

## Environnement

* Développement sous Windows
* IDE : IntelliJ IDEA
* Java 20
* Spécification Java EE : Jakarta
* Serveur : Tomcat 10.0.27


## Roadmap

* [x] **Appui sur E1**
  - [x] Démarrage de la chaîne de production
  - [x] La sortie D1 s'allume indiquant que la ligne est en production. 
  - [x] Le containeur se déplace jusqu'au poste de remplissage
- [x] **Attendre 30 secondes**
  - [x] Pendant ce temps la sortie D2 clignote (Fréquence 1 seconde)
  - [x] La sortie D2 s'allume fixe indiquant que le container est en position.
- [x] **Rotation potentiomètre Ana 1** (avec un tournevis).
  - [x] On tourne le potentiomètre jusqu’à atteindre le niveau indiqué entre Min et Max 
  - [x] Remplissage dans la classe « StrucProcess ».
  - [x] La sortie D3 s'allume indiquant que le conteneur est correctement rempli.
- [x] **Appui sur E2**
  - [x] Le conteneur se déplace vers le poste de contrôle. La sortie D2 s'éteint.
- [x] **Attendre 30 secondes**
  - [x] Pendant ce temps la sortie D4 clignote (Fréquence 1 seconde)
  - [x] La sortie D4 s'allume fixe indiquant que le conteneur est en position.
- [x] **Rotation potentiomètre Ana 2** (avec un tournevis).
  -[x] On tourne le potentiomètre pour indiquer un poids.
- [x] **Attendre 45 secondes**
  - [x] Si OK : La sortie D5 s'allume indiquant que le poids du conteneur est correct. 
  - [x] Si NOK : D5 clignote 
- [x] **Appui sur E3** (Si poids correct)
Le conteneur se déplace vers le poste d'expédition.
La sortie D4 s'éteint. 
- [x] **Attendre 30 secondes**
  - [x] Pendant ce temps la sortie D6 clignote (Fréquence 1 seconde)
  - [x] La sortie D6 s'allume fixe indiquant que le conteneur est en position. 
- [x] **Appui sur E4**
  - [x] La sortie D8 s'allume. 
- [x] **Attendre 15 secondes**
  - [x] Expédition effectuée
  - [x] La sortie D1 s'éteint
  - [x] La sortie D3 s'éteint
  - [x] La sortie D5 s'éteint
  - [x] La sortie D6 s'éteint
  - [x] La sortie D8 s'éteint. Fin de process. Retour à l'étape 1.
- [x] **Appui sur E5** (Si poids incorrect)
  - [x] La sortie D7 s'allume indiquant la mise au rebut du conteneur.
- [x] **Appui sur E4**
  - [x] La sortie D1 s'éteint
  - [x] La sortie D3 s'éteint
  - [x] La sortie D5 s'éteint
  - [x] La sortie D7 s'éteint. Fin de process. Retour à l'étape 1
