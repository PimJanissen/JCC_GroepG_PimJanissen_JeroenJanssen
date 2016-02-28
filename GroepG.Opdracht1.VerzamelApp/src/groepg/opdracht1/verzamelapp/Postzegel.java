/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groepg.opdracht1.verzamelapp;

import java.security.InvalidParameterException;
import java.util.Date;

/**
 *
 * @author gebruiker-pc
 */
public class Postzegel extends Voorwerp implements Comparable<Postzegel>
{

    private int lengte;

    public int getLengte()
    {
        return lengte;
    }

    public int getBreedte()
    {
        return breedte;
    }
    private int breedte;

    public void setLengte(int lengte)
    {
        this.lengte = lengte;
    }

    public void setBreedte(int breedte)
    {
        this.breedte = breedte;
    }

    public Postzegel(int lengte, int breedte, Date uitgaveJaar)
    {
        super(uitgaveJaar);
        this.lengte = lengte;
        this.breedte = breedte;
    }

    @Override 
    public boolean equals(Object other)
    {
        if (other == null)
        {
            return false;
        }
        
        if (other instanceof Postzegel)
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
        int hash = 7;
        hash = 47 * hash + this.lengte;
        hash = 47 * hash + this.breedte;
        return hash;
    }
    
    @Override
    public int compareTo(Postzegel other)
    {
        return Integer.compare(this.hashCode(), other.hashCode());
    }
}
