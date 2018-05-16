/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package louay.gamechess;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Louay
 */
public class Point {
    
    private final int x;
    private final int y;
    /**
     * A constructor for the coordinates
     * x and y.
     * @param x coordinate x
     * @param y coordinate y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * The <code>moves</code> method returns a list of allowed
     * moves to a specific player according to his
     * position at that moment, using all the possible
     * moves of a knight piece and it checks if one 
     * of this possible moves are already visited by 
     * one of the players.
     * @param visited A list of visited positions.
     * @return A list of the possible moves
     */
    public List<Point> moves(List<Point> visited) {
        Point[] all_possibilities = {new Point(x - 1, y - 2), new Point(x + 1, y - 2), new Point(x + 2, y - 1), new Point(x + 2, y + 1),
            new Point(x + 1, y + 2), new Point(x - 1, y + 2), new Point(x - 2, y + 1), new Point(x - 2, y - 1)};
        List<Point> ps = new ArrayList<>();

        for (Point p : all_possibilities) {
            if ((p.x >= 0 && p.x < 8 && p.y >= 0 && p.y < 8) && !visited.contains(p)) {
                ps.add(p);
            }
        }
        return ps;
    }

    
    /**
     * This is a <code>toString</code> method which displays
     * the x and y coordinate of a specific point.
     */
    @Override
    public String toString() {
        return "{" + x + ", " + y + '}';
    }
    /**
     * The equals method is used to compare
     * if a given point is already existing in
     * visited point list in the moves method.
     * @param obj 
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

}
