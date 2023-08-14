/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QUESTION3JAVAFX;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Koket
 */
public class PNet extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Setting a title for the stage
        primaryStage.setTitle("PNet App");
//creating the image object and assigning it to image and adds fileinputstream to fetch image
        Image image = new Image(new FileInputStream("q3logo.png"));
//creating the image view object
        ImageView imageView = new ImageView(image);
        //positioning the image view used for painting pictures loaded with image
        imageView.setTranslateX(45);
        imageView.setTranslateY(40);
        //preserve the image quality no matter how much it expands
        imageView.setPreserveRatio(true);
        
        Label userNLabel = new Label("Enter your Name:");
//creates a textfield for the name with maximum width set to 160
        TextField userNametf = new TextField();
        userNametf.setMaxWidth(160);

        Label positionLabel = new Label("Enter the Position:");
//creates a textfield for the position with maximum width set to 160
        TextField positiontf = new TextField();
        positiontf.setMaxWidth(160);

        Label experience = new Label("Enter your Experience:");
//creating a combo box and adding the items that should be options in the combo box
        ComboBox<String> combobox = new ComboBox<>();
        combobox.getItems().addAll("1-5", "6-10", "11-20");
//creating a button with words written apply in it
        Button button = new Button("Apply");
        //sets width size of the button
        button.setMaxWidth(90);
//sets the button style
        button.setStyle("-fx-font-size : 16 px;-fx-border-box:2px;-fx-font-weight:bold;-fx-background-color:#FF0000;-fx-border-style: solid inside;-fx-border-width:2;-fx-border-insets:5;-fx-border-radius:5;-fx-border-color: white; -fx-text-fill: white");
   //adds action event for when the user clicks the mouse     
button.setOnMouseClicked((MouseEvent event) -> {
    //if any of tthe input nodes are empty an error message is displayed to used that one or more fields are empty
    if(userNametf.getText().isEmpty() || positiontf.getText().isEmpty()|| combobox.getValue()==null) {
        Alert alert = new Alert(AlertType.NONE);
        alert.setAlertType(AlertType.ERROR);
        alert.setHeaderText("One or more fields are empty");
        alert.show();
    }
    else{
        //else if all the input fields are filled the text and values are displayed to used in an information message
        Alert alert = new Alert(AlertType.NONE);
        alert.setAlertType(AlertType.INFORMATION);
        alert.setTitle("Application sent");
        alert.setHeaderText("Application Details"+"\n"+ "Applicant Name: " +userNametf.getText()+ "\n"+"Position Applied: " + positiontf.getText()+ "\n"+"Years of Experience: " + combobox.getValue());
        alert.show();
    }
        });

        
     //creating the GridPane object assigning it to gridpane
        GridPane gridpane = new GridPane();

        gridpane.getColumnConstraints().add(new ColumnConstraints(130));
        //sets the vertical gaps between the rows
        gridpane.setVgap(8);
        //adding and positioning by row and column the nodes in the gridpane 
        gridpane.add(imageView, 0, 3);
        gridpane.add(userNLabel, 0, 13);
        gridpane.add(positionLabel, 0, 15);
        gridpane.add(userNametf, 1, 13);

        gridpane.add(positiontf, 1, 15);
        gridpane.add(experience, 0, 17);

        gridpane.add(combobox, 1, 17);
        gridpane.add(button, 1, 20);
        //align the button horizontally to the left of position cell 1,20
        GridPane.setHalignment(button, HPos.LEFT);
        //Creates the scene object, adding the gridpane to the scene and setting the horizontal and vertical size of the scene
        Scene scene = new Scene(gridpane, 370, 420);
//setting the scene to the stage
        primaryStage.setScene(scene);
        //showing everything added to the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        //launching the application
        Application.launch(args);
    }
}
