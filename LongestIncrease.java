import java.io.*;
import java.util.*;

public class LongestIncrease { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    ans[i] = Math.max(ans[i], ans[j]+1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, ans[i]);
        }
        System.out.println(max);
    }
}
