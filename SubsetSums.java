import java.io.*;
import java.util.*;

public class SubsetSums { // start class

    public static long[][] ans; // ans[index][sum] = # of ways to get sum from start to index
    public static boolean[][] solved;
    public static long dp(int index, int target) {
//        System.out.println(row + " " + col);
        if (target < 0) return 0;
        if (index == 0) return ans[index][target];
        if (!solved[index][target]) {
            ans[index][target] = dp(index-1, target) + dp(index-1, target-index);
            solved[index][target] = true;
        }
        return ans[index][target];
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());

//        int N = 4;
        if (N*(N+1) % 4 != 0) {
            System.out.println(0);
            System.exit(0);
        }
        int target = N*(N+1)/4;
        ans = new long[N+1][target+1];
        solved = new boolean[N+1][target+1];
        ans[0][0] = 1;
        dp(N, target);
        System.out.println(ans[N][target]/2);
    }
}
