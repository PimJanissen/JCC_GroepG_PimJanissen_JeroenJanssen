/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groepg.opdracht1.verzamelapp;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author gebruiker-pc
 */
public class Collectie
{
    private final ArrayList<Set> sets;

    public ArrayList<Set> getSets()
    {
        return (ArrayList<Set>)Collections.unmodifiableList(sets);
    }
    
    public ArrayList<Voorwerp> getAlleVoorwerpen()
    {
        ArrayList<Voorwerp> voorwerpen = new ArrayList<>();
        
        for(Set set : this.sets)
        {
            voorwerpen.addAll(set.getVoorwerpen());
        }
        
        return voorwerpen;
    }

    public Collectie()
    {
        this.sets = new ArrayList<>();
    }
    
    public boolean addSet(Set set)
    {
        return this.sets.add(set);
    }
    
    public void removeSet(Set set)
    {
        this.sets.remove(set);
    }
}