/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author gebruiker-pc
 */
public class Bee
{
    private int primaryFertility;
    private int primaryLifespan;
    private int primaryPollination;
    private String primarySpecies;
    private int primaryWorkspeed;
    private int secondaryFertility;
    private int secondaryLifespan;
    private int secondaryPollination;
    private String secondarySpecies;
    private int secondaryWorkspeed;

    public int getPrimaryFertility()
    {
        return primaryFertility;
    }

    public void setPrimaryFertility(int primaryFertility)
    {
        this.primaryFertility = primaryFertility;
    }

    public int getPrimaryLifespan()
    {
        return primaryLifespan;
    }

    public void setPrimaryLifespan(int primaryLifespan)
    {
        this.primaryLifespan = primaryLifespan;
    }

    public int getPrimaryPollination()
    {
        return primaryPollination;
    }

    public void setPrimaryPollination(int primaryPollination)
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

    public int getPrimaryWorkspeed()
    {
        return primaryWorkspeed;
    }

    public void setPrimaryWorkspeed(int primaryWorkspeed)
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

    public int getSecondaryLifespan()
    {
        return secondaryLifespan;
    }

    public void setSecondaryLifespan(int secondaryLifespan)
    {
        this.secondaryLifespan = secondaryLifespan;
    }

    public int getSecondaryPollination()
    {
        return secondaryPollination;
    }

    public void setSecondaryPollination(int secondaryPollination)
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

    public int getSecondaryWorkspeed()
    {
        return secondaryWorkspeed;
    }

    public void setSecondaryWorkspeed(int secondaryWorkspeed)
    {
        this.secondaryWorkspeed = secondaryWorkspeed;
    }

    public Bee(int primaryFertility, int primaryLifespan, int primaryPollination, String primarySpecies, int primaryWorkspeed, int secondaryFertility, int secondaryLifespan, int secondaryPollination, String secondarySpecies, int secondaryWorkspeed)
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
}
