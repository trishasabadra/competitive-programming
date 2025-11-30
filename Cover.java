import java.io.*;
import java.util.*;

public class Cover { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        boolean[][] grid = new boolean[2][N]; Arrays.fill(grid[0], true); Arrays.fill(grid[1], true);
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(fin.readLine());
            int c = Integer.parseInt(st.nextToken())-1, r = Integer.parseInt(st.nextToken());
            grid[r][c] = false;
        }

//        int N = 5, K = 2;
//        boolean[][] grid = {{true, true, false, true, true}, {true, true, true, true, false}};

        ArrayList<Integer> fib = new ArrayList<>(); fib.add(1); fib.add(1);
        long ans = 1;
        for (int i = 0; i < N; i++) {

            // find longest consecutive 2 x m grid
            int j = i;
            while (grid[0][j] && grid[1][j]) {
                grid[0][j] = false; grid[1][j] = false;
                j++;
            }
            if (j > i) {
                while (fib.size() <= j-i) fib.add(fib.get(fib.size()-2)+fib.get(fib.size()-1));
                ans *= fib.get(j-i);
                ans %= 1000000007;
                i = j-1;
            }

            if (grid[0][i] && i < N-1 && grid[0][i+1]) { // top row
                grid[0][i+1] = false; grid[0][i] = false;
            }
            if (grid[1][i] && i < N-1 && grid[1][i+1]) { // bot row
                grid[1][i+1] = false; grid[1][i] = false;
            }
            if (grid[0][i] || grid[1][i]) { // doesn't work
                System.out.println(0); System.exit(0);
            }
        }
        System.out.println(ans);
    }
}
