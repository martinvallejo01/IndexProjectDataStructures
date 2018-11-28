package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FilesManager {

    public Scanner fileToIndexReader;
    public Scanner fileWithExceptionsReader;

    public FilesManager(String fileToIndexPath, String fileWithExceptionsPath)
    {
        try {
            fileToIndexReader = new Scanner(new BufferedReader(new FileReader(fileToIndexPath)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            fileWithExceptionsReader = new Scanner(new BufferedReader(new FileReader(fileWithExceptionsPath)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String[]> WordsMatrix()
    {
        ArrayList<String[]> lines = new ArrayList<String[]>();
        while(fileToIndexReader.hasNextLine())
        {
            String[] line = fileToIndexReader.nextLine().split(" ");
            for (String word: line)
                if (word.contains(","))
                    word = word.substring(0, word.length()-1);
            lines.add(line);
        }
        return lines;
    }
}
