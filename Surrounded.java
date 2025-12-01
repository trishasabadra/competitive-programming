import java.io.*;
import java.util.*;

public class Surrounded { // start class

    static boolean[][] hb = new boolean[1001][1001];
    static boolean[][] vis;
    static boolean reachEnd = false;
    static int layer;
    static int[] ud = {0, 0, -1, 1}, lr = {1, -1, 0, 0};
    static int R = 0, C = 0;
    static Queue<Integer[]> tempN;
    static Queue<Integer> tempL;

    public static void floodfill(int r, int c) {
        if (r == 0 && c == 0) {
            reachEnd = true;
            return;
        }
        vis[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int newR = r+ud[i], newC = c+lr[i];
            if (newR >= 0 && newR < R && newC >= 0 && newC < C && !vis[newR][newC]) {
                if (hb[newR][newC]) {
                    tempN.add(new Integer[] {newR, newC});
                    tempL.add(layer+1);
                }
                else floodfill(newR, newC);
            }
        }
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), sx = Integer.parseInt(st.nextToken()), sy = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(fin.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            hb[x][y] = true;
            R = Math.max(x, R);
            C = Math.max(y, C);
        }

//        int N = 7, sx = 5, sy = 2;
//        hb[5][1] = true; hb[4][1] = true; hb[3][2] = true; hb[2][1] = true; hb[6][2] = true; hb[4][3] = true; hb[5][3] = true;

//        int N = 4, sx = 2, sy = 2;
//        hb[2][1] = true; hb[1][2] = true; hb[2][3] = true; hb[4][2] = true;

        Queue<Integer[]> nums = new LinkedList<>();
        Queue<Integer> layers = new LinkedList<>();
        vis = new boolean[R][C];
        nums.add(new Integer[] {sx, sy});
        layers.add(0);

        while (!nums.isEmpty()) {
            layer = layers.poll();
            Integer[] x = nums.poll();
            int i = x[0], j = x[1];

            if (!vis[i][j]) {
                tempN = new LinkedList<>(); tempL = new LinkedList<>();
                floodfill(i, j);
                nums.addAll(tempN); layers.addAll(tempL);
                if (reachEnd) {
                    System.out.println(layer);
                    System.exit(0);
                }
            }
        }
    }
}

