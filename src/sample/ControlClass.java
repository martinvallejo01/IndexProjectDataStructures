package sample;

import java.util.ArrayList;
import java.util.TreeMap;

public class ControlClass {

    public ArrayList<String[]> Text;
    public ArrayList<String> ExcludedWords;
    public TreeMap<String, Word> SearchWordsTree = new TreeMap<String, Word>();
    public int NumberOfWords = 0;

    public ControlClass(ArrayList<String[]> text, ArrayList<String> excludedWords){
        Text = text;
        ExcludedWords = excludedWords;
        createSearchTree();
    }

    private void createSearchTree(){
        int linePosition = 0;
        int columnPosition = 0;
        for (String[] line : Text) {
            columnPosition = 0;
            for (String word : line) {
                if (!isExcluded(word, 0, ExcludedWords.size()-1)){
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
                }
                columnPosition += 1;
                NumberOfWords += 1;
            }
            linePosition += 1;
        }

    }

    public ArrayList<String> Index() {
        ArrayList<String> index = new ArrayList<String>(NumberOfWords);
        for (Word word : SearchWordsTree.values()) {
            index.add(word.toString());
        }
        return index;
    }

    private boolean isExcluded(String word, int i, int j) {
        if (i > j) { return false; }
        int k = (i + j)/2;
        int comp = ExcludedWords.get(k).compareTo(word);
        if (comp == 0) { return true; }
        if (comp == 1) { j = k - 1; }
        else { i = k + 1; }
        return isExcluded(word, i, j);

    }

}
