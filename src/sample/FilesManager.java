package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

    public Object WordsMatrix()
    {
        
        return 1;
    }
}
