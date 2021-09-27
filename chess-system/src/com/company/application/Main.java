package com.company.application;

import com.company.chesslayer.ChessMatch;
import com.company.chesslayer.ChessPiece;
import com.company.chesslayer.ChessPosition;
import com.company.chesslayer.exception.ChessException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();

        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source:");
                ChessPosition source = UI.readChessPosition(input);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                UI.clearScreen();
                System.out.println();
                System.out.print("Target:");
                ChessPosition target = UI.readChessPosition(input);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }
        } catch (ChessException | InputMismatchException exception) {
            System.out.println(exception.getMessage());
        }
    }
}