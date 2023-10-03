package com.chesstpa.pieces;

public abstract class Piece {
    private String color;
    private Coordinates coordinates;
    public abstract void move();
    public Piece(String color, Coordinates coordinates){
        this.color = color;
        this.coordinates = coordinates;
    }
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
}
