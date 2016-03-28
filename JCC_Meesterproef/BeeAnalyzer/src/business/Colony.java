/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author gebruiker-pc
 */
public class Colony
{

    private final int year;
    private final Queen queen;
    private Colony parentColony;

    private final ArrayList<Bee> bees;

    public int getYear()
    {
        return year;
    }

    public Queen getQueen()
    {
        return queen;
    }

    public ArrayList<Bee> getBees()
    {
        return (ArrayList<Bee>) Collections.unmodifiableList(bees);
    }

    public Colony getParentColony()
    {
        return parentColony;
    }

    public void setParentColony(Colony parentColony)
    {
        this.parentColony = parentColony;
    }

    public Colony(int year, Queen queen, ArrayList<Bee> bees)
    {
        this.year = year;
        this.queen = queen;
        this.bees = new ArrayList<>();
    }
}
