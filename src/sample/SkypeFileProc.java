package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will scan a file line by line
 */

public class SkypeFileProc {
// represents conversations in the file

    protected String fileToProcess = null;
    protected List<String> inputLines = null;


    /**
     * This method will take a qualified file name, create an
     * ArrayList (inputLines), and return a true if the file was
     * loaded or false if not
     * @param inputFileName The name of the file that contains the chat entries
     * @return True if the file was load else false
     */
    public SkypeFileProc(String inputFileName) {
        fileToProcess = inputFileName;
    }

    /**
     * This method reads strings of text in a file
     *
     * @return true if the file can be read
     * @return false if the file cannot be read
     */

    public boolean loadFile() {
        try {
            inputLines = Files.readAllLines(Paths.get(fileToProcess));

        } catch (IOException e) {
            System.err.println("Sorry, the file you specified: " + fileToProcess + " cannot be open or read.");
            return false;
        }
        return true;
    }

    /**
     * This will read the inputLines from the loadFile() method
     * parse each line, and create ChatEntry entries for each chat in the file.
     * It return of them as an ArrayList.
     * @return List of ChatEntry
     */
    public List<ChatEntry> parseFile() {

        List<ChatEntry> result = new ArrayList<>();
        List<String> oneMsg = new ArrayList<>();
        String thisLine;

        // This loop will read the inputLines and evaluate
        // the beginning of each line.  When we hit a "Message"
        // entry it will create a ChatEntry and add it to the ArrayList
        for (int a = 0; a < inputLines.size(); a++) {
            thisLine = inputLines.get(a);
            if (thisLine.startsWith("Time:")) {
                oneMsg.add(thisLine.substring(5));
            }
            if (thisLine.startsWith("Name:")) {
                oneMsg.add(thisLine.substring(5));
            }
            if (thisLine.startsWith("Message:")) {
                oneMsg.add(thisLine.substring(8));
                ChatEntry oneChatEntry = new ChatEntry(oneMsg.get(0), oneMsg.get(1), oneMsg.get(2));
                result.add(oneChatEntry);
                oneMsg.clear();
            }
        }
        return result;

    }

}
