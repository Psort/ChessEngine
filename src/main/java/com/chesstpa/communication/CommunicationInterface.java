package com.chesstpa.communication;

import com.chesstpa.board.Position;
import com.chesstpa.game.GameStatus;

import java.util.List;
import java.util.Map;

public interface CommunicationInterface {

     String getPossibleMovesForPosition(String boardState, String piecePosition,String enPassantPosition,String castle);
     Map<Position, List<Position>> getAllPossibleMovesForColor(String boardState, String piecesColor,String enPassantPosition, String castle);
     String getGameStatus(String boardState, String castle,String enPassantPosition,String color);
}
