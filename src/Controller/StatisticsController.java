/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import entitie.evenement;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.event_service;

/**
 * FXML Controller class
 *
 * @author lmol
 */
public class StatisticsController implements Initializable {

    @FXML
    private BarChart<String, Number> stat;
    @FXML
    private NumberAxis fxevents;
    @FXML
    private CategoryAxis fxusers;
    @FXML
    private AnchorPane body;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        event_service es=new event_service();
          Map list=new HashMap<String,Integer>();
          list=es.readStat(); //service
     long i = 0;
     stat.setScaleX(1);
     stat.setScaleY(1);
     
     
     
     
     
     
Iterator<Map.Entry<Integer, Integer>> it = list.entrySet().iterator();
while (it.hasNext()) {
    Map.Entry<Integer, Integer> pair = it.next();
    System.out.println(pair.getValue());
    System.out.println(pair.getKey());
     XYChart.Series series1 = new XYChart.Series();
          
        series1.getData().add(new XYChart.Data( pair.getKey(),pair.getValue()));
           stat.getData().add(series1);
}
          
          
          
          
          
          
          
    
       
      
              
    
    }    

    @FXML
    private void returnCatego(ActionEvent event) {
        
           final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/Categorie.fxml"));
        final Node node;
        try {
            node = fxmlLoader.load();
            AnchorPane pane=new AnchorPane(node);
            body.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
