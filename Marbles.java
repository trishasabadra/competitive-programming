import java.io.*;
import java.util.*;

public class Marbles { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        char[] c = fin.readLine().toCharArray();
        int[] right = new int[K+1], left = new int[K+1];

        // right
        int countW = 0;
        for (int i = 0, k = 0; i < N && k <= K; i++) {
            right[k] = countW;
            if (c[i] == 'B') k++;
            else countW++;
        }

        // left
        countW = 0;
        for (int i = N-1, k = 0; i >= 0 && k <= K; i--) {
            left[k] = countW;
            if (c[i] == 'B') k++;
            else countW++;
        }

        int max = 0;
        for (int i = 0; i <= K; i++) {
            max = Math.max(max, right[i]+left[K-i]);
        }
        System.out.println(max);

    }
}

