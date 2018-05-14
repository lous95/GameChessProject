/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package louay.gamechess;

/**
 *
 * @author Louay
 */
public class Display {

    public static void showBoard(Game game) {
        System.out.println("0 1 2 3 4 5 6 7");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Point current = new Point(j, i);
                if (current.equals(game.getWhite())) {
                    System.out.print("W ");
                } else if (current.equals(game.getBlack())) {
                    System.out.print("B ");
                } else if (game.getVisited().contains(current)) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println(i);
        }
        System.out.println();
    }

}
