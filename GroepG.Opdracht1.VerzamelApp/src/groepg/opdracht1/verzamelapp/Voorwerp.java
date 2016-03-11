/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groepg.opdracht1.verzamelapp;

import java.util.Date;

/*
 * @author Pim Janissen
 * @author Jeroen Janssen
 */
public abstract class Voorwerp
{

    /*
     * Fields
     */
    private Date uitgaveJaar;

    /*
    
     */
    public void setUitgaveJaar(Date uitgaveJaar)
    {
        this.uitgaveJaar = (Date) uitgaveJaar.clone();
    }

    public Date getUitgaveJaar()
    {
        return (Date) uitgaveJaar.clone();
    }

    /*
     * Consttructoren
     */
    public Voorwerp(Date uitgaveJaar)
    {
        this.uitgaveJaar = (Date) uitgaveJaar.clone();
    }
    
    @Override
    public String toString()
    {
        return String.format("Uitgavejaar: %s", this.uitgaveJaar.toString());
    }
}
