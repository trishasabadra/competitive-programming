import java.io.*;
import java.util.*;

public class SandCastle { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken());

        int[] m = new int[N], b = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(fin.readLine());
            m[i] = Integer.parseInt(st.nextToken()); b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(m); Arrays.sort(b);

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (m[i] < b[i]) {
                count += (b[i]-m[i]) * X;
            }
            else {
                count += (m[i]-b[i]) * Y;
            }
        }
        System.out.println(count);
    }
}
