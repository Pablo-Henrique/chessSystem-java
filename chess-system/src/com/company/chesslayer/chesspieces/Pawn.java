package com.company.chesslayer.chesspieces;

import com.company.boardlayer.Board;
import com.company.chesslayer.ChessPiece;
import com.company.chesslayer.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    public Pawn() {
    }

    @Override
    public String toString() {
        return "P";
    }
}
