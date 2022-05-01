/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivetree;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 *
 * @author shelm
 */
public class RecursiveTree extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //create HBox for a text field
        HBox hBox = new HBox(10);
        
        //create text field to allow user to determine length
        TextField tfOrder = new TextField();
        tfOrder.setPrefColumnCount(4);
        tfOrder.setAlignment(Pos.BOTTOM_RIGHT);
        
        //add to HBox with a label
        hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
        hBox.setAlignment(Pos.CENTER);
        
        //add TreePane and create OnAction event to get depth for recursion
        TreePane pane = new TreePane();
        tfOrder.setOnAction(e -> {
            pane.setDepth(Integer.parseInt(tfOrder.getText()));
        });
        
        //create a BorderPane for window
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(hBox);
        borderPane.setCenter(pane);
        
        //set scene and primary stage
        Scene scene = new Scene(borderPane, 200, 210);
        primaryStage.setTitle("Render Tree");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    static class TreePane extends Pane {
        //saves values to be used by class
        private int depth = 0;
        private double angleFactor = Math.PI / 5;
        private double sizeFactor = 0.58;
        
        // method for recursion depth
        public void setDepth(int depth) {
            this.depth = depth;
            paint();
        }
        
        //method to create tree
        public void paint() {
            //removes children from pane
            getChildren().clear();
            
            //create branches
            paintBranch(depth, getWidth() / 2, getHeight() - 10, getHeight() / 3, Math.PI / 2);
        }
        
        //method to call recursively, creates branches for tree
        public void paintBranch(int depth, double x1, double y1, double length, double angle) {
            //create recursion
            //create branch if depth is greater or equal to 0
            if (depth >= 0) {
                double x2 = x1 + Math.cos(angle) * length;
                double y2 = y1 - Math.sin(angle) * length;
                getChildren().add(new Line(x1, y1, x2, y2));
                
                //call recursion
                //left branch
                paintBranch(depth - 1, x2, y2, length * sizeFactor, angle + angleFactor);
                //right branch
                paintBranch(depth - 1, x2, y2, length * sizeFactor, angle - angleFactor);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
