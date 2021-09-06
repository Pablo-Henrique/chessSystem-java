package com.company.chesslayer.chesspieces;

import com.company.boardlayer.Board;
import com.company.chesslayer.ChessPiece;
import com.company.chesslayer.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    public Rook() {
    }

    @Override
    public String toString() {
        return "R";
    }
}
