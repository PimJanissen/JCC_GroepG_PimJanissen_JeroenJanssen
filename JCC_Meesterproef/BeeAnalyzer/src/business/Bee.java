/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Objects;

/**
 *
 * @author gebruiker-pc
 */
public class Bee
{
    private int primaryFertility;
    private double primaryLifespan;
    private double primaryPollination;
    private String primarySpecies;
    private double primaryWorkspeed;
    private int secondaryFertility;
    private double secondaryLifespan;
    private double secondaryPollination;
    private String secondarySpecies;
    private double secondaryWorkspeed;

    public int getPrimaryFertility()
    {
        return primaryFertility;
    }

    public void setPrimaryFertility(int primaryFertility)
    {
        this.primaryFertility = primaryFertility;
    }

    public double getPrimaryLifespan()
    {
        return primaryLifespan;
    }

    public void setPrimaryLifespan(double primaryLifespan)
    {
        this.primaryLifespan = primaryLifespan;
    }

    public double getPrimaryPollination()
    {
        return primaryPollination;
    }

    public void setPrimaryPollination(double primaryPollination)
    {
        this.primaryPollination = primaryPollination;
    }

    public String getPrimarySpecies()
    {
        return primarySpecies;
    }

    public void setPrimarySpecies(String primarySpecies)
    {
        this.primarySpecies = primarySpecies;
    }

    public double getPrimaryWorkspeed()
    {
        return primaryWorkspeed;
    }

    public void setPrimaryWorkspeed(double primaryWorkspeed)
    {
        this.primaryWorkspeed = primaryWorkspeed;
    }

    public int getSecondaryFertility()
    {
        return secondaryFertility;
    }

    public void setSecondaryFertility(int secondaryFertility)
    {
        this.secondaryFertility = secondaryFertility;
    }

    public double getSecondaryLifespan()
    {
        return secondaryLifespan;
    }

    public void setSecondaryLifespan(double secondaryLifespan)
    {
        this.secondaryLifespan = secondaryLifespan;
    }

    public double getSecondaryPollination()
    {
        return secondaryPollination;
    }

    public void setSecondaryPollination(double secondaryPollination)
    {
        this.secondaryPollination = secondaryPollination;
    }

    public String getSecondarySpecies()
    {
        return secondarySpecies;
    }

    public void setSecondarySpecies(String secondarySpecies)
    {
        this.secondarySpecies = secondarySpecies;
    }

    public double getSecondaryWorkspeed()
    {
        return secondaryWorkspeed;
    }

    public void setSecondaryWorkspeed(double secondaryWorkspeed)
    {
        this.secondaryWorkspeed = secondaryWorkspeed;
    }

    public Bee(int primaryFertility, double primaryLifespan, double primaryPollination, String primarySpecies, double primaryWorkspeed, int secondaryFertility, double secondaryLifespan, double secondaryPollination, String secondarySpecies, double secondaryWorkspeed)
    {
        this.primaryFertility = primaryFertility;
        this.primaryLifespan = primaryLifespan;
        this.primaryPollination = primaryPollination;
        this.primarySpecies = primarySpecies;
        this.primaryWorkspeed = primaryWorkspeed;
        this.secondaryFertility = secondaryFertility;
        this.secondaryLifespan = secondaryLifespan;
        this.secondaryPollination = secondaryPollination;
        this.secondarySpecies = secondarySpecies;
        this.secondaryWorkspeed = secondaryWorkspeed;
    }    

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 89 * hash + this.primaryFertility;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.primaryLifespan) ^ (Double.doubleToLongBits(this.primaryLifespan) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.primaryPollination) ^ (Double.doubleToLongBits(this.primaryPollination) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.primarySpecies);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.primaryWorkspeed) ^ (Double.doubleToLongBits(this.primaryWorkspeed) >>> 32));
        hash = 89 * hash + this.secondaryFertility;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.secondaryLifespan) ^ (Double.doubleToLongBits(this.secondaryLifespan) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.secondaryPollination) ^ (Double.doubleToLongBits(this.secondaryPollination) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.secondarySpecies);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.secondaryWorkspeed) ^ (Double.doubleToLongBits(this.secondaryWorkspeed) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Bee other = (Bee) obj;
        if (this.primaryFertility != other.primaryFertility)
        {
            return false;
        }
        if (Double.doubleToLongBits(this.primaryLifespan) != Double.doubleToLongBits(other.primaryLifespan))
        {
            return false;
        }
        if (Double.doubleToLongBits(this.primaryPollination) != Double.doubleToLongBits(other.primaryPollination))
        {
            return false;
        }
        if (Double.doubleToLongBits(this.primaryWorkspeed) != Double.doubleToLongBits(other.primaryWorkspeed))
        {
            return false;
        }
        if (this.secondaryFertility != other.secondaryFertility)
        {
            return false;
        }
        if (Double.doubleToLongBits(this.secondaryLifespan) != Double.doubleToLongBits(other.secondaryLifespan))
        {
            return false;
        }
        if (Double.doubleToLongBits(this.secondaryPollination) != Double.doubleToLongBits(other.secondaryPollination))
        {
            return false;
        }
        if (Double.doubleToLongBits(this.secondaryWorkspeed) != Double.doubleToLongBits(other.secondaryWorkspeed))
        {
            return false;
        }
        if (!Objects.equals(this.primarySpecies, other.primarySpecies))
        {
            return false;
        }
        if (!Objects.equals(this.secondarySpecies, other.secondarySpecies))
        {
            return false;
        }
        return true;
    }
    
    
}
