/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srce;


import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author Milos
 */
public class Srce extends Application {
    
    AnimationTimer timer;
    private Integer q=0;
    
    @Override
    public void start(Stage primaryStage) {
      
 
        StackPane root = new StackPane();
        Group g1 = new Group();  
        Arc a1 = new Arc(0, 0, 100, 70, 0, 180);
            a1.setType(ArcType.OPEN);
            a1.setStroke(Color.RED);
            a1.setFill(null);
            a1.setStrokeWidth(10);
        
        Arc a2 = new Arc(200, 0, 100, 70, 0, 180);
            a2.setType(ArcType.OPEN);
            a2.setStroke(Color.RED);
            a2.setFill(null);
            a2.setStrokeWidth(10);
                  
        Line l1 = new Line(-100,0,100,250);
            l1.setStroke(Color.RED);
            l1.setStrokeWidth(10);
            
        Line l2 = new Line(300,0,100,250);
            l2.setStroke(Color.RED);
            l2.setStrokeWidth(10);
            
            g1.getChildren().addAll(a1,a2,l1,l2);
             
            
        Slider sl = new Slider();
            sl.setMin(0);
            sl.setMax(150);
            sl.setValue(10);
            sl.setShowTickLabels(true);
            sl.setShowTickMarks(true);
            sl.setMajorTickUnit(50);
            sl.setMinorTickCount(5);
            sl.setBlockIncrement(10);
            sl.autosize();
            sl.setMaxSize(300, 200);
            sl.setVisible(true);

        Pane p1 = new Pane();
            sl.setTranslateX(100);
            sl.setTranslateY(300);    
            p1.getChildren().add(sl);

        Scene scene = new Scene(root, 800, 800);
        
        root.getChildren().add(g1);
        root.getChildren().add(sl);
    
     
        
        primaryStage.setTitle("Heart");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        sl.valueProperty().addListener((observable, oldValue, newValue) -> 
        {
            int i = newValue.intValue();
            while (i > sl.getMax()/3 && i < sl.getMax()/2)
            {
                final Timeline timeline = new Timeline();

                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.setAutoReverse(true);
                    
                KeyValue keyValueX = new KeyValue(g1.scaleXProperty(), 2);
                KeyValue keyValueY = new KeyValue(g1.scaleYProperty(), 2);
                Duration duration = Duration.millis(1200);
                
                EventHandler onFinished = new EventHandler<ActionEvent>() {
                 public void handle(ActionEvent t) {
                    g1.setTranslateX(java.lang.Math.random()*200-100);
                    //reset counter
                    q = 0;
                    }
                };
                KeyFrame keyFrame = new KeyFrame(duration, onFinished , keyValueX, keyValueY);
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
                timer.start();
            }
            
            while (i > sl.getMax()/2 && i < sl.getMax()/2/3)
            {
                final Timeline timeline = new Timeline();

                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.setAutoReverse(true);
                KeyValue keyValueX = new KeyValue(g1.scaleXProperty(), 2);
                KeyValue keyValueY = new KeyValue(g1.scaleYProperty(), 2);
                Duration duration = Duration.millis(600);
                
                EventHandler onFinished = new EventHandler<ActionEvent>() {
                 public void handle(ActionEvent t) {
                    g1.setTranslateX(java.lang.Math.random()*200-100);
                    //reset counter
                    q = 0;
                    }
                };
                KeyFrame keyFrame = new KeyFrame(duration, onFinished , keyValueX, keyValueY);
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
                timer.start();
            }
            
             while (i > sl.getMax()/2/3 && i < sl.getMax())
            {
                final Timeline timeline = new Timeline();

                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.setAutoReverse(true);
                KeyValue keyValueX = new KeyValue(g1.scaleXProperty(), 2);
                KeyValue keyValueY = new KeyValue(g1.scaleYProperty(), 2);
                Duration duration = Duration.millis(400);
                
                EventHandler onFinished = new EventHandler<ActionEvent>() {
                 public void handle(ActionEvent t) {
                    g1.setTranslateX(java.lang.Math.random()*200-100);
                    //reset counter
                   q = 0;
                    }
                };
                KeyFrame keyFrame = new KeyFrame(duration, onFinished , keyValueX, keyValueY);
                timeline.getKeyFrames().add(keyFrame);
                timeline.play();
                timer.start();
            }            
        });         
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}





