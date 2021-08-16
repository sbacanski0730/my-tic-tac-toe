package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board gameBoard = new Board();
    private final Computer computer = new Computer();
    private List<Integer> playerFields = new ArrayList<Integer>();
    private List<Integer> computerFields = new ArrayList<Integer>();
    private String winner;

    public void printBoard() {
        for (char[] row : gameBoard.getBoard()) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void setTheWinner(String winner) {
        this.winner = winner;
    }

    public String getTheWinner() {
        return this.winner;
    }

    public void placeSymbol(int place, String player) throws IllegalArgumentException {
        char symbol = ' ';
        if (player.equals("player")) {
            symbol = 'X';
        }
        if (player.equals("computer")) {
            symbol = 'O';
        }
        switch (place) {
            case 1 -> {
                checkIsThisPlaceFree(0, 0);
                gameBoard.placeTheSymbol(symbol, 0, 0);
            }
            case 2 -> {
                checkIsThisPlaceFree(0, 2);
                gameBoard.placeTheSymbol(symbol, 0, 2);
            }
            case 3 -> {
                checkIsThisPlaceFree(0, 4);
                gameBoard.placeTheSymbol(symbol, 0, 4);
            }
            case 4 -> {
                checkIsThisPlaceFree(2, 0);
                gameBoard.placeTheSymbol(symbol, 2, 0);
            }
            case 5 -> {
                checkIsThisPlaceFree(2, 2);
                gameBoard.placeTheSymbol(symbol, 2, 2);
            }
            case 6 -> {
                checkIsThisPlaceFree(2, 4);
                gameBoard.placeTheSymbol(symbol, 2, 4);
            }
            case 7 -> {
                checkIsThisPlaceFree(4, 0);
                gameBoard.placeTheSymbol(symbol, 4, 0);
            }
            case 8 -> {
                checkIsThisPlaceFree(4, 2);
                gameBoard.placeTheSymbol(symbol, 4, 2);
            }
            case 9 -> {
                checkIsThisPlaceFree(4, 4);
                gameBoard.placeTheSymbol(symbol, 4, 4);
            }
        }
    }

    private void checkIsThisPlaceFree(int x, int y) throws IllegalArgumentException {
        if (gameBoard.giveCharacter(x, y) != ' ') {
            throw new IllegalArgumentException("This place isn't free");
        }
    }

    public int computerMove() {
        return computer.computerRandom();
    }

    public void addToPlayerFields(int field) {
        playerFields.add(field);
    }

    public void addToComputerFields(int field) {
        computerFields.add(field);
    }

    public void checkTheWinner(String winner) throws Exception {
        if (winner.equals("player")) {
            for (List<Integer> attempts : gameBoard.getWinningAttempts()) {
                if (playerFields.containsAll(attempts)) {
                    throw new Exception("WE HAVE THE WINNER - player");
                }
            }
        }
        if (winner.equals("computer")) {
            for (List<Integer> attempts : gameBoard.getWinningAttempts()) {
                if (computerFields.containsAll(attempts)) {
                    throw new Exception("WE HAVE THE WINNER - computer");
                }
            }
        }
    }

    public boolean supportForLoop(int i){
        return i >= 8;
    }
}
