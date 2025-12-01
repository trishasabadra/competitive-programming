
import java.io.*;
import java.util.*;

public class CrossRoad3 { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fin = new BufferedReader(new FileReader("countcross.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));


        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());
        boolean[][][] road = new boolean[N][N][4]; // {up, down, left, right}
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(fin.readLine());
            int r1 = Integer.parseInt(st.nextToken())-1, c1 = Integer.parseInt(st.nextToken())-1, r2 = Integer.parseInt(st.nextToken())-1, c2 = Integer.parseInt(st.nextToken())-1;
            if (r1 - 1 == r2) {  // up
                road[r1][c1][0] = true; road[r2][c2][1] = true;
            }
            else if (r1 + 1 == r2) { // down
                road[r1][c1][1] = true; road[r2][c2][0] = true;
            }
            else if (c1 + 1 == c2) { // right
                road[r1][c1][3] = true; road[r2][c2][2] = true;
            }
            else { // left
                road[r1][c1][2] = true; road[r2][c2][3] = true;
            }
        }

        boolean[][] hasCow = new boolean[N][N];
        int[] cowR = new int[K], cowC = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(fin.readLine());
            int r = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken())-1;
            hasCow[r][c] = true;
            cowR[i] = r; cowC[i] = c;
        }

        int[] ud = {-1, 1, 0, 0}, lr = {0, 0, -1, 1}; // up, down, left, right
        int count = 0;
        for (int k = 0; k < K-1; k++) {
            Queue<Integer[]> nums = new LinkedList();
            Queue<Integer> layers = new LinkedList();
            nums.add(new Integer[]{cowR[k], cowC[k]});
            layers.add(0);

            boolean[][] notDistant = new boolean[N][N], vis = new boolean[N][N];
            notDistant[cowR[k]][cowC[k]] = true;
            vis[cowR[k]][cowC[k]] = true;
            while (!nums.isEmpty()) {
                Integer[] x = nums.poll(); // remove current position
                int i = x[0], j = x[1];
                int layer = layers.poll();
                // up, down, left, right
                for (int a = 0; a < 4; a++) {
                    int r = i + ud[a], c = j + lr[a];
                    if (r < N && r >= 0 && c < N && c >= 0 && !road[i][j][a] && !vis[r][c]) {
                        notDistant[r][c] = true; // mark as not distant
                        vis[r][c] = true;
                        nums.add(new Integer[]{r, c});
                        layers.add(layer + 1);
                    }
                }
            }

            for (int j = k+1; j < K; j++) {
                if (!notDistant[cowR[j]][cowC[j]]) { // if cow k can't reach cow j without roads
                    count++;
                }
            }
        }
//        System.out.println(count);

        out.println(count);
        out.close();
    }
}

