import com.chesstpa.Game;

public class ChessEngine {
    public static void main(String[] args) {
        if (args.length > 0) {
            String boardState = args[0];
            String piecePosition = args[1];
            Game game = new Game();
            String possibleMoves = game.getPossibleMovesForPosition(boardState,piecePosition);
            System.out.println(possibleMoves);
        } else {
            System.out.println("Usage: java ChessEngine <boardState> <piecePosition>");
        }
    }
}
