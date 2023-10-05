import com.chesstpa.Game;
import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        game.initialize();

        for (Spot[] spots: game.getBoard().getSpots()){
            for (Spot spot: spots){
                if (spot.getPiece() !=null){
                    System.out.print(" "+spot.getX()+spot.getPiece().getClass().getSimpleName().charAt(0)+spot.getY()+" ");
                }
                else {
                    System.out.print(" "+spot.getX()+":"+spot.getY()+" ");
                }
            }
            System.out.println();
        }
        for (Spot spot:game.getBoard().getSpots()[7][4].getPiece().getPossibleMoves(game.getBoard(),game.getBoard().getSpots()[7][4])){
            System.out.print(spot.getX());
            System.out.println(spot.getY());
        }
    }
}
