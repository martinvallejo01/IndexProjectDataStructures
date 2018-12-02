package sample;

import java.util.List;

public class Word {

    public class Position
    {
        public int Line;
        public int Column;

        public Position(int line, int column)
        {
            Line = line;
            Column = column;
        }
    }

    public String Word;
    public List<Position> Positions;

    public Word(String word) {
        Word = word;
    }

    @Override
    public String toString() {
        return "";
    }

    public void addPosition(int line, int column) {
        Positions.add(new Position(line, column));
    }
}
