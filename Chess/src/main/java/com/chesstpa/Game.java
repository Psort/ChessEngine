package com.chesstpa;

import com.chesstpa.board.Board;
import com.chesstpa.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    public Board getBoard(){
        return this.board;
    }
    public void initialize(){
        this.board = new Board();
    }
}
