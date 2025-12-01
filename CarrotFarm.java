import java.io.*;
import java.util.*;

public class CarrotFarm { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken())*3;
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        int N = 5, T = 3;
//        int[][] arr = {{1, 1, 100, 100, 1}, {100, 100, 100, 100, 1}, {100, 100, 100, 100, 100}, {100, 100, 100, 1, 100}, {100, 100, 100, 100, 100}};

        int[] lr = {-1, 1, 0, 0, 0, 1, 2, 3, -1, -2, -3, -2, -1, 0, 1, 2}; // rows
        int[] ud = {0, 0, -1, 1, 3, 2, 1, 0, 2, 1, 0, -1, -2, -3, -2, -1}; // columns
        int[][] answers = {{N-3, N-1}, {N-2, N-2}, {N-1, N-3}, {N-2, N-1}, {N-1, N-2}, {N-1, N-1}};
        PriorityQueue<Pasture> q = new PriorityQueue<>();
        q.add(new Pasture(0, 0, 0));
        boolean[][] vis = new boolean[N][N];
        int[][] cost = new int[N][N];
        vis[0][0] = true;
        while (!q.isEmpty()) {
            Pasture p = q.poll();
            for (int i = 0; i < 6; i++) {
                if (answers[i][0] == p.r && answers[i][1] == p.c) {
                    if (i < 3) System.out.println(p.cost+(T/3)*2);
                    else if (i < 5) System.out.println(p.cost+(T/3));
                    else System.out.println(p.cost);
                    System.exit(0);
                }
            }
            // iterate through all positions x can go to
            for (int a = 0; a < 16; a++) {
                int r = p.r + lr[a], c = p.c + ud[a];
                if (r < N && r >= 0 && c < N && c >= 0 && (!vis[r][c] || cost[r][c] > p.cost+T+arr[r][c])) {
                    vis[r][c] = true; // mark as visited
                    cost[r][c] = p.cost+T+arr[r][c];
                    q.add(new Pasture(r, c, p.cost+T+arr[r][c]));
                }
            }
        }

    }
}

class Pasture implements Comparable<Pasture> {
    int r, c, cost;
    public Pasture(int r, int c, int cost) { // constructor
        this.cost = cost;
        this.r = r;
        this.c = c;
    }
    public int compareTo(Pasture o) { // sorting method
        return Integer.compare(cost, o.cost);
    }
}
