import java.io.*;
import java.util.*;

public class Traveling { // start class

    public static int[] lr = {-1, 1, 0, 0}, ud = {0, 0, -1, 1}; // left, right, up, down
    public static boolean[][] vis;
    public static boolean works;
    public static int N;
    public static void floodfill(int r, int c) {
        if (c == N - 1) {
            works = true;
            return;
        }
        for (int a = 0; a < 4; a++) {
            int nr = r + lr[a], nc = c + ud[a];
            if (nr < 3 && nr >= 0 && nc < N && nc >= 0 && !vis[nr][nc]) {
                vis[nr][nc] = true;
                floodfill(nr, nc);
            }
        }
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(fin.readLine());
        boolean[][] grid = new boolean[3][N];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!grid[i][0]) {
                vis = grid.clone();
                works = false;
                floodfill(i, 0);
                if (works) {
                    System.out.println("YES");
                    System.exit(0);
                }
            }
        }
        System.out.println("NO");
    }
}
