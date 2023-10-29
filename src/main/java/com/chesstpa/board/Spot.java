package com.chesstpa.board;

import com.chesstpa.pieces.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Spot {
    private Piece piece;
    private final Position position;
    public Spot(Position position, Piece piece) {
        this.setPiece(piece);
        this.position = position;
    }
    public Piece getPiece() {
        return this.piece;
    }
    public void setPiece(Piece p) {
        this.piece = p;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isBeaten(Board board, PieceColor color) {
        int x = position.getX();
        int y = position.getY();
        Piece heldPiece = this.piece;
        setPiece(null);
        List<Spot> allPossibleMoves =  Stream.of(board.getSpots())
                .flatMap(Arrays::stream)
                .filter(spot -> spot.getPiece() != null && spot.getPiece().getColor() != color)
                .flatMap(spot -> spot.getPiece().getBeatenSpot(board, spot).stream())
                .toList();
        setPiece(heldPiece);
        return allPossibleMoves.stream().anyMatch(spot -> spot.getPosition().getX()==x &&  spot.getPosition().getY()==y);
    }

    public boolean isEmpty() {
        return piece ==null;
    }

    public boolean safeKing(Board board, PieceColor color,Piece piece) {
        Spot kingSpot = board.getKingSpot(color);
        this.piece = piece;
        boolean itSafe = !kingSpot.isBeaten(board,color);
        this.piece = null;
        return !itSafe;
    }
    public boolean revealsKing(Board board, PieceColor color, Piece piece, Spot previousSpot){
        Spot kingSpot = board.getKingSpot(color);
        Piece enemyPiece = this.getPiece();
        this.setPiece(piece);
        previousSpot.setPiece(null);
        boolean revealsKing = kingSpot.isBeaten(board, color);
        this.setPiece(enemyPiece);
        return revealsKing;
    }
}
