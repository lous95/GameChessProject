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
    
    /**
     * The showBoard takes game as a parameter
     * it simply displays on a specific position
     * of the chess board starting from (0,0)
     * ending with position (7,7)
     * if its taken by the white
     * or the black player or the point has been
     * already visited by one of the players by using
     * the pattern # ,if it is none of these cases
     * we display a white space.
     * 
     * 
     * @param game 
     */
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
