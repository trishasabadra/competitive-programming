import java.io.*;
import java.util.*;

public class Hay4Sale { // start class

    static boolean[] vis;
    static int[] arr;
    static int N, C;
    public static void recur(int n, int sum) {
        for (int i = n+1; i < N; i++) {
            if (arr[i]+sum <= C && !vis[arr[i]+sum]) {
                vis[arr[i]+sum] = true;
                recur(i, sum+arr[i]);
            }
        }
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        C = Integer.parseInt(st.nextToken()); // capacity
        N = Integer.parseInt(st.nextToken()); // # of haybales
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(fin.readLine());
        }

        vis = new boolean[C+1];
        for (int i = 0; i < N; i++) {
            recur(i, arr[i]);
        }

        for (int i = C; i >= 0; i--) {
            if (vis[i]) {
                System.out.println(i);
                break;
            }
        }

//        int[] prev = new int[C], ans = new int[C];
//        for (int i = 0; i < N; i++) { // iterate through index
//            for (int j = 0; j < C; j++) { // iterate through capacity
//                if (j > arr[i]) ans[j] = Math.max(prev[j], prev[j - arr[i]]);
//                else ans[j] = prev[j];
//            }
//            prev = ans.clone();
//        }
//
//        int max = 0;
//        for (int i = 0; i < C; i++) {
//            max = Math.max(ans[i], max);
//        }
//        System.out.println(max);
    }
}

