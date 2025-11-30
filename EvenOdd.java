import java.io.*;
import java.util.*;

public class EvenOdd { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        StringTokenizer st = new StringTokenizer(fin.readLine());
        boolean[] parity = new boolean[N];
        for (int i = 0; i < N; i++) {
            parity[i] = Integer.parseInt(st.nextToken()) % 2 == 0;
        }

        boolean[] b1 = new boolean[N], b2 = new boolean[N];
        b1[0] = true; b2[0] = false;
        for (int i = 1; i < N; i++) {
            b1[i] = !b1[i-1];
            b2[i] = !b2[i-1];
        }

        int c1 = 0, c2 = 0;
        for (int i = 0; i < N; i++) {
            if (b1[i] != parity[i]) c1++;
            if (b2[i] != parity[i]) c2++;
        }
        System.out.println(Math.min(c1, c2));
    }
}
