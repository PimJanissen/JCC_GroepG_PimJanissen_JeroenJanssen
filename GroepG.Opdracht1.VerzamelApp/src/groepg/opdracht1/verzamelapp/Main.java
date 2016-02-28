/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groepg.opdracht1.verzamelapp;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        sets = new ArrayList<>();
        sets.add(createSet());
        showSets();
    }

    private static Set createSet()
    {
        Set set = new Set("Bierdopjes", new Date());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

        try
        {
            set.addVoorwerp(new Bierdopje("Heineken", dateFormat.parse("12-01-2016")));
            set.addVoorwerp(new Bierdopje("Hertog Jan", dateFormat.parse("15-8-2015")));
            set.addVoorwerp(new Postzegel(12, 25, yearFormat.parse("2011")));
            set.addVoorwerp(new Postzegel(18, 13, yearFormat.parse("1995")));
            set.addVoorwerp(new Postzegel(8, 20, yearFormat.parse("2001")));
        } 
        catch (Exception e)
        {

        }

        return set;
    }
    
    private static boolean showSets(){
    
            System.out.printf("these are your sets %s", sets);
            return true;
    }
}
