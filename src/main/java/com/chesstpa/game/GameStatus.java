package com.chesstpa.game;

public enum GameStatus {
    CHECKMATE("Checkmate"),
    PAT("Pat"),
    GAME("Game");

    private final String value;

    GameStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}