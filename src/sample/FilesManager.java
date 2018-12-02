package sample;

import net.datastructures.AVLTreeMap;

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

    public ArrayList<String[]> TextInMatrixForm()
    {
        ArrayList<String[]> lines = new ArrayList<String[]>();
        while(fileToIndexReader.hasNextLine())
        {
            String[] line = fileToIndexReader.nextLine().split(" ");
            for (String word: line)
            {
                if (word.contains(","))
                    word = word.substring(0, word.length()-1);
                if (word.contains("."))
                    word = word.substring(0, word.length()-1);
            }
            lines.add(line);
        }
        return lines;
    }

    public ArrayList<String> WordToExclude() {
        ArrayList<String> r = new ArrayList<String>();

        while(fileWithExceptionsReader.hasNextLine()) {
            r.add(fileWithExceptionsReader.nextLine());

        }
        r.sort(String::compareTo);
        return r;

    }
}
