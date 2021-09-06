package com.company.chesslayer;

import com.company.boardlayer.Board;
import com.company.boardlayer.Position;
import com.company.chesslayer.chesspieces.King;
import com.company.chesslayer.chesspieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getColumns(); c++) {
                mat[r][c] = (ChessPiece) board.piece(r, c);
            }
        }
        return mat;
    }

    public void initialSetup() {
        // Player WHITE
        board.placePiece(new Rook(board, Color.WHITE), new Position(0, 0));
        board.placePiece(new Rook(board, Color.WHITE), new Position(0, 7));
        board.placePiece(new King(board, Color.WHITE), new Position(0, 4));

        // Player BLACK
        board.placePiece(new Rook(board, Color.BLACK), new Position(7, 0));
        board.placePiece(new Rook(board, Color.BLACK), new Position(7, 7));
        board.placePiece(new King(board, Color.BLACK), new Position(7, 4));

    }
}
