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

    private Spot whiteKingSpot = new Spot(new Position(7,4), new King(PieceColor.White));
    private Spot blackKingSpot = new Spot(new Position(0,4), new King(PieceColor.Black));
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
    public boolean isCheckMate(PieceColor color){
        List<Spot> possibleMovesForAllPiece = getPossibleMovesForAllPiece(color);
        return  kingIsCheck(color) && possibleMovesForAllPiece.isEmpty();
    }
    public boolean isPat(PieceColor color){
        List<Spot> possibleMovesForAllPiece = getPossibleMovesForAllPiece(color);
        long numberOfPiece = Arrays.stream(spots)
                .flatMap(Arrays::stream)
                .filter(spot -> spot.getPiece() != null )
                .count();

        return (!kingIsCheck(color) && possibleMovesForAllPiece.isEmpty()) || numberOfPiece == 2;
    }

    public void swapSpots(Spot currentSpot, Spot nextSpot){
        this.getSpots()[nextSpot.getPosition().getX()][nextSpot.getPosition().getY()].setPiece(currentSpot.getPiece());
        this.getSpots()[currentSpot.getPosition().getX()][currentSpot.getPosition().getY()].setPiece(null);
    }
    private List<Spot> getPossibleMovesForAllPiece(PieceColor color){
        return Stream.of(spots)
                .flatMap(Arrays::stream)
                .filter(spot -> spot.getPiece() != null && spot.getPiece().getColor() == color)
                .flatMap(spot -> spot.getPiece().getPossibleMoves(this, spot).stream())
                .toList();
    }

    public void setBoardState(String boardState) {
        initializeEmptyBoard();
        String[] strings = boardState.split("/");
        for(int i = 0; i< SIZE;i++){
            int j = 0;

            for (char c : strings[i].toCharArray()){
                if (Character.isDigit(c)){
                    int emptySpace = Character.getNumericValue(c);
                    j+=emptySpace;
                }else {
                    Piece piece = DataConvert.createPieceFromSymbol(c);
                    if(piece != null){
                        spots[i][j].setPiece(piece);
                    }
                    j++;
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
                    System.out.print(" "+spot.getPosition().getX()+spot.getPiece().getClass().getSimpleName().charAt(0)+spot.getPosition().getY()+" ");
                }
                else {
                    System.out.print(" "+spot.getPosition().getX()+":"+spot.getPosition().getY()+" ");
                }
            }
            System.out.println();
        }
    }
}