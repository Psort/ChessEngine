package com.chesstpa;

import com.chesstpa.board.Board;
import com.chesstpa.board.Spot;
import com.chesstpa.pieces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;

    private PieceColor player = PieceColor.White;
    public Board getBoard(){
        return this.board;
    }
    public void initialize(){
        this.board = new Board();
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);

        initialize();

        while (!board.isCheckMate(player) || !board.isPat(player)){
            board.printBoard();
            System.out.println("którym Pionkiem chcesz sie ruszyć");
            String position = scanner.nextLine();
            int[] intPosition = transformPosition(position);
            int x = intPosition[0];
            int y = intPosition[1];
            Spot currentSpot = board.getSpot(x,y);
            List<Spot> possibleMoces =currentSpot.getPiece().getPossibleMoves(board,currentSpot);
            for (Spot spot :possibleMoces){
                System.out.print(spot.getX());
                System.out.println(spot.getY());
            }
            position = scanner.nextLine();
            intPosition = transformPosition(position);
            if (positionIsOnList(possibleMoces,intPosition)){
                x = intPosition[0];
                y = intPosition[1];
                currentSpot.getPiece().move(board,currentSpot,board.getSpot(x,y));
            }
            player = (player == PieceColor.White) ? PieceColor.Black : PieceColor.White;
        }
        System.out.println("win"+player);
    }
    private static boolean positionIsOnList(List<Spot> possiblemooves, int[] intMove) {
        for (Spot spot: possiblemooves){
            if(spot.getX() == intMove[0] && spot.getY() == intMove[1]){
                return true;
            }
        }
        return false;
    }

    private static int[] transformPosition(String pozycja) {
        HashMap<Character, Integer> kolumny = new HashMap<>();
        kolumny.put('a', 0);
        kolumny.put('b', 1);
        kolumny.put('c', 2);
        kolumny.put('d', 3);
        kolumny.put('e', 4);
        kolumny.put('f', 5);
        kolumny.put('g', 6);
        kolumny.put('h', 7);

        int[] wynik = new int[2];
        wynik[0] = pozycja.charAt(1)-49;
        wynik[1] = kolumny.get(pozycja.charAt(0));

        return wynik;
    }
}
