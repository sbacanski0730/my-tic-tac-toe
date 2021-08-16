package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final char[][] board;
    private final List<List<Integer>> winningAttempts = new ArrayList<>();

    public Board() {
        this.board = new char[][]{{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        winningAttempts.add(new ArrayList<Integer>(List.of(1,2,3)));
        winningAttempts.add(new ArrayList<Integer>(List.of(4,5,6)));
        winningAttempts.add(new ArrayList<Integer>(List.of(7,8,9)));
        winningAttempts.add(new ArrayList<Integer>(List.of(1,4,7)));
        winningAttempts.add(new ArrayList<Integer>(List.of(2,5,8)));
        winningAttempts.add(new ArrayList<Integer>(List.of(3,6,9)));
        winningAttempts.add(new ArrayList<Integer>(List.of(1,5,9)));
        winningAttempts.add(new ArrayList<Integer>(List.of(3,5,7)));
    }

    public char[][] getBoard() {
        return board;
    }

    public List<List<Integer>> getWinningAttempts() {
        return winningAttempts;
    }

    public char giveCharacter(int x, int y) {
        return board[x][y];
    }

    public void placeTheSymbol(char symbol, int x, int y) {
        board[x][y] = symbol;
    }

}
