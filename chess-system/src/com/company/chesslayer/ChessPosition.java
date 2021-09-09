package com.company.chesslayer;

import com.company.boardlayer.Position;
import com.company.chesslayer.exception.ChessException;

public class ChessPosition {

    private final int row_Number;
    private final char column_Char;

    public ChessPosition(int row_Number, char column_Char) {
        if (column_Char < 'a' || column_Char > 'h' || row_Number < 1 || row_Number > 8) {
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8");
        }
        this.row_Number = row_Number;
        this.column_Char = column_Char;
    }

    public int getRow_Number() {
        return row_Number;
    }

    public char getColumn_Char() {
        return column_Char;
    }

    protected Position toPosition() {
        return new Position(8 - row_Number, column_Char - 'a');
    }

    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition(8 - position.getRow(), (char) ('a' - position.getColumn()));
    }

    @Override
    public String toString() {
        return "" + column_Char + row_Number;
    }
}
