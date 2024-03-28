package com.chesstpa.game;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.PieceColor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.chesstpa.DataConvert.transformPositionToIntList;

public class Game {
    private final Board board = new Board();

    public boolean isCheckMate(PieceColor color){
        List<Spot> possibleMovesForAllPiece = getPossibleMovesForAllPiece(color);
        return  board.kingIsCheck(color) && possibleMovesForAllPiece.isEmpty();
    }
    public boolean isPat(PieceColor color){
        Spot[][] spots = board.getSpots();
        List<Spot> possibleMovesForAllPiece = getPossibleMovesForAllPiece(color);
        long numberOfPiece = Arrays.stream(spots)
                .flatMap(Arrays::stream)
                .filter(spot -> spot.getPiece() != null )
                .count();
        return (!board.kingIsCheck(color) && possibleMovesForAllPiece.isEmpty()) || numberOfPiece == 2;
    }


    public List<Spot> getPossibleMovesForAllPiece(PieceColor color){
        Spot[][] spots = board.getSpots();
        return Stream.of(spots)
                .flatMap(Arrays::stream)
                .filter(spot -> spot.getPiece() != null && spot.getPiece().getColor() == color)
                .flatMap(spot -> spot.getPiece().getPossibleMoves(board, spot).stream())
                .toList();
    }

    public void setGameState(String boardState,String enPassantPosition,String castle) {
        board.setBoardState(boardState,castle);
        board.setCastle(castle); // Todo -----------------------------------------------
        board.setEnPassantPosition(transformPositionToIntList(enPassantPosition));
    }

    public Board getBoard() {
        return board;
    }
}
