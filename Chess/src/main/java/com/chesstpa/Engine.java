package com.chesstpa;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;

import java.util.HashMap;
import java.util.List;

public class Engine {

    Board board;

    public void start(){
        this.board = new Board();
    }
    public List<Spot> getPossibleMoves(String boardState, String piecePosition){
        board.setBoardState(boardState);
        int[] transformPosition = transformPosition(piecePosition);
        int x = transformPosition[0];
        int y = transformPosition[1];
        Spot spot = board.getSpot(x,y);
        return spot.getPiece().getPossibleMoves(board,spot);
    }

    private static int[] transformPosition(String position) {
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
}
