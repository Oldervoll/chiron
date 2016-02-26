/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Klasser;

/**
 *
 * @author Sondre
 */
public class Data {
    String katnr;
    String casnr;
    String fullkatnr;
    String name;
    String batchnr; 
    String enhet;
    double mengde;
    String purity;
    String konsentrasjon;
    String testyear;
    String plassering;
    String kommentar;
    
    public Data(String katnr, String casnr, String fullkatnr, String name, String batchnr, String enhet, double mengde, String purity, String konsentrasjon, String testyear, String plassering, String kommentar){
        this.katnr = katnr;
        this.casnr = casnr;
        this.fullkatnr = fullkatnr;
        this.name = name;
        this.batchnr = batchnr;
        this.enhet = enhet;
        this.mengde = mengde;
        this.purity = purity;
        this.konsentrasjon = konsentrasjon;
        this.testyear = testyear;
        this.plassering = plassering;
        this.kommentar = kommentar; 
    }

    public String getKatnr() {
        return katnr;
    }

    public void setKatnr(String katnr) {
        this.katnr = katnr;
    }

    public String getCasnr() {
        return casnr;
    }

    public void setCasnr(String casnr) {
        this.casnr = casnr;
    }

    public String getFullkatnr() {
        return fullkatnr;
    }

    public void setFullkatnr(String fullkatnr) {
        this.fullkatnr = fullkatnr;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    public String getBatchnr() {
        return batchnr;
    }

    public void setBatchnr(String batchnr) {
        this.batchnr = batchnr;
    }

    public String getEnhet() {
        return enhet;
    }

    public void setEnhet(String enhet) {
        this.enhet = enhet;
    }

    public double getMengde() {
        return mengde;
    }

    public void setMengde(double mengde) {
        this.mengde = mengde;
    }

    public String getPurity() {
        return purity;
    }

    public void setPurity(String purity) {
        this.purity = purity;
    }

    public String getKonsentrasjon() {
        return konsentrasjon;
    }

    public void setKonsentrasjon(String konsentrasjon) {
        this.konsentrasjon = konsentrasjon;
    }

    public String getTestyear() {
        return testyear;
    }

    public void setTestyear(String testyear) {
        this.testyear = testyear;
    }

    public String getPlassering() {
        return plassering;
    }

    public void setPlassering(String plassering) {
        this.plassering = plassering;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
    
}
