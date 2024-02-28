public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line) && checkToPosition(column) && checkToPosition(toLine) && checkToPosition(toColumn)) {
            if (line != toLine && column == toColumn  && (board.board[toLine][toColumn] == null || // check that horse
                    !board.board[toLine][toColumn].color.equals(this.color)) &&                   // can't move out
                    board.board[line][column] != null) {

                if (color.equals("White")) {
                    int direction = 1;
                    int start = 1;
                    if (line == start && line + 2 * direction == toLine)
                        return true;
                    if (line +  direction == toLine)
                        return true;

                } else {
                    int direction = -1;
                    int start = 6;
                    if (line == start && line + 2 * direction == toLine)
                        return true;
                    if (line +  direction == toLine)
                        return true;

                }
            }


        } else return false;
        return false;
    }



    public boolean checkToPosition(int position)
    {
        if (position<=7 && position >=0 )
            return true;
        else  return false;
    }



    public boolean checkPosition (int position){
        if (position<=6 && position >=1 )
            return true;
        else  return false;

    }
    @Override
    public String getSymbol() {
        return "P";
    }
}
