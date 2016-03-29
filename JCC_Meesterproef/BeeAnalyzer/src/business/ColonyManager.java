/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import persistance.JSONHandler;

/**
 *
 * @author gebruiker-pc
 */
public class ColonyManager
{
    private final ArrayList<Colony> colonies;
    
    public ColonyManager()
    {
        this.colonies = new ArrayList<>();
    }

    public Iterator<Colony> getColonies()
    {
        return colonies.iterator();
    }
    
    public void loadColonies(String filePath) throws IOException
    {
        colonies.addAll(JSONHandler.loadColonies(filePath));
        colonies.sort(Colony.COMPARE_BY_YEAR);
    }
}
