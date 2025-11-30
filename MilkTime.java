import java.io.*;
import java.util.*;

public class MilkTime { // start class

    static boolean[] vis;
    static int[][] intervals;
    static int[] max;
    static int M;
    public static void dfs(int num, int points) {
        vis[num] = true;
        max[num] = Math.max(max[num], points);
        for (int n = num+1; n < M; n++) {
            //System.out.println(num + " " + n);
            if (intervals[n][0] >= intervals[num][1] && max[n] < intervals[n][2]+points) // if next interval occurs after current
                dfs(n, intervals[n][2]+points);
        }
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); int R = Integer.parseInt(st.nextToken());
        intervals = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(fin.readLine());
            intervals[i][0] = Integer.parseInt(st.nextToken()); intervals[i][1] = Integer.parseInt(st.nextToken())+R; intervals[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(intervals, (a,b)->(int)(a[0] - b[0])); // sorts based on start time in ascending order

        // for (int i = 0; i < M; i++) System.out.println(intervals[i][0] + " " + intervals[i][1]);

        vis = new boolean[M];
        max = new int[M];
        for (int i = 0; i < M; i++) {
            if (!vis[i]) dfs(i, intervals[i][2]);
        }

        int maxPoints = 0;
        for (int i = 0; i < M; i++) maxPoints = Math.max(maxPoints, max[i]);
        System.out.println(maxPoints);
    }
}
