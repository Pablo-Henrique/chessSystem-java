package com.company.chesslayer.chesspieces;

import com.company.boardlayer.Board;
import com.company.boardlayer.Position;
import com.company.chesslayer.ChessPiece;
import com.company.chesslayer.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    public Pawn() {
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0) {
                for (int i = 0; i < 2; i++) {
                    mat[p.getRow() - i][p.getColumn()] = true;
                }
            }
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        } else {
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0) {
                for (int i = 0; i < 2; i++) {
                    mat[p.getRow() + i][p.getColumn()] = true;
                }
            }
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
