/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groepg.opdracht1.verzamelapp;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author gebruiker-pc
 */
public class Main
{

    private static ArrayList<Set> sets;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        /*
        sets = new ArrayList<>();
        sets.add(createSet());
        showSets();
         */

        Properties properties = new Properties();
        properties.setProperty("url", "jdbc:mysql://localhost:3306/jcc_verzamelapp");
        properties.setProperty("username", "jcc");
        properties.setProperty("password", "jcc");

        DatabaseMediator database = new DatabaseMediator(properties);

        try
        {
            sets = database.loadSets();

            showSets();
        }
        catch (IOException exc)
        {
            System.err.println(exc.getMessage());
        }
    }

    private static boolean showSets()
    {
        int count = 1;
        for (Set set : sets)
        {
            System.out.printf("Set %s - %s \n", count, sets.get(count - 1).getNaam());

            ArrayList<Voorwerp> voorwerpen = set.getVoorwerpen();
            
            for (int innerCount = 1; innerCount < voorwerpen.size() + 1; innerCount++)
            {
                System.out.printf("Voorwerp %s: %s\n", Integer.toString(innerCount), voorwerpen.get(innerCount - 1).toString());
            }

            count++;
        }

        return true;
    }
}
