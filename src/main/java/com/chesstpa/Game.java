package com.chesstpa;

import com.chesstpa.board.Board;
import com.chesstpa.board.Position;
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
        Position transformPosition = DataConvert.transformPositionToIntList(piecePosition);
        int x = transformPosition.getX();
        int y = transformPosition.getY();
        Spot spot = board.getSpot(x,y);

        if (spot.getPiece() == null) {
            return "";
        }
        return spot.getPiece().getPossibleMoves(board, spot)
                .stream()
                .map(s -> DataConvert.transformIntListToPosition(s.getPosition().getX(), s.getPosition().getY()))
                .collect(Collectors.joining("/"));

    }
    public void printBoard(){
        board.printBoard();
    }

}
