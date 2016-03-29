/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import business.Colony;
import gui.customControls.HiveTextArea;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 *
 * @author gebruiker-pc
 */
public class FXMLDocumentController implements Initializable
{

    @FXML
    private Label lblSecondarySpecies;

    @FXML
    private Label lblPrimarySpecies;

    @FXML
    private Label lblAverage;

    @FXML
    private TextField tfSecondaryFertility;

    @FXML
    private TextField tfPrimaryFertility;

    @FXML
    private TextField tfSecondaryPollination;

    @FXML
    private TextField tfPrimaryLifespan;

    @FXML
    private TextField tfPrimaryPollination;

    @FXML
    private TextField tfPrimarySpecies;

    @FXML
    private Label lblSecondaryPollination;

    @FXML
    private TextField tfSecondaryLifespan;

    @FXML
    private Label lblFoundingYear;

    @FXML
    private TextField tfBeeCount;

    @FXML
    private Label lblPrimaryFertility;

    @FXML
    private Label lblPrimaryLifespan;

    @FXML
    private Label lblSecondaryLifespan;

    @FXML
    private Label lblPrimaryPollination;

    @FXML
    private TextField tfFoundingYear;

    @FXML
    private Label lblBeeCount;

    @FXML
    private TextField tfSecondarySpecies;

    @FXML
    private Label lblSecondaryFertility;

    @FXML
    private Pane paneHierarchy;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        int locationXStart = 0;
        int locationXEnd = (int)Math.round(this.paneHierarchy.getPrefWidth());
        int locationY = 10;
        Iterator<Colony> colonies = BeeAnalyzer.manager.getColonies();

        if (colonies.hasNext())
        {
            this.drawColony(colonies.next(), locationXStart, locationXEnd, locationY);
        }

        ObservableList<Node> children = this.paneHierarchy.getChildren();
        
        for (Node node : children)
        {
            System.out.print(node.toString());
        }
    }

    private void drawColony(Colony colony, int drawingFieldStartX, int drawingFieldEndX, int locationY)
    {
        int locationX = Math.round((float)(drawingFieldEndX - drawingFieldStartX) / 2) + drawingFieldStartX;
        HiveTextArea hta = new HiveTextArea(locationX, locationY, colony);
        hta.setOnMouseClicked((MouseEvent event)
                -> 
                {
                    this.tfFoundingYear.setText(Integer.toString(colony.getYear()));
                    this.tfBeeCount.setText(Integer.toString(colony.getBeeCount()));
                    this.tfPrimaryFertility.setText(Double.toString(colony.getAveragePrimaryFertility()));
                    this.tfPrimaryLifespan.setText(Double.toString(colony.getAveragePrimaryLifeSpan()));
                    this.tfPrimaryPollination.setText(Double.toString(colony.getAveragePrimaryPollination()));
                    this.tfPrimarySpecies.setText(colony.getAveragePrimarySpecies());
                    this.tfSecondaryFertility.setText(Double.toString(colony.getAverageSecondaryFertility()));
                    this.tfSecondaryLifespan.setText(Double.toString(colony.getAverageSecondaryLifeSpan()));
                    this.tfSecondaryPollination.setText(Double.toString(colony.getAverageSecondaryPollination()));
                    this.tfSecondarySpecies.setText(colony.getAverageSecondarySpecies());
        });
        this.paneHierarchy.getChildren().add(hta);

        Iterator<Colony> childCs = colony.getChildColonies();
        ArrayList<Colony> childColonies = new ArrayList<>();
        while (childCs.hasNext())
        {
            childColonies.add(childCs.next());
        }

        int amountOfChildren = childColonies.size();

        if (amountOfChildren > 0)
        {
            int drawingFieldSize = drawingFieldEndX - drawingFieldStartX;
            int drawingFieldSizeChildren = drawingFieldSize / amountOfChildren;

            for (int i = 0; i < amountOfChildren; i++)
            {
                int startXChild = drawingFieldStartX + i * drawingFieldSizeChildren;
                int endXChild = startXChild + drawingFieldSizeChildren;
                int startYChild = locationY + 100;
                this.drawColony(childColonies.get(i), startXChild, endXChild, startYChild);
                
                Line line = new Line(hta.getMiddleXCoordinate(), hta.getBottomYCoordinate(), Math.round((float)(endXChild - startXChild) / 2) + startXChild + (int)Math.round(hta.getPrefWidth() / 2), startYChild);
                this.paneHierarchy.getChildren().add(line);
            }
        }
    }
}
