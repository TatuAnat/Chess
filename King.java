public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn)) {
            if (line == toLine && column == toColumn) {
                return false;
            }
            else if ((board.board[toLine][toColumn] == null || // check that horse
                    !board.board[toLine][toColumn].color.equals(this.color)) &&                   // can't move out
                    board.board[line][column] != null) {
                int lineStep = Math.abs(line - toLine);
                int colStep = Math.abs(column - toColumn);
                if (lineStep > 1 || colStep > 1) {
                    return false;
                } else return true;
            }
        }

        return false;

    }

    boolean isUnderAttack(ChessBoard board, int line, int column)
    {
        int queenLine = 0;
        int queenCol = 0;
        int kingLine= 0,  kingCol= 0;
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                if(board.board[i][j].getSymbol().equals("Q"))
                {
                    queenLine = i;
                    queenCol = j;
                }
                if(board.board[i][j].getSymbol().equals("K"))
                {
                    kingLine = i;
                    kingCol = j;
                }
            }
        }

        if(isKingHit(line, column, queenLine, queenCol) || isKingHit(kingLine, kingCol, queenLine, queenCol))
        {
            return true;
        }
        else {
            return false;
        }
    }

    boolean isKingHit(int kingLine, int kingCol, int queenLine, int queenCol)
    {
        if(kingLine == queenLine && kingCol == queenCol)
        {
            return true;
        }
        if(kingLine == queenLine || kingCol == queenCol)
        {
            return true;
        }
        else if (Math.abs(kingLine - queenLine) == Math.abs(kingCol - queenCol))
        {
            return true;
        }
        else return false;
    }

    public boolean checkPosition (int position) {
        if (position <= 7 && position >= 0)
            return true;
        else return false;
    }
    @Override
    public String getSymbol() {
        return "K";
    }
}
