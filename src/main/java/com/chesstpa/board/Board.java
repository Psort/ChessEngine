package com.chesstpa.board;

import com.chesstpa.DataConvert;
import com.chesstpa.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public final static int SIZE = 8;
    private Spot[][] spots = new Spot[SIZE][SIZE];

    private Spot whiteKingSpot = null ;
    private Spot blackKingSpot = null;
    private Position enPassantPosition = null;
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


    public void setKingSpot(Spot nextSpot,PieceColor color) {
        if(color == PieceColor.WHITE){
            whiteKingSpot = nextSpot;
        }else {
            blackKingSpot = nextSpot;
        }
    }

    public Spot getKingSpot(PieceColor color) {
        if (color == PieceColor.WHITE) {
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

                    spots[SIZE-i-1][j++].setPiece(piece);
                    if (piece instanceof King) {
                        King king = (King) piece;
                        boolean isWhite = piece.getColor() == PieceColor.WHITE;
                        king.setShortCastle(isWhite ? castle.contains("K") : castle.contains("k"));
                        king.setLongCastle(isWhite ? castle.contains("Q") : castle.contains("q"));
                        setKingSpot(spots[SIZE-i-1][j - 1],piece.getColor());
                    }
                }
            }
        }
    }
    public  String spotsToBoardState() {
        StringBuilder boardState = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            int emptyCount = 0;
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < SIZE; j++) {
                Spot spot = spots[SIZE-i-1][j];
                if (spot.getPiece() == null) {
                    emptyCount++;
                } else {
                    if (emptyCount > 0) {
                        row.append(emptyCount);
                        emptyCount = 0;
                    }
                    Piece piece = spot.getPiece();
                    char pieceSymbol = piece.getColor() == PieceColor.WHITE ? Character.toUpperCase(piece.getSimpleName()) : Character.toLowerCase(piece.getSimpleName());
                    row.append(pieceSymbol);
                }
            }
            if (emptyCount > 0) {
                row.append(emptyCount);
            }
            boardState.append(row);
            if (i < SIZE - 1) {
                boardState.append("/");
            }
        }
        return boardState.toString();
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
                    char symbolToPrint = spot.getPiece().getColor() == PieceColor.BLACK ? Character.toLowerCase(pieceSymbol) : Character.toUpperCase(pieceSymbol);

                    System.out.print(" " + spot.getPosition().getX() + symbolToPrint + spot.getPosition().getY() + " ");

                }
                else {
                    System.out.print(" "+spot.getPosition().getX()+":"+spot.getPosition().getY()+" ");
                }
            }
            System.out.println();
        }
    }

    public void setEnPassantPosition(Position enPassantPosition) {
        this.enPassantPosition = enPassantPosition;
    }

    public Position getEnPassantPosition() {
        return enPassantPosition;
    }

    public void setCastle(String castle) {

    }
}