import java.io.*;
import java.util.*;

public class PieTreasure { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

        int[][] grid = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < C; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] max = new int[R][C];

        PriorityQueue<Pie> q =  new PriorityQueue<>();
        q.add(new Pie(0, 0, grid[0][0]));

        while (!q.isEmpty()) {
            Pie dv = q.poll();
            int r = dv.r, c = dv.c, cost = dv.cost;
            max[r][c] = Math.max(max[r][c], cost);
            for (int i = -1; i < 2; i++) {
                if (r+i < R && r+i >= 0 && c+1 < C && max[r+i][c+1] < grid[r+i][c+1]+cost) {
                    q.add(new Pie(r+i, c+1, grid[r+i][c+1]+cost));
                }
            }
        }
        System.out.println(max[R-1][C-1]);
    }
}

class Pie implements Comparable<Pie> {
    int r, c, cost;
    public Pie(int r, int c, int cost) { // constructor
        this.cost = cost;
        this.r = r;
        this.c = c;
    }
    public int compareTo(Pie o) { // sorting method
        return -Integer.compare(cost, o.cost);
    }
}

