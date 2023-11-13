package com.chesstpa.communication;

import com.chesstpa.DataConvert;
import com.chesstpa.game.Game;
import com.chesstpa.board.Position;
import com.chesstpa.board.Spot;
import com.chesstpa.game.GameStatus;
import com.chesstpa.pieces.PieceColor;

import java.util.Objects;
import java.util.stream.Collectors;

public class ChessEngine implements CommunicationInterface{

    private final Game game = new Game();
    @Override
    public String getPossibleMovesForPosition(String boardState, String piecePosition,String whiteCastle,String blackCastle) {
        if (piecePosition.length() != 2){
            return "";
        }
        game.setGameState(boardState,whiteCastle,blackCastle);
        Position transformPosition = DataConvert.transformPositionToIntList(piecePosition);
        int x = transformPosition.getX();
        int y = transformPosition.getY();
        Spot spot = game.getBoard().getSpot(x,y);

        if (spot.getPiece() == null) {
            return "";
        }
        return spot.getPiece().getPossibleMoves(game.getBoard(), spot)
                .stream()
                .map(s -> DataConvert.transformIntListToPosition(s.getPosition().getX(), s.getPosition().getY()))
                .collect(Collectors.joining("/"));
    }

    @Override
    public String getGameStatus(String boardState,String castle,String color) {
        game.setGameState(boardState,castle);
        PieceColor pieceColor = Objects.equals(color, "w") ?PieceColor.White:PieceColor.Black;
        if (game.isCheckMate(pieceColor)){
            return GameStatus.CHECKMATE.getValue();
        }
        if (game.isPat(pieceColor)){
            return GameStatus.PAT.getValue();
        }
        return GameStatus.GAME.getValue();
    }

}
