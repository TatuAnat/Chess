package Figure;
import Board.ChessBoard;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }
    public boolean checkPosition (int position){
        if (position<=7 && position >=0 )
            return true;
        else  return false;

    }
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn)) {
            if (line != toLine && column != toColumn  && (board.board[toLine][toColumn] == null || // check that horse
                    !board.board[toLine][toColumn].color.equals(this.color)) &&                   // can't move out
                    board.board[line][column] != null) {
                if (Math.abs(line - toLine) == Math.abs(column - toColumn))
                {
                    int stepLine = 1;
                    if (line > toLine)
                    {
                        stepLine = -1;
                    }
                    int stepCol = 1;
                    if (column > toColumn)
                    {
                        stepCol = -1;
                    }
                    int col = column + stepCol;
                    for (int row = line + stepLine; row <= toLine - stepLine; row += stepLine)
                    {
                        if(board.board[row][col] != null)
                        {
                            return  false;
                        }
                        col += stepCol;
                    }
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }


    @Override
    public String getSymbol() {
        return "B";
    }
}
