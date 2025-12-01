import java.io.*;
import java.util.*;

public class Sabotage { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

//        BufferedReader fin = new BufferedReader(new FileReader("sabotage.in"));
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sabotage.out")));

        int N = Integer.parseInt(fin.readLine());
        int[] arr = new int[N];
        long[] preSum = new long[N+1];
        int big = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(fin.readLine());
            preSum[i+1] = preSum[i] + arr[i];
            if (i != 0 && i != N-1) big = Math.max(big, arr[i]);
        }

        long sum = preSum[N];
        double minAve = (double) sum / big;
        int l = 1, r = N-2; // left, right
        while (l < r) {
            int m = (r + l) / 2; // # of numbers being removed

            // sliding window
            int i = 1;
            long curSum = 0, max = 0;
            while (i <= m) {
                curSum += arr[i];
                i++;
            }
            while (i < N-1) {
                max = Math.max(max, curSum);
                curSum -= arr[i-m];
                curSum += arr[i];
                i++;
            }

            if (minAve/N-1 > (double) (sum-max)/(N-m)) r = m;
            else l = m+1;
        }
        System.out.println((double)Math.round(minAve * 1000d) / 1000d);

//        out.close();
    }
}
