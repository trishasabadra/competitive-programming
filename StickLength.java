import java.io.*;
import java.util.*;

public class StickLength { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(fin.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long ans = 0;
        int median = arr[N/2];
        for (int i = 0; i < N; i++) {
            ans += Math.abs(median - arr[i]);
        }
        System.out.println(ans);
    }
}
