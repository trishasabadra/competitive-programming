import java.io.*;
import java.util.*;

public class Marathon { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] xs = new int[N], ys = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(fin.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[K+1][N]; // dp[i][j] = min distance from 0 -> j with i skips
        for (int i = 0; i <= K; i++) {
            for (int j = 1; j < N; j++) { // starts at 2nd node
                int k = i, m = j-1;
                int min = Integer.MAX_VALUE;
                while (k >= 0 && m >= 0) {
                    min = Math.min(min, dp[k][m] + Math.abs(xs[m]- xs[j]) + Math.abs(ys[m]-ys[j]));
                    k--; m--;
                }
                dp[i][j] = min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= K; i++) {
            min = Math.min(min, dp[i][N-1]);
        }
        System.out.println(min);
    }
}
