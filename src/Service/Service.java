package Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rechad
 */
public class Service {
    private String libelle;
    private int tarif;
    
    public Service(String libelleService, int tarifService){
        this.libelle=libelleService;
        this.tarif=tarifService;
    }
}