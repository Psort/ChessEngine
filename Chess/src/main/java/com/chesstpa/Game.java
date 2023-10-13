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
    public String getPossibleMoves(String boardState, String piecePosition){
        board.setBoardState(boardState);
        int[] transformPosition = transformPositionToIntList(piecePosition);
        int x = transformPosition[0];
        int y = transformPosition[1];
        Spot spot = board.getSpot(x,y);
        return spot.getPiece().getPossibleMoves(board, spot)
                .stream()
                .map(s -> transformIntListToPosition(s.getX(), s.getY()))
                .collect(Collectors.joining("/"));

    }

    private static int[] transformPositionToIntList(String position) {
        HashMap<Character, Integer> column = new HashMap<>();
        column.put('a', 0);
        column.put('b', 1);
        column.put('c', 2);
        column.put('d', 3);
        column.put('e', 4);
        column.put('f', 5);
        column.put('g', 6);
        column.put('h', 7);

        int[] result = new int[2];
        result[0] = position.charAt(1)-49;
        result[1] = column.get(position.charAt(0));

        return result;
    }
    private static String transformIntListToPosition(int x,int y) {
        char column = (char) (y + 'a');
        char row = (char) (x+ '1');
        return String.valueOf(column) + String.valueOf(row);
    }
}
