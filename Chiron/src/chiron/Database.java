/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chiron;

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
import javax.swing.JOptionPane;

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

    public int regNyttEksemplar(String isbn) throws Exception {
        setning = forbindelse.createStatement();
        ResultSet res = setning.executeQuery("select * from eksemplar");
        while (res.next()) {
            String isbn2 = res.getString("isbn");
            if (isbn.equals(isbn2)) {
                String sqlSetning = "select max(eks_nr) as maks from eksemplar where isbn = '" + isbn2 + "'";
                res = setning.executeQuery(sqlSetning);
                res.next();
                int nyttNr = res.getInt("maks");
                nyttNr++;
                String sqlSetning2 = "insert into eksemplar(isbn, eks_nr) values ('" + isbn + "', " + nyttNr + ")";
                setning.executeUpdate(sqlSetning2);
                res.close();
                setning.close();
                return nyttNr;
            }
        }
        res.close();
        setning.close();
        return 0;
    }

    public boolean lånUtEksemplar(String isbn, String navn, int eksNr) throws Exception {
        String sqlSetning = " update eksemplar set laant_av = '" + navn + "' where isbn = '" + isbn + "' and eks_nr = " + eksNr + "";
        Statement setning = forbindelse.createStatement();
        int resultat = setning.executeUpdate(sqlSetning);
        if (resultat == 0) {
            setning.close();
            return false;
        }
        setning.close();
        return true;
    }

}

