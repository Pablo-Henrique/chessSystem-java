package com.company.chesslayer.chesspieces;

import com.company.boardlayer.Board;
import com.company.chesslayer.ChessPiece;
import com.company.chesslayer.Color;

public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    public Queen() {
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return new boolean[0][];
    }

    @Override
    public String toString() {
        return "Q";
    }
}
