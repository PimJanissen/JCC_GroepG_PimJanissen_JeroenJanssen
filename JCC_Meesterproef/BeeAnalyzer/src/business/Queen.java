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
public class Queen extends Female
{

    private Male drone;
    private Female princess;

    public Male getDrone()
    {
        return drone;
    }

    public void setDrone(Male drone)
    {
        this.drone = drone;
    }

    public Female getPrincess()
    {
        return princess;
    }

    public void setPrincess(Female princess)
    {
        this.princess = princess;
    }

    public Queen(int primaryFertility, double primaryLifespan, double primaryPollination, String primarySpecies, double primaryWorkspeed, int secondaryFertility, double secondaryLifespan, double secondaryPollination, String secondarySpecies, double secondaryWorkspeed)
    {
        super(primaryFertility, primaryLifespan, primaryPollination, primarySpecies, primaryWorkspeed, secondaryFertility, secondaryLifespan, secondaryPollination, secondarySpecies, secondaryWorkspeed);
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.drone);
        hash = 59 * hash + Objects.hashCode(this.princess);
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
        final Queen other = (Queen) obj;
        if (!Objects.equals(this.drone, other.drone))
        {
            return false;
        }
        if (!Objects.equals(this.princess, other.princess))
        {
            return false;
        }
        return true;
    }
    
    
}
