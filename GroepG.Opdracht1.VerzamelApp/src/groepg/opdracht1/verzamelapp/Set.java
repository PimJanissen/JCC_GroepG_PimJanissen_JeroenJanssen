/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groepg.opdracht1.verzamelapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/*
 * @autor Pim Janissen
 * @author Jeroen Janssen
 */
public class Set implements Comparable<Set>
{

    /*
     * Fields
     */
    private String naam;
    private Date jaar;
    private final ArrayList<Voorwerp> voorwerpen;

    /*
     * Properties
     */
    public void setNaam(String naam)
    {
        this.naam = naam;
    }

    public void setJaar(Date jaar)
    {
        this.jaar = jaar;
    }

    public String getNaam()
    {
        return naam;
    }

    public Date getJaar()
    {
        return jaar;
    }

    public ArrayList<Voorwerp> getVoorwerpen()
    {
        return (ArrayList<Voorwerp>) Collections.unmodifiableList(voorwerpen);
    }

    /*
     * Constructoren
     */
    public Set(String naam, Date jaar)
    {
        this.naam = naam;
        this.jaar = jaar;
        this.voorwerpen = new ArrayList<>();
    }
    
    public boolean addVoorwerp(Voorwerp voorwerp)
    {
        return this.voorwerpen.add(voorwerp);
    }
    
    public void removeVoorwerp(Voorwerp voorwerp)
    {
        this.voorwerpen.remove(voorwerp);
    }
  
    @Override
    public int compareTo(Set other)
    {
        return this.jaar.compareTo(other.getJaar());
    }
}
