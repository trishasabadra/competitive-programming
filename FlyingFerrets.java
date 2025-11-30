import java.io.*;
import java.util.*;

public class FlyingFerrets { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[] maxTime = new int[M];
        st = new StringTokenizer(fin.readLine());
        for (int i = 0; i < M; i++) {
            maxTime[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] clear = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < N; j++) {
                clear[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        int[] ud = {0, -1, 1}; // down, diagonal left, diagonal right
        int minTime = -1;
        for (int k = 0; k < N; k++) {
            if (clear[0][k]) {
                Queue<Integer[]> nums = new LinkedList();
                Queue<Integer> layers = new LinkedList();
                nums.add(new Integer[]{0, k});
                layers.add(0);

                while (!nums.isEmpty()) {
                    Integer[] x = nums.poll(); // remove current position
                    int i = x[0], j = x[1];
                    int layer = layers.poll();

                    if (i == N - 1) {
                        if (minTime == -1) minTime = layer;
                        else minTime = Math.min(minTime, layer);
                        break;
                    }

                    // iterate through all positions x can go to
                    for (int a = 0; a < 3; a++) {
                        int r = i+1, c = j + ud[a];
                        if (r < N && c < N && c >= 0 && clear[r][c]) {
                            nums.add(new Integer[]{r, c});
                            if (a == 0) layers.add(layer + 1);
                            else layers.add(layer + 2);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            if (minTime < maxTime[i]) System.out.print(minTime + " ");
            else System.out.println(maxTime[i] - minTime + " ");
        }

    }
}

