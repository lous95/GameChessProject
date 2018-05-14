/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package louay.gamechess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Louay
 */
public class Game {

    private static final Logger LOGGER = Logger.getLogger(Game.class.getName());

    boolean isWhitesTurn = true;
    private List<Point> visited = new ArrayList<>();

    private Point whitePlayer = new Point(0, 7);
    private Point blackPlayer = new Point(7, 0);

    public Game() {
        visited.add(whitePlayer);
        visited.add(blackPlayer);
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            List<Point> allowed_moves = isWhitesTurn ? whitePlayer.moves(visited) : blackPlayer.moves(visited);

            if (allowed_moves.isEmpty()) {
                LOGGER.log(Level.INFO, "Closing scanner and breaking out of loop");
                sc.close();
                printWinner();
                break;
            }

            System.out.println((isWhitesTurn ? "White" : "Black") + " player's turn");

            Display.showBoard(this);

            Point newSpot = null;

            while (newSpot == null) {
                printAllowedMoves(allowed_moves);

                System.out.print("Enter a move index: ");
                String line = sc.nextLine();
                try {
                    int i = Integer.parseInt(line);
                    if (i < 0 || i >= allowed_moves.size()) {
                        System.err.println("Please enter a valid index\n");
                        LOGGER.log(Level.WARNING, String.format("%d can cause out of bounds exception", i));
                        continue;
                    }
                    newSpot = allowed_moves.get(i);
                    System.out.print("\n");
                } catch (NumberFormatException e) {
                    LOGGER.log(Level.WARNING, String.format("Entered '%s' which is not a numeric string, asking again", line));
                    System.err.println("Please enter an integer\n");
                }
            }

            visited.add(newSpot);

            if (isWhitesTurn) {
                whitePlayer = newSpot;
                isWhitesTurn = false;
            } else {
                blackPlayer = newSpot;
                isWhitesTurn = true;
            }

        }
    }

    public Point getWhite() {
        return whitePlayer;
    }

    public Point getBlack() {
        return blackPlayer;
    }

    public List<Point> getVisited() {
        return visited;
    }

    private void printAllowedMoves(List<Point> allowed_moves) {
        System.out.println("Allowed moves:");
        for (int i = 0; i < allowed_moves.size(); i++) {
            System.out.println("\t[" + i + "]: " + allowed_moves.get(i).toString());
        }
        System.out.print("\n");
    }

    private void printWinner() {
        if (isWhitesTurn) {
            System.out.println("Game is over, black player won the game");
        } else {
            System.out.println("Game is over, white player won the game");
        }
    }

}
