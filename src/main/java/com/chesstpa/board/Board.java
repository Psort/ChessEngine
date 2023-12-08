package com.chesstpa.board;

import com.chesstpa.DataConvert;
import com.chesstpa.pieces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Board {
    public final static int SIZE = 8;
    private Spot[][] spots = new Spot[SIZE][SIZE];

    private Spot whiteKingSpot = null ;
    private Spot blackKingSpot = null;
    public Board() {
        initializeEmptyBoard();
    }
    private void initializeEmptyBoard(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Position position = new Position(i,j);
                spots[i][j] = new Spot(position, null);
            }
        }
    }

    public Spot[][] getSpots() {
        return this.spots;
    }
    public Spot getSpot(int x, int y){
        return spots[x][y];
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
    public boolean kingIsCheck(PieceColor color){
        return getKingSpot(color).isBeaten(this, color);
    }
    public void setBoardState(String boardState,String castle) {
        initializeEmptyBoard();
        String[] strings = boardState.split("/");
        for (int i = 0; i < SIZE; i++) {
            int j = 0;
            for (char c : strings[i].toCharArray()) {
                if (Character.isDigit(c)) {
                    j += Character.getNumericValue(c);
                } else {
                    Piece piece = DataConvert.createPieceFromSymbol(c);
                    spots[i][j++].setPiece(piece);
                    if (piece instanceof King) {
                        King king = (King) piece;
                        boolean isWhite = piece.getColor() == PieceColor.White;
                        king.setShortCastle(isWhite ? castle.contains("K") : castle.contains("k"));
                        king.setLongCastle(isWhite ? castle.contains("Q") : castle.contains("q"));
                        setKingSpot(spots[i][j - 1]);
                    }
                }
            }
        }
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
                    char pieceSymbol = spot.getPiece().getClass().getSimpleName().charAt(0);
                    char symbolToPrint = spot.getPiece().getColor() == PieceColor.Black ? Character.toLowerCase(pieceSymbol) : Character.toUpperCase(pieceSymbol);

                    System.out.print(" " + spot.getPosition().getX() + symbolToPrint + spot.getPosition().getY() + " ");

                }
                else {
                    System.out.print(" "+spot.getPosition().getX()+":"+spot.getPosition().getY()+" ");
                }
            }
            System.out.println();
        }
    }
}