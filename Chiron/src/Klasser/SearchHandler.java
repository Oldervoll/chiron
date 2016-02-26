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
    
    public ArrayList testSok(String katnr, String casnr, String name, String batchnr) throws Exception {
        Database db = new Database();
        
        String sok =  "Select * from produkt,batch,salgsvare where produkt.kat_nr like '%"+katnr+"%' and batch.FULL_KAT like '%"+katnr+"%' and salgsvare.FULL_KAT like '%"+katnr+"%'";
        
        
        if(casnr != null && !casnr.equals("")){
            sok += " and produkt.CASNR like '%"+casnr+"%'";
        }
        
        if(name != null && !name.equals("")){
            sok += " and produkt.NAVN like '%"+name+"%'";
        }
        
        if(batchnr != null && !batchnr.equals("")){
            sok += " and batch.BATCH_NR = "+batchnr;
        }
        ArrayList b = db.sok(sok);
        
        for(int i = 0; i<b.size(); i++){
            System.out.println(b.get(i));
        }
        
        return b;
        
        
    }
    
}
