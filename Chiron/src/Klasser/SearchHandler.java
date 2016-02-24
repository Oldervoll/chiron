/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Klasser;

import chiron.Database;
/**
 *
 * @author Sondre
 */
public class SearchHandler {
    
    public String testSok(String nr) throws Exception {
        Database db = new Database();
        
        String sok = "Select * from produkt, salgsvare, batch where produkt.kat_nr = '"+nr+"'";
        
        return db.sok(sok);
    }
    
}
