import java.io.*;
import java.util.*;

public class WaterSlides { // start class

    static boolean[][] vis;
    static ArrayList<Long[]>[] adj;
    static long[][] dp;
    static int N;

    public static long dfs(int i, int j) { // node i, can fail j more times
        if (i == N-1) return 0; // last node, or cannot fail more
        if (vis[i][j]) return dp[i][j];
        vis[i][j] = true;

        long case1 = 0; // case 1: bessie chooses the right path
        for (Long[] k : adj[i]) { // k[0] = node, k[1] = fun
            case1 = Math.max(case1, dfs(Math.toIntExact(k[0]), j) + k[1]);
        }

        long case2 = Long.MAX_VALUE; // case 2: bessie chooses the wrong path
        if (j > 0) {
            for (Long[] k : adj[i]) {
                case2 = Math.min(case2, dfs(Math.toIntExact(k[0]), j - 1) + k[1]);
            }
        }

        dp[i][j] = Math.min(case1, case2);
        return dp[i][j];
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1; // a -> b
            long f = Long.parseLong(st.nextToken());
            adj[a].add(new Long[] { (long) b, f});
        }

        dp = new long[N][K+1]; // dp[i][j] = worst case for i, can fail j more times
        vis = new boolean[N][K+1];
        System.out.println(dfs(0, K)); // node 0, can fail K more times

    }
}

