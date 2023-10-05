package com.chesstpa.board;

import com.chesstpa.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public final static int SIZE = 8;
    private Spot[][] board = new Spot[SIZE][SIZE];
    public Board() {
        this.initializeBoard();
    }

    public void initializeBoard(){
        // initialize black pieces
        this.board[0][0] = new Spot(0, 0, new Rook(PieceColor.Black));
        this.board[0][1] = new Spot(0, 1, new Knight(PieceColor.Black));
        this.board[0][2] = new Spot(0, 2, new Bishop(PieceColor.Black));
        this.board[0][3] = new Spot(0, 3, new Queen(PieceColor.Black));
        this.board[0][4] = new Spot(0, 4, new King(PieceColor.Black));
        this.board[0][5] = new Spot(0, 5, new Bishop(PieceColor.Black));
        this.board[0][6] = new Spot(0, 6, new Knight(PieceColor.Black));
        this.board[0][7] = new Spot(0, 7, new Rook(PieceColor.Black));

        // initialize white pieces
        this.board[7][0] = new Spot(7, 0, new Rook(PieceColor.White));
        this.board[7][1] = new Spot(7, 1, new Knight(PieceColor.White));
        this.board[7][2] = new Spot(7, 2, new Bishop(PieceColor.White));
        this.board[7][3] = new Spot(7, 3, new Queen(PieceColor.White));
        this.board[7][4] = new Spot(7, 4, new King(PieceColor.White));
        this.board[7][5] = new Spot(7, 5, new Bishop(PieceColor.White));
        this.board[7][6] = new Spot(7, 6, new Knight(PieceColor.White));
        this.board[7][7] = new Spot(7, 7, new Rook(PieceColor.White));

        // initialize black pawns
        for (int i = 0; i < Board.SIZE; i++) {
            this.board[1][i] = new Spot(1, i, new Pawn(PieceColor.Black));
        }

        // initialize white pawns
        for (int i = 0; i < Board.SIZE; i++) {
            this.board[6][i] = new Spot(6, i, new Pawn(PieceColor.White));
        }

        // initialize spots without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = new Spot(i, j, null);
            }

        }
        System.out.println(board.length);
    }

}
