
---------------------------------------Projet CANAM 2023------------------------------------------------------
------Dessin de formes géométriques en JavaCe projet a été réalisé dans le cadre du concours CANAM 2023, qui consiste à créer une application en Java qui permet de dessiner différentes formes géométriques (ellipses, triangles, rectangles, hexagones, losanges) en fonction des attributs choisis par l'utilisateur.--------



Fonctionnalités de l'applicationL'application permet à l'utilisateur de :

- Choisir le type de forme à dessiner parmi les options disponibles 

- Choisir la couleur de la forme à dessiner à l'aide d'un sélecteur de couleur

- Choisir le nom de la forme à dessiner à l'aide d'un champ de texte

- Choisir si la forme doit être pleine ou pas à l'aide d'une case à cocher



- Dessiner la forme dans un panel en cliquant et en glissant la souris ( j'ai estimé qu'il etait mieux de choisir ainsi les caractéristiques de la forme en temps reel plutot que de les entrer dans un champ de texte)

- Exporter l'image générée dans le panel sous format image 

- Stocker les informations sur la forme dessinée dans une base de données MySQL 

- Visualiser les formes stockées dans la base de données dans une table 

- Modifier les informations sur une forme stockée dans la base de données 

- Supprimer une forme stockée dans la base de données 

- Rechercher une forme stockée dans la base de données par son type ou son nom 

- Changer le thème de couleur de l'interface graphique entre clair et sombre 



--------------------------------------------*Technologies utilisées*--------------------------------------------



L'application a été développée en utilisant les technologies suivantes :

-Netbeans est l'IDE utilisé dans ce projet 

- Java : le langage de programmation utilisé pour créer la logique de l'application

- Java Swing : la bibliothèque graphique utilisée pour créer l'interface graphique de l'application

- Java AWT : la bibliothèque graphique utilisée pour dessiner les formes géométriques dans le panel

- FlatLaf : la bibliothèque graphique utilisée pour gérer les thèmes de couleur de l'interface graphique

- MySQL : le système de gestion de base de données utilisé pour stocker les informations sur les formes géométriques

- iBatis Common : la bibliothèque utilisée pour exécuter le script SQL qui crée la base de données canam




-----------------------------------------------*Structure du projet*--------------------------------------------



Le projet est organisé en trois packages :

- MODEL_BD : ce package contient la classe FORME qui représente une forme géométrique et ses attributs

- CONTROLEUR_BD : ce package contient l'interface DAO qui définit les opérations de base sur la base de données canam et la classe FORME_DAO qui implémente cette interface pour gérer les formes géométriques dans la table shape


- VUE : ce package contient les classes VisuZone qui représente la zone dans laquelle la forme apparait pour la visualisation, Menu qui représente la fenêtre principale de l'application et ImageFilter qui représente le filtre de fichiers pour les images





-----------------------------------*Installation et exécution du projet*-------------------------------------


Pour installer et exécuter le projet, il faut suivre les étapes suivantes :

- Télécharger le projet depuis le lien fourni

- Ouvrir le projet dans un environnement de développement intégré (IDE) compatible avec Java,  NetBeans de préférence

- Ajouter les bibliothèques externes FlatLaf et iBatis Common au projet ainsi que jdbc

-un dossier nommé fichiers du projet est fourni et contient les fichiers necessaires

- Configurer la connexion à la base de données MySQL en modifiant les constantes USERNAME et PASSWORD de la classe Connexion


- Exécuter la méthode main de la classe canam pour lancer l'application


- Utiliser l'application pour dessiner, exporter, stocker, visualiser, modifier, supprimer et rechercher des formes géométriques



--------------------------------------------*Auteur et licence*---------------------------------------------



Le projet a été réalisé par DONFACK PASCAL ARTHUR (TIGER FOX), un étudiant en informatique L3 de l'Ecole Nationale Supérieure Polytechnique de Yaounde passionné par le dessin , le devellopement, et les mathématiques. Le projet est sous licence GNU General Public License v1.0, ce qui signifie qu'il est libre et open source. Vous pouvez le modifier, le distribuer et l'utiliser à des fins personnelles ou commerciales, à condition de respecter les termes de la licence.
