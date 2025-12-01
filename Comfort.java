import java.io.*;
import java.util.*;

public class Comfort { // start class

    static int N;
    static boolean[][] vis = new boolean[2000][2000];
    static int[] x = {1, -1, 0, 0}, y = {0, 0, 1, -1};
    static int[] ans;
    public static void floodfill(int r, int c, int index) {
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            if (vis[r+x[i]][c+y[i]]) counter++;
        }
        if (counter == 3) {
            for (int i = 0; i < 4; i++) {
                if (!vis[r+x[i]][c+y[i]]) {
                    vis[r+x[i]][c+y[i]] = true;
                    ans[index]++;
                    floodfill(r+x[i] , c+y[i], index);
                }
            }
        }
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(fin.readLine());
        ans = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            int r = Integer.parseInt(st.nextToken())+1000, c = Integer.parseInt(st.nextToken())+1000;
            vis[r][c] = true;
            floodfill(r, c, i);
            System.out.println(ans[i]);
        }
    }
}
