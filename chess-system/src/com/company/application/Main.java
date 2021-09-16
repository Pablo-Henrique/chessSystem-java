package com.company.application;

import com.company.chesslayer.ChessMatch;
import com.company.chesslayer.ChessPiece;
import com.company.chesslayer.ChessPosition;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();

        Scanner input = new Scanner(System.in);

        while (true) {
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Source:");
            ChessPosition source = UI.readChessPosition(input);

            System.out.println();
            System.out.print("Target:");
            ChessPosition target = UI.readChessPosition(input);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

        }
    }
}