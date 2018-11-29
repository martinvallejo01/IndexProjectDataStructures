package sample;

import java.util.List;

public class Word {

    public class Position
    {
        public int Line;
        public int Position;

        public Position(int line, int position)
        {
            Line = line;
            Position = position;
        }
    }

    public String Word;
    public List<Position> Positions;

    @Override
    public String toString() {
        return "";
    }
}
