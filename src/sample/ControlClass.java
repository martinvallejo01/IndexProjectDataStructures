package sample;

import java.util.ArrayList;
import java.util.TreeMap;

public class ControlClass {

    public ArrayList<String[]> Text;
    public ArrayList<String> ExcludedWords;
    public TreeMap<String, Word> SearchWordsTree = new TreeMap<String, Word>();

    public ControlClass(ArrayList<String[]> text, ArrayList<String> excludedWords){
        Text = text;
        ExcludedWords = excludedWords;
        createSearchTree();
    }

    private void createSearchTree(){
        int linePosition = 0;
        int columnPosition = 0;
        for (String[] line : Text) {
            for (String word : line) {
                if (SearchWordsTree.containsKey(word)){
                    Word wordToEdit = SearchWordsTree.remove(word);
                    wordToEdit.addPosition(linePosition, columnPosition);
                    SearchWordsTree.put(word, wordToEdit);
                }
                else {
                    Word wordToAdd = new Word(word);
                    wordToAdd.addPosition(linePosition, columnPosition);
                    SearchWordsTree.put(word, wordToAdd);
                }
                columnPosition += 1;
            }
            linePosition += 1;
        }
    }



}
