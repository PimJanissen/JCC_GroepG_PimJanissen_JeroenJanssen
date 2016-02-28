/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groepg.opdracht1.verzamelapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gebruiker-pc
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ArrayList<Set> sets = new ArrayList<>();
        
        fillSets(sets);
    }

    private static void fillSets(ArrayList<Set> listToFill)
    {
        listToFill.add(createSet());
    }
    
    private static Set createSet() throws ParseException
    {
        Set set = new Set("Bierdopjes", new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        set.addVoorwerp(new Bierdopje("Heineken", sdf.parse("12-01-2016")));
    }

}
