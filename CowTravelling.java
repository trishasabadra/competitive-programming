import java.io.*;
import java.util.*;

public class CowTravelling { // start class

    static int R, C, T, sr, sc, er, ec;
    static boolean[][] open;
    //  = {{true, true, true, false, true}, {true, true, true, false, true}, {true, true, true, true, true}, {true, true, true, true, true}}
    static boolean[][][] solved;
    static int[][][] ans;
    static int[] lr = {-1, 1, 0, 0}, ud = {0, 0, -1, 1}; // up, down
    public static int dp (int r, int c, int t) {
        if (r == sr && c == sc && t == 0)
            return 1;
        if (solved[r][c][t])
            return ans[r][c][t];
        solved[r][c][t] = true;
        for (int a = 0; a < 4; a++) {
            int i = r + lr[a], j = c + ud[a];
            if (i < R && i >= 0 && j < C && j >= 0 && open[i][j] && t > 0) {
                ans[r][c][t] += dp(i, j, t-1);
            }
        }
        return ans[r][c][t];
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken()); T = Integer.parseInt(st.nextToken());
        open = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            char[] c = fin.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                open[i][j] = c[j] == '.';
            }
        }
        st = new StringTokenizer(fin.readLine());
        sr = Integer.parseInt(st.nextToken())-1; sc = Integer.parseInt(st.nextToken())-1;
        er = Integer.parseInt(st.nextToken())-1; ec = Integer.parseInt(st.nextToken())-1;

//        R = 4; C = 5; T = 6;
//        int sr = 0, sc = 2; er = 0; ec = 4;

        solved = new boolean[R][C][T+1];
        ans = new int[R][C][T+1];
        ans[sr][sc][0] = 1;
        dp(er, ec, T);
        System.out.println(ans[er][ec][T]);

    }
}
