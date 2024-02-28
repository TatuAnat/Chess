public class Horse extends ChessPiece{
    public Horse(String color) {
        super(color);
    }
    public ChessPiece[][] board = new ChessPiece[8][8];
    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line)&&checkPosition(column)&&checkPosition(toLine)&&checkPosition(toColumn)){
            if (line!=toLine && column!=toColumn  && (board.board[toLine][toColumn] == null || // check that horse
                    !board.board[toLine][toColumn].color.equals(this.color)) &&                   // can't move out
                    board.board[line][column] != null){
                int[][] arr = new int[][] {
                        {line - 2, column - 1}, {line - 2, column +1},
                        {line + 2, column + 1}, {line + 2, column -1},
                        {line - 1, column -2}, {line + 1, column -2},
                        {line -1, column +2}, {line +1, column +2}
                };
                for ( int i = 0; i<arr.length; i++){
                    if (arr[i][0] == toLine && arr [i][1] == toColumn)
                        return true;

                }

            }
        }else return false;
        return false;

    }

    public boolean checkPosition (int position){
        if (position<=7 && position >=0 )
        return true;
        else  return false;

    }

    @Override
    public String getSymbol() {
        return "H";
    }

    @Override
    public String getColor() {
        return color;

    }
}
