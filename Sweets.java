import java.io.*;
import java.util.*;

public class Sweets { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(fin.readLine());
        int[] boys = new int[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            boys[i] = Integer.parseInt(st.nextToken());
            sum += boys[i];
        }
        Arrays.sort(boys);
        sum *= M;

        st = new StringTokenizer(fin.readLine());
        int[] girls = new int[M];
        for (int i = 0; i < M; i++) {
            girls[i] = Integer.parseInt(st.nextToken());
            // if not possible
            if (girls[i] < boys[N-1]) {
                System.out.println(-1);
                System.exit(0);
            }
        }
        Arrays.sort(girls);

        for (int i = 1; i < M; i++) {
            sum += girls[i] - boys[N-1]; // adding to the last boy
        }
        if (girls[0] != boys[N-1]) { // bi must be used
            sum += girls[0] - boys[N-2];
        }

        System.out.println(sum);
    }
}

