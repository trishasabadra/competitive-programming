import java.io.*;
import java.util.*;

public class HeavySpender { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int K = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()); // K coins total, N types of coins
        int[] arr = new int[N];
        for (int i = 0; i < N;) {
            st = new StringTokenizer(fin.readLine());
            int j = 0;
            while (i < N && j < 15) {
                arr[i] = Integer.parseInt(st.nextToken());
                i++; j++;
            }
        }

        int[] dp = new int[2000001]; // min # coins to get to that coin
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int i = 0;
        while (i < dp.length && dp[i] != -1) { // iterate through all numbers
            if (dp[i] < K) {
                for (int j = 0; j < N; j++) { // iterate through all types of coins
                    // get minimum amount of coins to reach
                    if (dp[i + arr[j]] == -1) dp[i + arr[j]] = dp[i] + 1;
                    else dp[i + arr[j]] = Math.min(dp[i + arr[j]], dp[i] + 1);
                }
            }
            i++;
        }
        System.out.println(i-1);
    }
}

// solve all possible numbers, then go in order to see until what number you can do it
