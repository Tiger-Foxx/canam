/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CONTROLEUR_BD;

import MODEL_BD.FORME;
import java.util.ArrayList;


/**
 }
 Cette interface définit les opérations de base sur la base de données canam 
  La classe FORME_DAO implémente cette interface pour gérer les formes géométriques dans la table shape 
  L’interface DAO dispose de cinq méthodes abstraites : 
  - insert : qui prend en paramètre un objet de type FORME et qui insère ses informations dans la table shape 
  - update : qui prend en paramètre un objet de type FORME et qui met à jour ses informations dans la table shape
  - delete : qui prend en paramètre un identifiant de type int et qui supprime la forme correspondante de la table shape
  - select : qui retourne une liste d’objets de type FORME contenant toutes les formes de la table shape 
  - search : qui prend en paramètre deux chaînes de caractères représentant le type et le nom de la forme et qui retourne une liste d’objets de type FORME contenant les formes correspondant aux critères de recherche 
  L’interface DAO utilise la classe FORME pour représenter les formes géométriques 
  L’interface DAO utilise la classe ArrayList pour stocker les listes de formes
 * 
 */

/**
 *
 * @author TIGER FOX
 */
public interface DAO {
    public boolean insert(FORME Obj);
    public boolean update(FORME Obj);
    public boolean delete(int ID);
    public ArrayList<FORME> Select();
    public ArrayList<FORME> Search(String type,String name);
}
