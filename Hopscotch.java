import java.io.*;
import java.util.*;

public class Hopscotch { // start class

    public static int[][] arr;
    public static long[][] ans;
    public static boolean[][] solved;
    static int R, C;
    public static long recur(int row, int col) {
//        System.out.println(row + " " + col);
        if (row == R-1 && col == C-1) { // counts # of times it reaches end
            return 1;
        }
        if (solved[row][col]) return ans[row][col];
        solved[row][col] = true;
        ans[row][col] = 0;
        for (int i = row+1; i < R; i++) { // iterates through all possible positions you can go
            for (int j = col+1; j < C; j++) {
                if (arr[i][j] != arr[row][col]) {
                    ans[row][col] += recur(i, j);
                    ans[row][col] %= 1000000007;
                }
            }
        }
        return  ans[row][col];
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = new long[R][C];
        solved = new boolean[R][C];
        recur(0, 0);
        System.out.println(ans[0][0]);

    }
}
