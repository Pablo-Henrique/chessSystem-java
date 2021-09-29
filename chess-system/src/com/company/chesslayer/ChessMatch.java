package com.company.chesslayer;

import com.company.boardlayer.Board;
import com.company.boardlayer.Piece;
import com.company.boardlayer.Position;
import com.company.chesslayer.chesspieces.King;
import com.company.chesslayer.chesspieces.Rook;
import com.company.chesslayer.exception.ChessException;

public class ChessMatch {

    private final Board board;
    private int turn;
    private Color currentPlayer;


    public ChessMatch() {
        board = new Board(8, 8);
        currentPlayer = Color.WHITE;
        turn = 1;
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

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public int getTurn() {
        return turn;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
        return (ChessPiece) capturedPiece;
    }

    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private Piece makeMove(Position source, Position target) {
        ChessPiece piece = (ChessPiece) board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(piece, target);
        return capturedPiece;
    }

    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("There is no Piece on source position!");
        }
        if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
            throw new ChessException("The chosen piece not yours");
        }
        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("There is no possible moves for the chosen piece!");
        }
    }

    public void validateTargetPosition(Position source, Position target) {
        if (!board.piece(source).possibleMove(target)) {
            throw new ChessException("The chosen piece can't move to target position");
        }
    }

    public void initialSetup() {
        // Player WHITE
        placeNewPiece('d', 1, new Rook(board, Color.WHITE));
//        placeNewPiece('b', 1, new Knight(board, Color.WHITE));
//        placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
//        placeNewPiece('d', 1, new Queen(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
//        placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
//        placeNewPiece('g', 1, new Knight(board, Color.WHITE));
//        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
//        placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
//        placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
//        placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
//        placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
//        placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
//        placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
//        placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
//        placeNewPiece('h', 2, new Pawn(board, Color.WHITE));

        // Player BLACK
        placeNewPiece('d', 8, new Rook(board, Color.BLACK));
//        placeNewPiece('b', 8, new Knight(board, Color.BLACK));
//        placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
//        placeNewPiece('d', 8, new Queen(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
//        placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
//        placeNewPiece('g', 8, new Knight(board, Color.BLACK));
//        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
//        placeNewPiece('a', 7, new Pawn(board, Color.BLACK));
//        placeNewPiece('b', 7, new Pawn(board, Color.BLACK));
//        placeNewPiece('c', 7, new Pawn(board, Color.BLACK));
//        placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
//        placeNewPiece('e', 7, new Pawn(board, Color.BLACK));
//        placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
//        placeNewPiece('g', 7, new Pawn(board, Color.BLACK));
//        placeNewPiece('h', 7, new Pawn(board, Color.BLACK));
    }
}
