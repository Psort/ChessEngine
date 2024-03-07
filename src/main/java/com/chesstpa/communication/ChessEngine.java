package com.chesstpa.communication;

import com.chesstpa.DataConvert;
import com.chesstpa.board.Board;
import com.chesstpa.game.Game;
import com.chesstpa.board.Position;
import com.chesstpa.board.Spot;
import com.chesstpa.game.GameStatus;
import com.chesstpa.pieces.PieceColor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ChessEngine implements CommunicationInterface{

    private final Game game = new Game();
    @Override
    public String getPossibleMovesForPosition(String boardState, String piecePosition,String castle) {
        if (piecePosition.length() != 2){
            return "";
        }
        game.setGameState(boardState,castle);
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
    public Map<Position, List<Position>> getAllPossibleMovesForColor(String boardState, String piecesColor, String castle) {
        PieceColor color = Objects.equals(piecesColor, "WHITE") ?PieceColor.WHITE:PieceColor.BLACK;
        game.setGameState(boardState,castle);
        Board board = game.getBoard();
        return Arrays.stream(game.getBoard().getSpots())
                .flatMap(Arrays::stream)
                .filter(spot -> spot.getPiece() != null && spot.getPiece().getColor() == color)
                .collect(Collectors.groupingBy(
                        Spot::getPosition,
                        Collectors.flatMapping(spot -> spot.getPiece().getPossibleMoves(board, spot).stream()
                                        .map(Spot::getPosition),
                                Collectors.toList())
                ));
    }

    @Override
    public String getGameStatus(String boardState,String castle,String color) {
        game.setGameState(boardState,castle);
        PieceColor pieceColor = Objects.equals(color, "WHITE") ?PieceColor.WHITE:PieceColor.BLACK;
        if (game.isCheckMate(pieceColor)){
            return GameStatus.CHECKMATE.getValue();
        }
        if (game.isPat(pieceColor)){
            return GameStatus.PAT.getValue();
        }
        return GameStatus.GAME.getValue();
    }

}
