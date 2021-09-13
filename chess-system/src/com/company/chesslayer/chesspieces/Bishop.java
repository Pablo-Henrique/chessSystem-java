package com.company.chesslayer.chesspieces;

import com.company.boardlayer.Board;
import com.company.chesslayer.ChessPiece;
import com.company.chesslayer.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    public Bishop() {
    }

    @Override
    public String toString() {
        return "B";
    }
}
