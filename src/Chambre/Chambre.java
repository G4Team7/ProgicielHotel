/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chambre;

/**
 *
 * @author Yaniv
 */
public class Chambre {
    private int numero;
    private String type;
    private int tarif;
    private String categorie;
    private boolean statut;
    
    public Chambre(int num, String typeChambre, int tarifChambre, String categ, boolean statutChambre){
        this.numero = num;
        this.type = typeChambre;
        this.tarif = tarifChambre;
        this.categorie = categ;
        this.statut = statutChambre;
        
    }
    
    
    
}
