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
abstract class Voorwerp {

    /*
     * Fields
     */
    private Date uitgaveJaar;

    /*
    
    */
    public void setUitgaveJaar(Date uitgaveJaar) {
        this.uitgaveJaar = uitgaveJaar;
    }

    public Date getUitgaveJaar() {
        return uitgaveJaar;
    }

    /*
     * Consttructoren
     */
    public Voorwerp(Date uitgaveJaar) {
        this.uitgaveJaar = uitgaveJaar;
    }
}
