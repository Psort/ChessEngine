package com.chesstpa.board;

import com.chesstpa.pieces.*;

import java.util.List;

public class Board {
    private final int SIZE = 8;
    private Piece[][] board = new Piece[SIZE][SIZE];
    public Board() {
        Rook blackRook1 = new Rook(PieceColor.Black,new Coordinates(0,0));
        Knight blackKnight1 = new Knight(PieceColor.Black,new Coordinates(0,1));
        Bishop blackBishop1 = new Bishop(PieceColor.Black,new Coordinates(0,2));
        Queen blackQueen = new Queen(PieceColor.Black,new Coordinates(0,3));
        King blackKing = new King(PieceColor.Black,new Coordinates(0,4));
        Bishop blackBishop2 = new Bishop(PieceColor.Black,new Coordinates(0,5));
        Knight blackKnight2 = new Knight(PieceColor.Black,new Coordinates(0,6));
        Rook blackRook2 = new Rook(PieceColor.Black,new Coordinates(0,7));
        putPiecesOnBoard(blackRook1);
        putPiecesOnBoard(blackKnight1);
        putPiecesOnBoard(blackBishop1);
        putPiecesOnBoard(blackQueen);
        putPiecesOnBoard(blackQueen);
        putPiecesOnBoard(blackKing);
        putPiecesOnBoard(blackBishop2);
        putPiecesOnBoard(blackKnight2);
        putPiecesOnBoard(blackRook2);


        for (int i = 0; i < SIZE; i++) {
            Pawn pawn = new Pawn(PieceColor.Black,new Coordinates(1,i));
            putPiecesOnBoard(pawn);
        }
        Rook whiteRook1 = new Rook(PieceColor.White,new Coordinates(7,0));
        Knight whiteKnight1 = new Knight(PieceColor.White,new Coordinates(7,1));
        Bishop whiteBishop1 = new Bishop(PieceColor.White,new Coordinates(7,2));
        Queen whiteQueen = new Queen(PieceColor.White,new Coordinates(7,3));
        King whiteKing = new King(PieceColor.White,new Coordinates(7,4));
        Bishop whiteBishop2 = new Bishop(PieceColor.White,new Coordinates(7,5));
        Knight whiteKnight2 = new Knight(PieceColor.White,new Coordinates(7,6));
        Rook whiteRook2 = new Rook(PieceColor.White,new Coordinates(7,7));
        putPiecesOnBoard(whiteRook1);
        putPiecesOnBoard(whiteKnight1);
        putPiecesOnBoard(whiteBishop1);
        putPiecesOnBoard(whiteQueen);
        putPiecesOnBoard(whiteQueen);
        putPiecesOnBoard(whiteKing);
        putPiecesOnBoard(whiteBishop2);
        putPiecesOnBoard(whiteKnight2);
        putPiecesOnBoard(whiteRook2);

        for (int i = 0; i < SIZE; i++) {
            Pawn pawn = new Pawn(PieceColor.White,new Coordinates(6,i));
            putPiecesOnBoard(pawn);
        }

    }
    private void putPiecesOnBoard(Piece piece){
        board[piece.getCoordinates().getX()][piece.getCoordinates().getY()] = piece;
    }

    public Piece getPiece(Coordinates coordinates) {
        return board[coordinates.getX()][coordinates.getY()];
    }

    public void changePositionsPiece(Piece piece) {
            board[piece.getCoordinates().getX()][piece.getCoordinates().getX()] = piece;
    }

    public Piece[][] getboard() {
        return board;
    }

    public void deletePiece(Piece piece) {
        board[piece.getCoordinates().getX()][piece.getCoordinates().getX()] = null;
    }
}
