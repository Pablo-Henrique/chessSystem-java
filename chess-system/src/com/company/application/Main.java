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
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(input);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(input);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

            } catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }
}
