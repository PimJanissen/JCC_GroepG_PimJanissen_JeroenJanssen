/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groepg.opdracht1.verzamelapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author gebruiker-pc
 */
public class DatabaseMediator
{

    private Properties properties;

    private Connection connection;

    public DatabaseMediator(Properties properties)
    {
        this.properties = properties;

        try
        {
            this.initConnection();
        }
        catch (SQLException exc)
        {
            System.err.println(exc.getMessage());
        }
    }

    public ArrayList<Set> loadSets() throws IOException
    {
        if (this.connection != null)
        {
            try
            {
                Statement statement = this.connection.createStatement();
                ResultSet resultSetBier = statement.executeQuery("SELECT s.ID AS S_ID, s.naam AS S_NAAM, s.jaar AS S_JAAR, b.ID AS B_ID, b.uitgavejaar AS B_UITGAVEJAAR, b.merk AS B_MERK FROM setjes s LEFT JOIN bierdopje b ON b.set_ID = s.ID ORDER BY s.ID, b.ID");

                ArrayList<Set> sets = new ArrayList<>();

                while (resultSetBier.next())
                {
                    String setNaam = resultSetBier.getString("S_NAAM");

                    Set set = null;

                    for (Set s : sets)
                    {
                        if (s.getNaam().equals(setNaam))
                        {
                            set = s;
                        }
                    }

                    if (set == null)
                    {
                        Date setJaar = resultSetBier.getDate("S_JAAR");
                        set = new Set(setNaam, setJaar);
                        sets.add(set);
                    }

                    if (resultSetBier.getInt("B_ID") != 0)
                    {

                        Date uitgaveJaar = resultSetBier.getDate("B_UITGAVEJAAR");
                        String merk = resultSetBier.getString("B_MERK");
                        Bierdopje bierdopje = new Bierdopje(merk, uitgaveJaar);
                        set.addVoorwerp(bierdopje);
                    }
                }

                ResultSet resultSetPostZegel = statement.executeQuery("SELECT s.ID AS S_ID, s.naam AS S_NAAM, s.jaar AS S_JAAR, p.ID AS P_ID, p.uitgavejaar AS P_UITGAVEJAAR, p.lengte AS P_LENGTE, p.breedte AS P_BREEDTE FROM setjes s LEFT JOIN postzegel p ON p.set_ID = s.ID ORDER BY s.ID, p.ID");

                while (resultSetPostZegel.next())
                {
                    String setNaam = resultSetPostZegel.getString("S_NAAM");

                    Set set = null;

                    for (Set s : sets)
                    {
                        if (s.getNaam().equals(setNaam))
                        {
                            set = s;
                        }
                    }

                    if (set == null)
                    {
                        Date setJaar = resultSetPostZegel.getDate("S_JAAR");
                        set = new Set(setNaam, setJaar);
                        sets.add(set);
                    }

                    if (resultSetPostZegel.getInt("P_ID") != 0)
                    {
                        Date uitgaveJaar = resultSetPostZegel.getDate("P_UITGAVEJAAR");
                        int lengte = resultSetPostZegel.getInt("P_LENGTE");
                        int breedte = resultSetPostZegel.getInt("P_BREEDTE");
                        Postzegel postzegel = new Postzegel(lengte, breedte, uitgaveJaar);
                        set.addVoorwerp(postzegel);
                    }
                }

                return sets;
            }
            catch (SQLException exc)
            {
                System.err.println(exc.getMessage());
                return null;
            }
        }

        return null;
    }
    //    public void save(Collectie collectie) throws IOException;

    private void initConnection() throws SQLException
    {
        String driver = properties.getProperty("driver");

        if (driver != null)
        {
            System.setProperty("jdbc.drivers", driver);
        }

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        this.connection = DriverManager.getConnection(url, username, password);
    }

    private void closeConnection()
    {
        if (this.connection != null)
        {
            try
            {
                this.connection.close();
            }
            catch (SQLException exc)
            {
                System.err.println(exc.getMessage());
            }
        }
    }
}
