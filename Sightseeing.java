import java.io.*;
import java.util.*;

public class Sightseeing { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int[] lr = {-1, 1, 0, 0}; // left, right
        int[] ud = {0, 0, -1, 1}; // up, down

        int N = Integer.parseInt(fin.readLine());
        int[] x = new int[N], y = new int[N];
        TreeMap<Integer, Integer> mapX = new TreeMap<>(), mapY = new TreeMap<>(); // orig point : compressed point
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            x[i] = Integer.parseInt(st.nextToken()); y[i] = Integer.parseInt(st.nextToken());
            mapX.put(x[i], 0);
            mapY.put(y[i], 0);
            for (int j = 0; j < 4; j++) {
                mapX.put(x[i]+lr[j], 0);
                mapY.put(y[i]+ud[j], 0);
            }
        }

        int index = 0;
        for (Integer key : mapX.keySet()) { // compress x coordinates
            mapX.put(key, index);
            index++;
        }
        index = 0;
        for (Integer key : mapY.keySet()) { // compress y coordinates
            mapY.put(key, index);
            index++;
        }

        for (int m = 0; m < N; m++) {
            Queue<Integer[]> nums = new LinkedList();
            Queue<Integer> layers = new LinkedList();
            nums.add(new Integer[]{x[m], y[m]});
            layers.add(0);
            int tx = x[(m+1)%N], ty = y[(m+1)%N];
            boolean[][] vis = new boolean[N][N];
            vis[x[m]][y[m]] = true;
            while (!nums.isEmpty()) {
                Integer[] b = nums.poll(); // remove current position
                int i = x[0], j = x[1];
                int layer = layers.poll();
                if (tx == i && ty == j) {

                }
                for (int a = 0; a < 4; a++) {
                    int r = i + lr[a], c = j + ud[a];
                    if (r < N && r >= 0 && c < N && c >= 0 && !vis[r][c]) {
                        vis[r][c] = true; // mark as visited
                        nums.add(new Integer[]{r, c});
                        layers.add(layer+1);
                    }
                }
            }
        }


    }
}
