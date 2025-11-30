import java.io.*;
import java.util.*;

public class Breakouts { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());

        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(fin.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        int N = 6; int[] arr = {0, 1, 1, 2, 0, 0, 1};
//        int N = 3; int[] arr = {0, 1, 2, 0};

        int[][][] dp = new int[N+1][N+1][N+1]; // dp[i][j][k] = # of changes for first i days, last breakout on day j, k breakouts
        for (int i = 1; i <= N; i++) { // day i (2 -> N)
            if (arr[1] != 0) dp[i][1][1] = 1; // day i, breakout on day 1, 1 breakout
            for (int j = 1; j <= i; j++) { // last breakout on day j (1 -> i)
                for (int k = 1; k <= j; k++) { // k breakouts (1 -> i)
                    if (j < i) { // breakout is before today
                        dp[i][j][k] = dp[i-1][j][k]; // same as day before
                    }
                    else { // breakout is today and at least 2 breakouts
                        dp[i][j][k] = Integer.MAX_VALUE;
                        for (int x = 1; x < i; x++) { // for all days up to today
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i-1][x][k-1]); // find min changes if the last breakout was at day x
                        }
                    }
                    if (arr[i] != i-j) dp[i][j][k]++; // if the log doesn't match count, 1 more change
                }
            }
        }

        for (int k = 1; k <= N; k++) { // breakouts 1 -> n
            int min = Integer.MAX_VALUE; // min changes at the end of N days and k breakouts
            for (int j = 1; j <= N; j++)  // last breakout day
                min = Math.min(min, dp[N][j][k]);
            System.out.println(min);
        }
    }
}

/*
first breakout must be at index 1
for i days and j < i was the last breakout, there must be <= j breakouts
for i days and today is a breakout, must be at least 2 breakouts
 */