import java.io.*;
import java.util.*;

public class MansionMaze { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int C = Integer.parseInt(st.nextToken())*2+1, R = Integer.parseInt(st.nextToken())*2+1;
        boolean[][] maze = new boolean[R][C];
        int[][] exit = new int[2][2]; Arrays.fill(exit[0], -1);
        for (int i = 0; i < R; i++) {
            char[] in = fin.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                maze[i][j] = in[j] != ' ';
                if ((j == 0 || j == C-1 || i == 0 || i == R-1) && !maze[i][j]) { // if on the edge of the maze and there is no wall (aka an exit)
                    if (exit[0][0] == -1) { // found first exit
                        exit[0][0] = i; exit[0][1] = j;
                    }
                    else { // found second exit
                        exit[1][0] = i; exit[1][1] = j;
                    }
                }
            }
        }

//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                if (maze[i][j]) System.out.print("1 ");
//                else System.out.print("0 ");
//            }
//            System.out.println();
//        }
//        System.out.println(exit[0][0] + " " + exit[0][1]);
//        System.out.println(exit[1][0] + " " + exit[1][1]);

//        int R = 7, C = 11;
//        boolean[][] maze = {}


        int[][] ans = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(ans[i], R*C);
        }
        int[] lr = {-1, 1, 0, 0}; // left, right
        int[] ud = {0, 0, -1, 1}; // up, down

        for (int b = 0; b <= 1; b++) {
            Queue<Integer[]> nums = new LinkedList();
            Queue<Integer> layers = new LinkedList();
            nums.add(new Integer[]{exit[b][0], exit[b][1]});
            layers.add(0);
            boolean[][] vis = new boolean[R][C];

            while (!nums.isEmpty()) {
                Integer[] x = nums.poll(); // remove current position
                int i = x[0], j = x[1];
                int layer = layers.poll();
                ans[i][j] = Math.min(ans[i][j], (layer+1)/2);
                // iterate through all positions x can go to
                for (int a = 0; a < 4; a++) {
                    int r = i + lr[a], c = j + ud[a];
                    if (r < R && r >= 0 && c < C && c >= 0 && !maze[r][c] && !vis[r][c]) {
                        vis[r][c] = true; // mark as visited
                        nums.add(new Integer[]{r, c});
                        layers.add(layer + 1);
                    }
                }
            }
        }

//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                System.out.print(ans[i][j] + " ");
//            }
//            System.out.println();
//        }

        int max = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (!maze[r][c]) {
                    max = Math.max(ans[r][c], max);
                }
            }
        }
        System.out.println(max);
    }
}

