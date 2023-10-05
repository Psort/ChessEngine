package com.chesstpa.moves;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;

import java.util.ArrayList;
import java.util.List;

public class RookMoves {


    public List<Spot> getVerticalPossibleMoves(Board board,Spot spot){
        List<Spot> possibleMoves = new ArrayList<>();
        for (int i = 0; i < spot.getX(); i++) {
            if (spot.getX()==board.getSpots().length){

            }
        }
        return possibleMoves;
    }

    public List<Spot> getHorizontalPossibleMoves(Board board,Spot spot){
        List<Spot> possibleMoves = new ArrayList<>();
        for (int i = 0; i < spot.getX(); i++) {
            if (spot.getX()<board.getSpots().length){

            }
        }
        return possibleMoves;
    }
}
