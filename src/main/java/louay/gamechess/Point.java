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

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

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

    @Override
    public String toString() {
        return "{" + x + ", " + y + '}';
    }

    @Override
    public boolean equals(Object obj) {
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

}
