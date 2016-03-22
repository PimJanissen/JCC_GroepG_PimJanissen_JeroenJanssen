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

    private int year;
    private Queen queen;
    private ArrayList<Bee> bees;

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public Queen getQueen()
    {
        return queen;
    }

    public void setQueen(Queen queen)
    {
        this.queen = queen;
    }

    public ArrayList<Bee> getBees()
    {
        return (ArrayList<Bee>) Collections.unmodifiableList(bees);
    }

    public void setBees(ArrayList<Bee> bees)
    {
        this.bees = bees;
    }

    public Colony(int year, Queen queen)
    {
        this.year = year;
        this.queen = queen;
    }
}
