import java.io.*;
import java.util.*;

public class PinBall { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int R = Integer.parseInt(fin.readLine());

        int[][] grid = new int[R][R];
        for (int i = 0; i < R; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < i+1; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        int R = 5;
//        int[][] grid = {{7, 0, 0, 0, 0}, {3, 8, 0, 0, 0}, {8, 1, 0, 0, 0}, {2, 7, 4, 4, 0}, {4, 5, 2, 6, 5}};

        int[][] max = new int[R][R];

        PriorityQueue<Pin> q =  new PriorityQueue<>();
        q.add(new Pin(0, 0, grid[0][0]));

        while (!q.isEmpty()) {
            Pin dv = q.poll();
            int r = dv.r, c = dv.c, cost = dv.cost;
            max[r][c] = Math.max(max[r][c], cost);
            for (int i = 0; i < 2; i++) {
                if (r+1 < R && c+i >= 0 && c+i < R+1 && max[r+1][c+i] < grid[r+1][c+i]+cost) {
                    q.add(new Pin(r+1, c+i, grid[r+1][c+i]+cost));
                }
            }
        }

        int m = 0;
        for (int i = 0; i < R; i++) {
            m = Math.max(m, max[R-1][i]);
        }
        System.out.println(m);
    }
}

class Pin implements Comparable<Pin> {
    int r, c, cost;
    public Pin(int r, int c, int cost) { // constructor
        this.cost = cost;
        this.r = r;
        this.c = c;
    }
    public int compareTo(Pin o) { // sorting method
        return -Integer.compare(cost, o.cost);
    }
}

