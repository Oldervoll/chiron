/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chiron;
import Klasser.Data;

/**
 *
 * @author Benjamin
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Benjamin
 */
public class Database{

    private String DATABASENAVN = "jdbc:derby://localhost:1527/Chiron;";
    private String databasedriver = "org.apache.derby.jdbc.ClientDriver";
    private Connection forbindelse;
    private Statement setning;

    public Database() throws Exception {
        try {
            Class.forName(databasedriver);
            forbindelse = DriverManager.getConnection(DATABASENAVN);
        } catch (Exception e) {
            System.err.println("*** Feil oppstått: " + e + ". ***");
            e.printStackTrace(System.err);
        }

    }

    public void kobleNedForbindelse() throws Exception {
        try {
            if (forbindelse != null) {
                forbindelse.close();
            }
        } catch (SQLException e) {
            System.err.println("*** Feil oppstått: " + e + ". ***");
            e.printStackTrace(System.err);
        }
    }

    public void skrivUt() throws Exception {
        String eirikSinString = "Select * from untitled";
        setning = forbindelse.createStatement();
        ResultSet res = setning.executeQuery(eirikSinString);

        res.next();
        System.out.println(res.getString("navn"));
        System.out.println(res.getDouble("verdi"));

    }



    public ArrayList sok(String sokeString) throws Exception{
        Statement setning = forbindelse.createStatement();
        ResultSet resultat = setning.executeQuery(sokeString);
        String returnString = "";
        //Data d;
        ArrayList a = new ArrayList(); 
        
        while(resultat.next()){
            returnString += resultat.getString("navn");
            Data d = new Data(resultat.getString(2),resultat.getString(3), resultat.getString(18), resultat.getString(7), resultat.getString(9), resultat.getDouble(10), resultat.getString(12), resultat.getString(13), resultat.getString(14), resultat.getString(16), resultat.getString(17));
            a.add(d);
        }
        return a;
    }

}

