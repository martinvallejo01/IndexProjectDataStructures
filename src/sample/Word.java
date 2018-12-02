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

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("(");
            builder.append(Line);
            builder.append(", ");
            builder.append(Column);
            builder.append(")");
            return builder.toString();
        }
    }

    public String Word;
    public List<Position> Positions;

    public Word(String word) {
        Word = word;
    }

    public boolean isInLine(int line) {
        for (Position p : Positions) {
            if (p.Line == line) { return true; }
        }
        return false;
    }

    public Integer[] lines() {
        Integer[] r = new Integer[Positions.size()];
        int i = 0;
        for (Position p : Positions) {
            r[i] = p.Line;
            i += 0;
        }
        return r;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Word: ");
        builder.append(Word);
        builder.append("Positions:");
        builder.append(" [ ");
        for (Position p : Positions) {
            builder.append(p.toString());
            builder.append(" ");
        }
        builder.append("]");
        return builder.toString();
    }

    public void addPosition(int line, int column) {
        Positions.add(new Position(line, column));
    }
}
