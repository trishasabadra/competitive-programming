import java.io.*;
import java.util.*;

public class Apartment { // start class

    static boolean[][] vis;
    static boolean[][][] grid;
    static int[][] group;
    static int count = 0, size = 0;
    static int R, C;
    static int[] y = {0, 1, 0, -1}, x = {1, 0, -1, 0}; // s, e, n, w

    public static void floodfill(int r, int c) {
        vis[r][c] = true;
        group[r][c] = count;
        size++;
        for (int i = 0; i < 4; i++) {
            int newR = r+x[i], newC = c+y[i];
            if (!grid[r][c][i] && newR >= 0 && newR < R && newC >= 0 && newC < C && !vis[newR][newC]) floodfill(newR, newC);
        }
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        C = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken());

//        R = 2; C = 3;
//        int[][] arr = {{7, 7, 15}, {13, 9, 14}};

        vis = new boolean[R][C];
        grid = new boolean[R][C][4];

        // south, east, north, west
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < C; j++) {
                int a = Integer.parseInt(st.nextToken());
//                int a = arr[i][j];
                if (a >= 8) { // south
                    a -= 8; grid[i][j][0] = true;
                }
                if (a >= 4) { // east
                    a -= 4; grid[i][j][1] = true;
                }
                if (a >= 2) { // north
                    a -= 2; grid[i][j][2] = true;
                }
                if (a >= 1) { // west
                    a -= 1; grid[i][j][3] = true;
                }
            }
        }

        group = new int[R][C];
        int max = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!vis[i][j]) {
                    count++;
                    size = 0;
                    floodfill(i, j);
                    map.put(count, size);
                    max = Math.max(max, size);
                }
            }
        }

//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                System.out.print(group[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(count);
        System.out.println(max);

        int groupMax = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i < R-1 && group[i][j] != group[i+1][j]) {
                    groupMax = Math.max(groupMax, map.get(group[i][j])+map.get(group[i+1][j]));
                }
                if (j < C-1 && group[i][j] != group[i][j+1]) {
                    groupMax = Math.max(groupMax, map.get(group[i][j])+map.get(group[i][j+1]));
                }
            }
        }
        System.out.println(groupMax);

    }
}
