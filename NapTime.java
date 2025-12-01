import java.io.*;
import java.util.*;

public class NapTime { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), F = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken()); // nodes, special places, edges

        int[] sp = new int[F]; // special places
        for (int i = 0; i < F; i++) {
            sp[i] = Integer.parseInt(fin.readLine())-1;
        }

        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], 893);
            grid[i][i] = 0;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken());
            grid[a][b] = c;
            grid[b][a] = c;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE, index = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < F; j++) {
                sum += grid[i][sp[j]];
            }
            if (sum < min) {
                min = sum; index = i;
            }
//            System.out.println(sum);
        }
        System.out.println(index+1);

    }
}
