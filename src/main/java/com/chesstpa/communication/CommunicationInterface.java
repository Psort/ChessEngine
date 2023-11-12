package com.chesstpa.communication;

import com.chesstpa.game.GameStatus;

public interface CommunicationInterface {

    public String getPossibleMovesForPosition(String boardState, String piecePosition,String whiteCastle,String blackCastle);
    public String getGameStatus(String boardState, String whiteCastle, String blackCastle,String color);
}
