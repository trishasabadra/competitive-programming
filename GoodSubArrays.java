import java.io.*;
import java.util.*;

public class GoodSubArrays { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(fin.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(fin.readLine());
            String s = fin.readLine();
            int[] arr = new int[N], preSum = new int[N + 1]; // prefix sum % N
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(s.substring(i, i+1));
                preSum[i + 1] = preSum[i] + arr[i];
            }

            int[] count = new int[N+1];
            for (int i = 0; i < N; i++) {
                // System.out.println(preSum[i+1]);
                int j = preSum[i+1]-i;
                if (0 <= j && j <= N) count[j]++;
            }

            long ans = count[1];
            for (int i = 0; i <= N; i++) {
                ans += (long) count[i] * (count[i] - 1) / 2;
            }
            System.out.println(ans);

            for (int i = 1; i <= N; i++) {
                System.out.print(preSum[i] + " ");
            }System.out.println();
            for (int i = 0; i < N; i++) {
                System.out.print(preSum[i+1]-i + " ");
            }
            System.out.println();
            for (int i = 1; i <= N; i++) {
                System.out.print(count[i] + " ");
            }
        }
    }
}
