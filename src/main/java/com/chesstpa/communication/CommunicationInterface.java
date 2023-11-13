package com.chesstpa.communication;

import com.chesstpa.game.GameStatus;

public interface CommunicationInterface {

    public String getPossibleMovesForPosition(String boardState, String piecePosition,String castle);
    public String getGameStatus(String boardState, String castle,String color);
}
