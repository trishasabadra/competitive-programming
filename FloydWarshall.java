import java.io.*;
import java.util.*;

public class FloydWarshall { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken()); // nodes, edges, queries

        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], 1000001);
            grid[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1, x = Integer.parseInt(st.nextToken());
            grid[a][b] = x;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Math.min(grid[i][j], Math.max(grid[i][k],grid[k][j]));
                }
            }
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
            if (grid[a][b] == 1000001) System.out.println(-1);
            else System.out.println(grid[a][b]);
        }

    }
}
