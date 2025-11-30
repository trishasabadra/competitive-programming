import java.io.*;
import java.util.*;

public class LongComSubseq { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        char[] a = fin.readLine().replaceAll(" ", "").toCharArray(), b = fin.readLine().replaceAll(" ", "").toCharArray();

        int max = 0;
        int[] prev = new int[b.length], cur = new int[b.length]; // dp[i][j] = length of longest substring ending at index i for string a and j for b
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (j == 0) {
                    if (a[i] == b[j]) cur[j] = 1;
                    cur[j] = Math.max(cur[j], prev[j]);
                }
                else {
                    if (a[i] == b[j])
                        cur[j] = prev[j-1] + 1;
                    cur[j] = Math.max(cur[j], Math.max(prev[j], cur[j-1]));
                }
                max = Math.max(max, cur[j]);
            }
            prev = cur.clone();
            cur = new int[b.length];
        }
        System.out.println(max);
    }
}
