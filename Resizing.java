import java.io.*;
import java.util.*;

public class Resizing { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        int[][] arr = new int[N][2]; // normal, reverse
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(fin.readLine())-1;
        }
        for (int i = 0; i < N; i++) arr[N-i-1][1] = arr[i][0];

        int ans = N;
        for (int m = 0; m < 2; m++) { // do dp twice: increasing and decreasing
            int[][] dp = new int[N][3]; // dp[i][j] = min # of changes to get increasing order at index i and height j
            for (int i = 0; i < 3; i++) dp[0][i] = arr[i][m] == i ? 0 : 1;
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k <= j; k++) {
                        min = Math.min(min, dp[i - 1][k]);
                    }
                    dp[i][j] = min + (arr[i][m] == j ? 0 : 1);
                }
            }
            for (int i = 0; i < 3; i++) ans = Math.min(ans, dp[N - 1][i]);
        }
        System.out.println(ans);
    }
}

/*
- find min # of changes at every index
- for the first index, try all 3 options
 */