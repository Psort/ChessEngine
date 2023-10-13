import com.chesstpa.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ChessEngine {
    public static void main(String[] args) {
        if (args.length > 0) {
            String boardState = args[0];
            String piecePosition = args[1];
            Game game = new Game();
            String possibleMoves = game.getPossibleMoves(boardState,piecePosition);
            System.out.println(possibleMoves);
        } else {
            System.out.println("Usage: java ChessEngine <boardState> <piecePosition>");
        }
    }
}
