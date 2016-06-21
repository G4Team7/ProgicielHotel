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
    private int id;
    private int numero;
    private String type;
    private int tarif;
    private String categorie;
    
    public Chambre(int numId, int num, String typeChambre, int tarifChambre, String categ){
        this.id = numId;
        this.numero = num;
        this.type = typeChambre;
        this.tarif = tarifChambre;
        this.categorie = categ;
    }
    
    
    
}
