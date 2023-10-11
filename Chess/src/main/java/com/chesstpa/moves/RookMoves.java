package com.chesstpa.moves;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.Piece;
import com.chesstpa.pieces.PieceColor;

import java.util.ArrayList;
import java.util.List;

public class RookMoves {
    private static RookMoves instance;

    private RookMoves(){}

    public static RookMoves getInstance(){
        if (instance == null) {
            instance = new RookMoves();
        }
        return instance;
    }
    public List<Spot> getVerticalPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = new ArrayList<>();
        int x = spot.getX();
        PieceColor pieceColor = spot.getPiece().getColor();

        // Check downward moves
        for (int i = x + 1; i < board.getSpots().length; i++) {
            if (checkAndUpdateMove(board, possibleMoves,pieceColor, i, spot.getY())) {
                break;
            }
        }

        // Check upward moves
        for (int i = x - 1; i >= 0; i--) {
            if (checkAndUpdateMove(board, possibleMoves,pieceColor, i, spot.getY())) {
                break;
            }
        }

        return possibleMoves;
    }

    public List<Spot> getHorizontalPossibleMoves(Board board, Spot spot) {
        List<Spot> possibleMoves = new ArrayList<>();
        int y = spot.getY();
        PieceColor pieceColor = spot.getPiece().getColor();

        // Check right moves
        for (int i = y + 1; i < board.getSpots()[spot.getX()].length; i++) {
            if (checkAndUpdateMove(board, possibleMoves,pieceColor, spot.getX(), i)) {
                break;
            }
        }

        // Check left moves
        for (int i = y - 1; i >= 0; i--) {
            if (checkAndUpdateMove(board, possibleMoves,pieceColor, spot.getX(), i)) {
                break;
            }
        }

        return possibleMoves;
    }

    private boolean checkAndUpdateMove(Board board, List<Spot> possibleMoves,PieceColor pieceColor, int x, int y) {
        Spot currentSpot = board.getSpots()[x][y];
        Piece pieceChecked = currentSpot.getPiece();

        if (currentSpot.isEmpty()) {
            possibleMoves.add(currentSpot);
            return false;  // Move is possible, continue checking further
        } else if(pieceChecked.getColor() != pieceColor){
            possibleMoves.add(currentSpot);
            return true;
        }
        else {
            return true;  // Stop checking, there's a piece in the way
        }
    }
}
