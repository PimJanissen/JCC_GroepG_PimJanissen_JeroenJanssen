/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groepg.opdracht1.verzamelapp;

import java.util.Date;

/**
 *
 * @author gebruiker-pc
 */
public class Bierdopje extends Voorwerp
{

    private String merk;

    public String getMerk()
    {
        return merk;
    }

    public void setMerk(String merk)
    {
        this.merk = merk;
    }

    public Bierdopje(String merk, Date uitgaveJaar)
    {
        super(uitgaveJaar);
        this.merk = merk;
    }

    @Override
    public String toString()
    {
        return super.toString() + String.format(" - merk: %s", this.merk);
    }
}
