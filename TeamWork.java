import java.io.*;
import java.util.*;

public class TeamWork { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(fin.readLine());
        }

//        int N = 7, K = 3;
//        int[] arr = {1, 15, 7, 9, 2, 5, 10};

        int[] dp = new int[N]; dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = 1; j <= K && i-j+1 >= 0; j++) {
                max = Math.max(max, arr[i-j+1]);
                if (i-j >= 0) dp[i] = Math.max(dp[i], dp[i-j] + max*j);
                else dp[i] = Math.max(dp[i], max*j);
            }
        }

        System.out.println(dp[N-1]);
    }
}
