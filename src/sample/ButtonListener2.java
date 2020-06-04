package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class ButtonListener2 implements EventHandler<ActionEvent> {
    //instance variables for graphic elements
    private TextFlow textflow;
    private Label filelabel;

    //Create Constructors for textflow and label elements
    public ButtonListener2(){
    }

    public ButtonListener2(TextFlow textFlow, Label filelabel){
        this.textflow = textFlow;
        this.filelabel = filelabel;
    }


 /** Listener Method.
  *  The class create a filechooser variable that open a dialog on the user PC for the msg file selection
  */

    public void handle(ActionEvent event) {


        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Please select a msg file");
        filechooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Msg Files", "*.msg"));

        File selectedfile = filechooser.showOpenDialog(null);

/*      An if statement is used to verify that file selected.
        In case the windows is closed without selecting a file it generate an alert.*/

        if (selectedfile == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Error Dialog");
            alert.setContentText("Ooops, you didn't selected a file!");
            alert.showAndWait();
        return;
        }
        //The selected file path is saved in inputFileName and passed to the label graphic element
        String inputFileName = selectedfile.getAbsolutePath();

        if (selectedfile.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("File is empty!");
            alert.setContentText("Please select a file with content");
            alert.showAndWait();
        } else {

            filelabel.setText(inputFileName);
        }

        //filelabel.setText(inputFileName);


        // Send the content of the chat to the parsing class
        SkypeFileProc sfp = new SkypeFileProc(inputFileName);
        sfp.loadFile();

        List<ChatEntry> chatEntries = sfp.parseFile();

       String chattext = "";

        for (int a = 0; a < chatEntries.size(); a++) {

            String name = chatEntries.get(a).getFromPerson();
            String time = chatEntries.get(a).getChatTime();
            String message = chatEntries.get(a).getMsgText();


            buildTextFlow(name, time, message);
        }

        textflow.getChildren().add(new Text(chattext));
    }


/**  Elements from the msg file are sent to the textflow graphic component
  *   The time field is surrounded by square brackets
  *  The Username is colored in blue
   */

    private void buildTextFlow(String name, String time, String message) {
        Text timeText = new Text("[" + time + "] ");
        Text personText = new Text(name + ": ");


        personText.setFill(Color.DARKSLATEBLUE);


        textflow.getChildren().add(timeText);
        textflow.getChildren().add(personText);

        getMessageTokens(message);
        Text lineSeparator = new Text(System.getProperty("line.separator"));
        textflow.getChildren().add(lineSeparator);
    }

    private void getMessageTokens(String message) {
        String [] tokens = message.split(" ");

        for (String token : tokens) {
            if (token.equals(":)")) {
                // Image image = ...
                Image happy = new Image(getClass().getResource("resources/smile_happy.gif").toExternalForm());
                textflow.getChildren().add(new ImageView(happy));

            }
        else if (token.equals(":(")) {
                // Image image = ...
                Image sad = new Image(getClass().getResource("resources/smile_sad.gif").toExternalForm());
                textflow.getChildren().add(new ImageView(sad));
            }
        else {
                Text text = new Text(token+ " ");
                textflow.getChildren().add(text);
            }
        }
    }


}