package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The class which provides the statistical information about a file.
 *
 */
public class FileAnalyzer {

    /**
     * This field contains the textual content of the entire file.
     */
    private String text;

    /**
     * The constructor which takes a string with path to the file, opens it and read the content to text field.
     * @param file The path to the file in the filesystem.
     * @throws FileNotFoundException
     */
    public FileAnalyzer(String file) throws FileNotFoundException {
        text = "";
        Scanner sc = new Scanner(new File(file));
        while(sc.hasNext()){
            text += sc.nextLine() + "\n";
        }
    }

    /**
     * Calculates the frequency of the character given as the first argument.
     * @param character A character.
     * @return The number of all occurencies of that character.
     */
    public int getFrequencyOf(char character) {
        int count = 0;
        for(var c : text.toCharArray()){
            if(c == character){
                count++;
            }
        }
        return count;
    }

    /**
     * Calculates the number of lines in the file.
     * @return Number of lines.
     */
    public int getNumberOfLines() {
        return getFrequencyOf('\n');
    }

    public boolean isCharacterPresent(char character){
        if(getFrequencyOf(character) > 0){
            return true;
        }
        return false;
    }
}