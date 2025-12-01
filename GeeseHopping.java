import java.io.*;
import java.util.*;

public class GeeseHopping { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        int[][] grid = new int[R][C]; // 0 = open, 1 = goose, 2 = rock, 3 = start, 4 = end
        Cell[][] cells = new Cell[R][C];
        int sx = 0, sy = 0, ex = 0, ey = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < C; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 3) {sx = i; sy = j; }
                else if (grid[i][j] == 4) {ex = i; ey = j; }
                cells[i][j] = new Cell(i, j, -1, 0, -1);
            }
        }

        PriorityQueue<Cell> q =  new PriorityQueue<>();
        q.add(new Cell(sx, sy, 0, 1, 0));

        int[] lr = {-1, 1, -2, 2, -2, 2, -1, 1};
        int[] ud = {-2, -2, -1, -1, 1, 1, 2, 2};
        while (!q.isEmpty()) {
            Cell dv = q.poll();
            if (cells[dv.r][dv.c].cost == -1 || cells[dv.r][dv.c].cost < dv.cost) { // if distance is smaller
                cells[dv.r][dv.c].cost = dv.cost;
                cells[dv.r][dv.c].paths = dv.paths;
            }
            else if (cells[dv.r][dv.c].cost == dv.cost) cells[dv.r][dv.c].paths += dv.paths; // if distance is the same
//            System.out.println(dv.r + " " + dv.c + " " + dv.cost + " " + dv.paths  + " " + dv.jumps);
            for (int a = 0; a < 8; a++) {
                int r = dv.r + lr[a], c = dv.c + ud[a];
                if (r < R && r >= 0 && c < C && c >= 0 && grid[r][c] != 2) { // in bounds and not a rock
                    int cost = (grid[r][c] == 1 ? 0 : 1) + dv.cost; // update cost (add 1 if no goose)
                    if (cells[r][c].cost == -1 || cells[r][c].cost <= cost) q.add(new Cell(r, c, cost, cells[dv.r][dv.c].paths, dv.jumps+1));
                }
            }
        }
        if (cells[ex][ey].cost == -1) {
            System.out.println(-1);
        }
        else {
            System.out.println(cells[ex][ey].cost);
            System.out.println(cells[ex][ey].jumps);
            System.out.println(cells[ex][ey].paths);
        }
    }
}

class Cell implements Comparable<Cell> {
    int r, c, cost, paths, jumps;
    public Cell(int r, int c, int cost, int paths, int jumps) { // constructor
        this.cost = cost;
        this.r = r;
        this.c = c;
        this.paths = paths;
        this.jumps = jumps;
    }
    public int compareTo(Cell o) { // sorting method
        if (cost == o.cost) {
            return Integer.compare(jumps, o.jumps);
        }
        return Integer.compare(cost, o.cost);
    }
}

