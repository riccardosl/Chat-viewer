package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/** Main class initialize graphic components such as textFlow, button and label.
* It add all the elements in a Vbox
* starts the scene which represents the main window of the application.
* @author Riccardo
 */

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));



        primaryStage.setTitle("Chat Viewer");
        Button button = new Button("Choose a file...");

        HBox buttonbox = new HBox(10);
        buttonbox.setAlignment(Pos.CENTER);
        buttonbox.getChildren().addAll(button);

        Label FilePath = new Label("No file selected... Please select a file with the button above");


        //Creating the text flow plane
        TextFlow textFlowPane = new TextFlow();

        //Setting the width
        textFlowPane.setPrefSize(300, 500);

        //Setting the line spacing
        textFlowPane.setLineSpacing(5.0);

        //Retrieving the observable list of the TextFlow Pane
        ObservableList list = textFlowPane.getChildren();

        //Adding cylinder to the pane
        ScrollPane scroll = new ScrollPane();scroll.setContent(textFlowPane);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scroll.setFitToWidth(true);
        scroll.setFitToHeight(true);
        //scroll.setPrefHeight(150);


        button.setOnAction(new ButtonListener2(textFlowPane, FilePath));


        VBox txtAreaVbox = new VBox(5);
        txtAreaVbox.setPadding(new Insets(5, 5, 5, 5));
        txtAreaVbox.getChildren().addAll(textFlowPane);
        VBox mainvbox = new VBox(5);
        mainvbox.setPadding(new Insets(5, 5, 5,5));
        mainvbox.getChildren().addAll(scroll, txtAreaVbox, buttonbox, FilePath);


        Scene scene = new Scene(mainvbox, 600,500);
        primaryStage.setScene(scene);


        //primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
