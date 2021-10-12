package com.company.chesslayer;

import com.company.boardlayer.Board;
import com.company.boardlayer.Piece;
import com.company.boardlayer.Position;

public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;
    private int increaseMoveCount;
    private int decreaseMoveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public ChessPiece() {
    }

    public Color getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    protected void increaseMoveCount() {
        moveCount++;
    }

    protected void decreaseMoveCount() {
        moveCount--;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece != null && piece.getColor() != color;
    }
}
