/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groepg.opdracht1.verzamelapp;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

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
        this.jaar = (Date) jaar.clone();
    }

    public String getNaam()
    {
        return naam;
    }

    public Date getJaar()
    {
        return (Date) jaar.clone();
    }

    public ArrayList<Voorwerp> getVoorwerpen()
    {
        return new ArrayList<>(Collections.unmodifiableList(voorwerpen));
    }

    public ArrayList<Postzegel> getPostzegels()
    {
        ArrayList<Postzegel> postzegels = new ArrayList<>();

        for (Voorwerp voorwerp : this.voorwerpen)
        {
            if (voorwerp instanceof Postzegel)
            {
                postzegels.add((Postzegel) voorwerp);
            }
        }

        Collections.sort(postzegels);

        return postzegels;
    }

    /*
     * Constructoren
     */
    public Set(String naam, Date jaar)
    {
        this.naam = naam;
        this.jaar = (Date) jaar.clone();
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
    public boolean equals(Object other)
    {
        if (other == null)
        {
            return false;
        }

        if (other instanceof Set)
        {
            throw new InvalidParameterException();
        }

        return Integer.compare(this.hashCode(), other.hashCode()) == 0;
    }

    /*
    Generated
     */
    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.naam);
        hash = 29 * hash + Objects.hashCode(this.jaar);
        hash = 29 * hash + Objects.hashCode(this.voorwerpen);
        return hash;
    }

    @Override
    public int compareTo(Set other)
    {
        int returnValue = this.jaar.compareTo(other.jaar);

        if (returnValue != 0)
        {
            returnValue = this.naam.compareTo(other.naam);
            
            if (returnValue != 0)
            {
                returnValue = Integer.compare(this.voorwerpen.size(), other.voorwerpen.size());
            }
        }
        
        return returnValue;
    }
}
