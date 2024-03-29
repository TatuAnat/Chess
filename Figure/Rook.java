package Figure;
import Board.ChessBoard;

public class Rook extends ChessPiece{
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn)) {
            if (line == toLine && column != toColumn   && (board.board[toLine][toColumn] == null || // check that horse
                    !board.board[toLine][toColumn].color.equals(this.color)) &&                   // can't move out
                    board.board[line][column] != null) {
                for (int col = column + 1; col < toColumn; col++)
                {
                    if(board.board[line][col] != null)
                    {
                        return false;
                    }
                }
                return true;
            }
            else  if (line != toLine && column == toColumn   && (board.board[toLine][toColumn] == null || // check that horse
                    !board.board[toLine][toColumn].color.equals(this.color)) &&                   // can't move out
                    board.board[line][column] != null)
            {
                for (int row = line + 1; row < toLine; row++)
                {
                    if(board.board[row][column] != null)
                    {
                        return false;
                    }
                }
                return true;
            }
            else return false;
        }
        return false;
    }
    public boolean checkPosition (int position) {
        if (position <= 7 && position >= 0)
            return true;
        else return false;
    }
    @Override
    public String getSymbol() {
        return "R";
    }
}
