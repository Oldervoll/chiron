/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Klasser;

import chiron.Database;
import java.util.ArrayList;
/**
 *
 * @author Sondre
 */
public class SearchHandler {
    
    public ArrayList testSok(String nr) throws Exception {
        Database db = new Database();
        String sok =  "Select * from produkt,batch,salgsvare where produkt.kat_nr = '"+nr+"' and  batch.FULL_KAT like '%"+nr+"%' and salgsvare.FULL_KAT like '%"+nr+"%'";
        
        ArrayList b = db.sok(sok);
        
        for(int i = 0; i<b.size(); i++){
            System.out.println(b.get(i));
        }
        
        return b;
        
        
    }
    
}
