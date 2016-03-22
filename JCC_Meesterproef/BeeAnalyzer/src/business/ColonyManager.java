/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import persistance.JSONHandler;

/**
 *
 * @author gebruiker-pc
 */
public class ColonyManager
{
    private ArrayList<Colony> colonies;
    
    public ColonyManager()
    {
        this.colonies = new ArrayList<>();
    }

    public ArrayList<Colony> getBeeHives()
    {
        return (ArrayList<Colony>)Collections.unmodifiableList(colonies);
    }
    
    public void loadBeeHives(String filePath) throws IOException
    {
        colonies.addAll(JSONHandler.loadColonies(filePath));
    }
}
