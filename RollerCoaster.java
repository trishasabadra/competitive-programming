import java.io.*;
import java.util.*;

public class RollerCoaster { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int L = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
//        int L = 5, N = 3, B = 10;
        ArrayList<Integer>[] adj = new ArrayList[L+1];
        for (int i = 0; i <= L; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] s = new int[N], e = new int[N], f = new int[N], c = new int[N];
//        int[] s = {0, 2, 4, 1, 3}, e = {2, 4, 5, 3, 4}, f = {2, 2, 2, 2, 2}, c = {3, 2, 2, 1, 1};
//        int[] s = {0, 2, 0, 1, 1, 3}, e = {2, 5, 1, 2, 3, 5}, f = {20, 5, 2, 1, 5, 10}, c = {6, 6, 1, 3, 4, 2};
//        int[] s = {0, 3, 3}, e = {3, 5, 5}, f = {2, 4, 6}, c = {5, 5, 6};
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(fin.readLine());
            s[i] = Integer.parseInt(st.nextToken()); e[i] = s[i]+Integer.parseInt(st.nextToken()); f[i] = Integer.parseInt(st.nextToken()); c[i] = Integer.parseInt(st.nextToken());
            adj[e[i]].add(i);
        }

        int[][] dp = new int[B+1][L+1];
        for (int i = 0; i < B+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= B; i++) {
            for (int j = 1; j <= L; j++) {
                for (int n : adj[j]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
                    if (i - c[n] >= 0 && dp[i-c[n]][s[n]] != -1) {
                        dp[i][j] = Math.max(dp[i][j], f[n] + dp[i-c[n]][s[n]]); // max of previous budget and
                    }
                }
            }
        }

//        for (int i = 1; i <= B; i++) {
//            for (int j = 1; j <= L; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[B][L]);
    }
}
