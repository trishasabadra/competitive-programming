import java.io.*;
import java.util.*;

public class Increase { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());

        long[] a = new long[N];
        StringTokenizer st = new StringTokenizer(fin.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

//        int N = 5;
//        long[] a = {2, 7, 3, 5, 1};

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) { // set 0 to index i
            long[] b = new long[N];
            long count = 0;
            for (int j = i-1; j >= 0; j--) {
                long t = Math.abs(b[j+1]/a[j]) + 1;
                // if (b[j+1] % a[j] == 0) t++;
                b[j] = -1*a[j]*t;
                count += t;
            }
            for (int j = i+1; j < N; j++) {
                long t = b[j-1]/a[j] + 1;
               // if (b[j-1] % a[j] == 0) t++;
                b[j] = a[j]*t;
                count += t;
            }
            ans = Math.min(ans, count);
        }
        System.out.println(ans);
    }
}
/*
set 0
-
iterate through array to make parts before smaller than 0 and parts after greater than 0
 */
