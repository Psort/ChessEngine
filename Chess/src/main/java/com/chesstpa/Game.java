package com.chesstpa;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Game {

    Board board;

    public Game(){
        this.board = new Board();
    }
    public String getPossibleMovesForPosition(String boardState, String piecePosition){

        if (piecePosition.length() != 2){
            return "";
        }

        board.setBoardState(boardState);
        int[] transformPosition = transformPositionToIntList(piecePosition);
        int x = transformPosition[0];
        int y = transformPosition[1];
        Spot spot = board.getSpot(x,y);

        if (spot.getPiece() == null) {
            return "";
        }

        return spot.getPiece().getPossibleMoves(board, spot)
                .stream()
                .map(s -> transformIntListToPosition(s.getPosition().getX(), s.getPosition().getY()))
                .collect(Collectors.joining("/"));

    }

    private int[] transformPositionToIntList(String position) {
        int x = position.toUpperCase().charAt(0) - 'A'; // Przyjmując, że pozycje są w formie "A1", "B2", itp.
        int y = Integer.parseInt(position.substring(1)) - 1;
        return new int[]{x, y};
    }
    private static String transformIntListToPosition(int x,int y) {
        char column = (char) (y + 'a');
        char row = (char) (x+ '1');
        return String.valueOf(column) + String.valueOf(row);
    }
}
