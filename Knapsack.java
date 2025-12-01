import java.io.*;
import java.util.*;

public class Knapsack { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());

        int[] time = new int[N], score = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(fin.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            score[i] = Integer.parseInt(st.nextToken());
        }

        int[] prev = new int[T], ans = new int[T];
        for (int i = 0; i < N; i++) { // iterate through index
            for (int j = 0; j < T; j++) { // iterate through time
                if (j >= time[i]) ans[j] = Math.max(prev[j], prev[j-time[i]] + score[i]);
                else ans[j] = prev[j];
            }
            prev = ans.clone();
        }

        int max = 0;
        for (int i = 0; i < T; i++) {
            max = Math.max(ans[i], max);
        }
        System.out.println(max);
    }
}
