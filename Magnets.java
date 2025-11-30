import java.io.*;
import java.util.*;

public class Magnets { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N][2];
        dp[0][0] = 1; dp[0][1] = 1;
        for (int i = 1; i < N; i++) {
            dp[i][1] = (dp[i-1][0] + dp[i-1][1]) % 5000011; // white
            dp[i][0] = dp[i-1][0];
            if (i > K) dp[i][0] += (dp[i-(K+1)][0]) % 5000011; // adds all blacks from K away
        }
        System.out.println((dp[N-1][0] + dp[N-1][1]) % 5000011);

    }
}

/*
- at each point, can choose black or white
- can only choose black if K away from last black
- dp[i][0, 1] = sum of all possible ways to get to index i and black = 0, white = 1
- 2 for loops, starts from white, then starts from black
 */