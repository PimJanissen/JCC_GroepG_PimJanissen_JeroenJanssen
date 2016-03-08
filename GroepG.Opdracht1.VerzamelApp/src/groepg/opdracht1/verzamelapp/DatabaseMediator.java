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
                ResultSet resultSet = statement.executeQuery("SELECT s.ID AS S_ID, s.naam AS S_NAAM, s.jaar AS S_JAAR, b.ID AS B_ID, b.uitgavejaar AS B_UITGAVEJAAR, b.merk AS B_MERK\n"
                        + "FROM setjes s\n"
                        + "LEFT JOIN bierdopje b ON b.set_ID = s.ID\n"
                        + "ORDER BY s.ID, b.ID;");

                ArrayList<Set> sets = new ArrayList<>();
                
                while (resultSet.next())
                {
                    String setNaam = resultSet.getString("S_NAAM");
                    
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
                        Date setJaar = resultSet.getDate("S_JAAR");
                        set = new Set(setNaam, setJaar);
                    }
                    
                    Bierdopje bierdopje = new Bierdopje();
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

    public void save(Collectie collectie) throws IOException;

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
