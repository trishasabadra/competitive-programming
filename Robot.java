import java.io.*;
import java.util.*;

public class Robot { // start class

//    public static int[] x, y, ans;
    public static int[] x = {-2, 3, 4, 5, 0, 0, 0}, y = {0, 0, 0, 0, 10, -10, 10}, ans;
    public static int tx, ty, N;
    public static boolean[] vis;
    public static void dfs(int cx, int cy, int T, int i) {
        if (cx == tx && cy == ty) {
            ans[T]++;
        }
        if (i < N && T < N && !vis[i]) {
            vis[i] = true;
//            dfs(cx, cy, T, i + 1); // don't use
//            dfs(cx + x[i], cy + y[i], T + 1, i + 1); // use
            for (int j = i+1; j < N; j++) {
                dfs(cx + x[i], cy + y[i], T + 1, j);
            }
        }
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(fin.readLine());
//        StringTokenizer st = new StringTokenizer(fin.readLine());
//        tx = Integer.parseInt(st.nextToken()); ty = Integer.parseInt(st.nextToken());
//
//        x = new int[N]; y = new int[N];
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(fin.readLine());
//            x[i] = Integer.parseInt(st.nextToken()); y[i] = Integer.parseInt(st.nextToken());
//        }

        N = 7;
        tx = 5; ty = 10;

        ans = new int[N+1];
        vis = new boolean[N];
//        dfs(0, 0, 0, 0);
        for (int i = 0; i < N; i++) {
            dfs(0, 0, 0, i);
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(ans[i]);
        }
    }
}
