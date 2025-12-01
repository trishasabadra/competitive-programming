import java.io.*;
import java.util.*;

public class Intervals { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        long[] left = new long[M+1], right = new long[M+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            left[a]++;
            right[b]++;
        }

        long[] preSum = new long[2*M+2];
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= M; j++) {
                preSum[i+j] += left[i] * left[j];
                preSum[i+j+1] -= right[i] * right[j];
            }
        }

        long cur = 0;
        for (int i = 0; i < 2*M+1; i++) {
            cur += preSum[i];
            System.out.println(cur);
        }
    }
}
