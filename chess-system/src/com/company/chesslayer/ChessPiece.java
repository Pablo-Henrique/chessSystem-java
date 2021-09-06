package com.company.chesslayer;

import com.company.boardlayer.Board;
import com.company.boardlayer.Piece;

public class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public ChessPiece() {
    }

    public Color getColor() {
        return color;
    }


}
