import javax.swing.event.TreeSelectionEvent;
import java.io.*;
import java.util.*;

public class Gravity { // start class

    static boolean[][] vis;
    static boolean reachEnd = false;
    static int layer;
    static int[] ud = {0, 0}, lr = {1, -1};
    static int R,C;
    static Queue<Integer[]> tempN;
    static Queue<Integer> tempL;

    public static void floodfill(int r, int c) {
        if (r == 0 && c == 0) {
            reachEnd = true;
            return;
        }
        vis[r][c] = true;
        for (int i = 0; i < 2; i++) {
            int newR = r+ud[i], newC = c+lr[i];
            if (newR >= 0 && newR < R && newC >= 0 && newC < C && !vis[newR][newC]) {
                floodfill(newR, newC);
            }
        }
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        int sx = 0, sy = 0, ex = 0, ey = 0;

        vis = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String s = fin.readLine();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == '#') {
                    vis[i][j] = true;
                }
                else if (s.charAt(j) == 'C') { sx = i; sy = j; } // start
                else if (s.charAt(j) == 'D') { ex = i; ey = j; } // end
            }
        }

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
