package com.chesstpa.board;

import com.chesstpa.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public final static int SIZE = 8;
    private Spot[][] spots = new Spot[SIZE][SIZE];

    private Spot whiteKingSpot = new Spot(7, 4, new King(PieceColor.White));
    private Spot blackKingSpot = new Spot(0, 4, new King(PieceColor.Black));
    public Board() {
        this.initializeBoard();
    }

    public void initializeBoard(){
        // initialize black pieces
        this.spots[0][0] = new Spot(0, 0, new Rook(PieceColor.Black));
        this.spots[0][1] = new Spot(0, 1, new Knight(PieceColor.Black));
        this.spots[0][2] = new Spot(0, 2, new Bishop(PieceColor.Black));
        this.spots[0][3] = new Spot(0, 3, new Queen(PieceColor.Black));
        this.spots[0][4] = blackKingSpot;
        this.spots[0][5] = new Spot(0, 5, new Bishop(PieceColor.Black));
        this.spots[0][6] = new Spot(0, 6, new Knight(PieceColor.Black));
        this.spots[0][7] = new Spot(0, 7, new Rook(PieceColor.Black));

        //initialize white pieces
        this.spots[7][0] = new Spot(7, 0, new Rook(PieceColor.White));
        this.spots[7][1] = new Spot(7, 1, new Rook(PieceColor.White) );
        this.spots[7][2] = new Spot(7, 2, new Rook(PieceColor.White) );
        this.spots[7][3] = new Spot(7, 3,new Rook(PieceColor.White));
        this.spots[7][4] = whiteKingSpot;
        this.spots[7][5] = new Spot(7, 5, new Rook(PieceColor.White));
        this.spots[7][6] = new Spot(7, 6, new Rook(PieceColor.White));
        this.spots[7][7] = new Spot(7, 7, new Rook(PieceColor.White));

        // initialize black pawns
        for (int i = 0; i < Board.SIZE; i++) {
            this.spots[1][i] = new Spot(1, i, new Pawn(PieceColor.Black));
        }

        // initialize white pawns
        for (int i = 0; i < Board.SIZE; i++) {
            this.spots[6][i] = new Spot(6, i, new Pawn(PieceColor.White));
//            this.spots[6][i] = new Spot(6, i, null);
        }

        // initialize spots without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.spots[i][j] = new Spot(i, j, null);
            }

        }
    }

    public Spot[][] getSpots() {
        return this.spots;
    }
    public Spot getSpot(int x, int y){
        return spots[x][y];
    }

    public void printBoard(){
        for(String a :new ArrayList<String>(List.of("    a  ","  b  ","  c  ","  d  ","  e  ","  f  ","  g  ","  h  "))){
            System.out.print(a);
        }
        System.out.println();
        int i = 1;
        for (Spot[] spots1: spots){
            System.out.print(i++ +" ");
            for (Spot spot: spots1){
                if (spot.getPiece() !=null){
                    System.out.print(" "+spot.getX()+spot.getPiece().getClass().getSimpleName().charAt(0)+spot.getY()+" ");
                }
                else {
                    System.out.print(" "+spot.getX()+":"+spot.getY()+" ");
                }
            }
            System.out.println();
        }
    }

    public void setKingSpot(Spot nextSpot) {
        if(nextSpot.getPiece().getColor() == PieceColor.White){
            whiteKingSpot = nextSpot;
        }else {
            blackKingSpot = nextSpot;
        }
    }

    public Spot getKingSpot(PieceColor color) {
        if (color == PieceColor.White) {
            return whiteKingSpot;
        } else {
            return blackKingSpot;
        }
    }
}
