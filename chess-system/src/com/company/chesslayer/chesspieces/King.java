package com.company.chesslayer.chesspieces;

import com.company.boardlayer.Board;
import com.company.chesslayer.ChessPiece;
import com.company.chesslayer.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    public King() {
    }

    @Override
    public String toString() {
        return "K";
    }
}
