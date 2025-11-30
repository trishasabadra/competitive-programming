import java.io.*;
import java.util.*;

public class Frog { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[] heights = new int[N];
        st = new StringTokenizer(fin.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N]; // min cost to get to stone i with k jumps of length 1 -> k
        for (int i = 1; i < N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= i && j <= K; j++) {
                min = Math.min(min, dp[i - j] + Math.abs(heights[i] - heights[i-j]));
            }
            dp[i] = min;
        }
        System.out.println(dp[N-1]);
    }
}
