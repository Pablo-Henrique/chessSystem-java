package com.company.boardlayer;

public class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    public Piece() {
    }

    protected Board getBoard() {
        return board;
    }

    public Piece[][] possibleMoves() {
        return null;
    }

    public boolean possibleMove(Position position) {
        return false;
    }

    public boolean isThereAnyPossibleMove() {
        return false;
    }
}
