package com.company.chesslayer;

import com.company.boardlayer.Board;
import com.company.chesslayer.chesspieces.King;
import com.company.chesslayer.chesspieces.Rook;

public class ChessMatch {

    private final Board board;

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

    private void placeNewPiece(int row, char column, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(row, column).toPosition());
    }

    public void initialSetup() {
        // Player WHITE
        placeNewPiece(8, 'a', new Rook(board, Color.WHITE));
        placeNewPiece(8, 'h', new Rook(board, Color.WHITE));
        placeNewPiece(8, 'e', new King(board, Color.WHITE));

        // Player BLACK
        placeNewPiece(1, 'a', new Rook(board, Color.BLACK));
        placeNewPiece(1, 'h', new Rook(board, Color.BLACK));
        placeNewPiece(1, 'e', new King(board, Color.BLACK));

    }
}
