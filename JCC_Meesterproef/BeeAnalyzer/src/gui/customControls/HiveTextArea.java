/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.customControls;

import business.Colony;
import javafx.scene.control.TextArea;

/**
 *
 * @author gebruiker-pc
 */
public class HiveTextArea extends TextArea
{

    private Colony colony;

    public HiveTextArea(int locationX, int locationY, Colony colony)
    {
        this.setLayoutX(locationX);
        this.setLayoutY(locationY);

        this.setStyle("-fx-background: #555555;");
        this.setPrefSize(100, 50);

        this.setEditable(false);

        this.setColony(colony);
    }

    public int getMiddleXCoordinate()
    {
        return (int) Math.round(this.getLayoutX() + this.getPrefWidth() / 2);
    }

    public int getTopYCoordinate()
    {
        return (int) Math.round(this.getLayoutY());
    }

    public int getBottomYCoordinate()
    {
        return (int) Math.round(this.getLayoutY() + this.getPrefHeight());
    }

    public void setColony(Colony colony)
    {
        if (colony == null)
        {
            throw new IllegalArgumentException("Colony can not be null.");
        }

        this.colony = colony;
        this.setText(colony.toString());
    }

    @Override
    public String toString()
    {
        return String.format("Locatie X: %s, Locatie Y: %s, Colony:%s\n", Double.toString(this.getLayoutX()), Double.toString(this.getLayoutY()), Integer.toString(this.colony.getYear()));
    }
}
