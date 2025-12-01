import java.io.*;
import java.util.*;

public class SpaceForce { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int[] lr = {-1, 1, 0, 0}; // left, right
        int[] ud = {0, 0, -1, 1}; // up, down

        int[][] asteroids = new int[301][301];
        for (int i = 0; i < 301; i++) {
            Arrays.fill(asteroids[i], -1);
        }

        int N = Integer.parseInt(fin.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), z = Integer.parseInt(st.nextToken());
            asteroids[y][x] = z;
            for (int a = 0; a < 4; a++) {
                int r = y + lr[a], c = x + ud[a];
                if (r < 301 && r >= 0 && c < 301 && c >= 0 && (asteroids[r][c] == -1 || asteroids[r][c] > z)) {
                    asteroids[r][c] = z;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                if (asteroids[i][j] == -1) System.out.print("- ");
                else System.out.print(asteroids[i][j] + " ");
                if (asteroids[i][j] < 10) System.out.print(" ");
            }
            System.out.println();
       }

        Queue<Integer[]> nums = new LinkedList();
        Queue<Integer> layers = new LinkedList();
        nums.add(new Integer[]{0, 0});
        layers.add(0);
        boolean[][] vis = new boolean[301][301];
        vis[0][0] = true;
        while (!nums.isEmpty()) {
            Integer[] x = nums.poll(); // remove current position
            int i = x[0], j = x[1];
            int layer = layers.poll();
            if (asteroids[i][j] == -1) {
                System.out.println(layer);
                System.exit(0);
            }
            // iterate through all positions x can go to
            for (int a = 0; a < 4; a++) {
                int r = i + lr[a], c = j + ud[a];
                if (r < 301 && r >= 0 && c < 301 && c >= 0 && !vis[r][c] && (asteroids[i][j] > layer || asteroids[i][j] == -1)) {
                    vis[r][c] = true; // mark as visited
                    nums.add(new Integer[]{r, c});
                    layers.add(layer+1);
                }
            }
        }
        System.out.println(-1);
    }
}
