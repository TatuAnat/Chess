package Figure;
import Board.ChessBoard;

public abstract class ChessPiece {
    public String color;
    public boolean check;

    public ChessPiece(String color) {
        this.color = color;
    }
    public  abstract String getColor();
    public  abstract boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();

}
