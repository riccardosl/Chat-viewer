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

/**Main class initialize graphic components such as textFlow, button, label
* It add all the elements in a Vbox
* starts the scene
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

        Label FilePath = new Label("No file selected...Please select a file with the button above");

        //button.setOnAction(new ButtonListener2(txtArea) );


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
        scroll.setFitToWidth(true); scroll.setFitToHeight(true);
        //scroll.setPrefHeight(150);

        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

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

/*    public class ButtonListener implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {



            FileChooser filechooser = new FileChooser();
            filechooser.setTitle("Please select a msg file");
            File selectedfile = filechooser.showOpenDialog(null);
            String inputFileName = selectedfile.getAbsolutePath();

            SkypeFileProc sfp = new SkypeFileProc(inputFileName);
            sfp.loadFile();

            // Pre java 6 looping logic
            List<SkypeFileProc.ChatEntry> chatEntries = sfp.parseFile();
            String chattext = "";


            for (int a = 0; a < chatEntries.size(); a++) {
                System.out.println(chatEntries.get(a));
                chattext = chattext + String.valueOf(chatEntries.get(a)) + "\n";

            }*/
            //txtArea.setText(chattext);
            //textFlowPane.getChildren().add(new Text(chattext));
            //Text text2 = new Text(chattext);
            //Setting font to the text
            //text2.setFont(new Font(15));
            //Setting color to the text
            //text2.setFill(Color.DARKSLATEBLUE);




        //}
    //}
    public static void main(String[] args) {
        launch(args);
    }
}
