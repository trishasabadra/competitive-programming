import java.io.*;
import java.util.*;

public class Tractor { // start class

    static int N, K, count;
    static int[][] grid;
    // = {{0, 0, 0, 3, 3}, {0, 0, 0, 0, 3}, {0, 9, 9, 3, 3}, {9, 9, 9, 3, 3}, {9, 9, 9, 9, 3}}
    static boolean[][] vis;
    public static void floodfill(int r, int c) {
        if (r >= 0 && r < N && c >= 0 && c < N && !vis[r][c] && grid[r][c] <= K) { // if row and col are in bounds and its not visited
            vis[r][c] = true;
            count++;
            floodfill(r-1, c);
            floodfill(r+1, c);
            floodfill(r, c-1);
            floodfill(r, c+1);
        }
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

//        BufferedReader fin = new BufferedReader(new FileReader("tractor.in"));
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tractor.out")));

        N = Integer.parseInt(fin.readLine());
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        int N = 5;

        int l = 0, r = 1000000;
        while (l < r) {
            int m = (l+r) / 2;
            K = m;
            count = 0;
            vis = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!vis[i][j])  floodfill(0, 0);
                }
            }
            if (count >= (N*N+1)/2) r = m;
            else l = m+1;
        }
        System.out.println(r);
//        out.println(r);
//
//        out.close();
    }
}

