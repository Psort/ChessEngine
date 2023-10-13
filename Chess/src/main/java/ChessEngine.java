import com.chesstpa.Game;

import java.util.Scanner;

public class ChessEngine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        System.out.println("Chess Engine (Type 'help' for instructions)");

        try {
            while (true) {
                String command = scanner.nextLine();
                try {
                    String[] commandParts = command.split("\\s+");
                    switch (commandParts[0]) {
                        case "help":
                            System.out.println("postion <board> <position> ex.(position  rnbqkbnr/pppp1ppp/8/4p3/4P3/8/PPPP1PPP/RNBQKBNR g8)");
                            break;
                        case "position":
                            String boardState = commandParts[1];
                            String piecePosition = commandParts[2];
                            String result =  game.getPossibleMovesForPosition(boardState, piecePosition);
                            System.out.println(result);
                            break;
                        case "exit":
                            return;
                        default:
                            System.out.println("Unknown command: '"+command+"'.Type 'help' for instructions");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Unknown command: '"+command+"'.Type 'help' for instructions");
                }
            }
        } finally {
            scanner.close();
        }
    }
}
