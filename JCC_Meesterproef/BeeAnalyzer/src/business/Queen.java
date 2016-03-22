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

    public Queen(int primaryFertility, int primaryLifespan, int primaryPollination, String primarySpecies, int primaryWorkspeed, int secondaryFertility, int secondaryLifespan, int secondaryPollination, String secondarySpecies, int secondaryWorkspeed)
    {
        super(primaryFertility, primaryLifespan, primaryPollination, primarySpecies, primaryWorkspeed, secondaryFertility, secondaryLifespan, secondaryPollination, secondarySpecies, secondaryWorkspeed);
    }
}
