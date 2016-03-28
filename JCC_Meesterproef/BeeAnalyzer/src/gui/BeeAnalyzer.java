/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import business.ColonyManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author gebruiker-pc
 */
public class BeeAnalyzer extends Application
{

    private static ColonyManager manager;

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            throw new IllegalArgumentException("Must add a filepath when opening the application.");
        }

        manager = new ColonyManager();

        try
        {
            manager.loadBeeHives(args[0]);
        }
        catch (Exception ex)
        {
            System.err.println(ex);
        }

        launch(args);
    }

}
