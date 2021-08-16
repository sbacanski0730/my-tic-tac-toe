package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Welcome! Let's play!");
        game.printBoard();
        boolean sayToLoopGetToWork = true;

        int occupiedField = 0;
        while (sayToLoopGetToWork) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your move: ");
            int playerPlace = scanner.nextInt();

            try {
                game.placeSymbol(playerPlace, "player");
                game.addToPlayerFields(playerPlace);
                if(game.supportForLoop(occupiedField)){
                    game.printBoard();
                    Log.getMessage("All fields are occupied");
                    break;
                } else {
                    occupiedField++;
                }
                game.printBoard();
                try {
                    game.checkTheWinner("player");
                } catch (Exception e) {
                    game.setTheWinner("Player");
                    Log.getMessage(e.getMessage());
                    break;
                }
            } catch (IllegalArgumentException e) {
                Log.getMessage(e.getMessage());
            }
            Log.separator();

            try {
                int computerPlace = game.computerMove();
                game.placeSymbol(computerPlace, "computer");
                game.addToComputerFields(computerPlace);
                if(game.supportForLoop(occupiedField)){
                    game.printBoard();
                    Log.getMessage("All fields are occupied");
                    break;
                } else {
                    occupiedField++;
                }
                System.out.println("Computer move");
                game.printBoard();
                try {
                    game.checkTheWinner("computer");
                } catch (Exception e) {
                    game.setTheWinner("Computer");
                    Log.getMessage(e.getMessage());
                    break;
                }
            } catch (IllegalArgumentException e) {
                Log.getMessage(e.getMessage());
            }
        }

        Log.separator();
        Log.separator();
        Log.getMessage("GAME OVER");
        Log.getMessage("OUR WINNER:"+game.getTheWinner());
        game.printBoard();
        Log.separator();
    }
}
