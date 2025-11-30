import java.io.*;
import java.util.*;

public class Water { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(fin.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(fin.readLine());
            StringTokenizer st = new StringTokenizer(fin.readLine());
            int[] arr = new int[N];
            int max = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i]);
            }

            int odds = 0, evens = 0;
            for (int i = 0; i < N; i++) {
                int dif = max - arr[i];
                odds += dif % 2;
                evens += dif/2;
            }

            if (odds > evens) System.out.println(odds*2-1);
            else {
                int dif = evens - odds, x = (int) Math.round(dif/3.0);
                odds += x*2;
                evens -= x;
                if (evens >= odds) System.out.println(evens*2);
                else System.out.println(odds * 2 - 1);
            }
        }
    }
}
