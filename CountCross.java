import java.io.*;
import java.util.*;

public class CountCross { // start class

    static int N;
    static boolean[][] road, cow;
    static int[] counter;

    public static void floodfill(int r, int c, int i) {
        if (r >= 0 && r < N*2+1 && c >= 0 && c < N*2+1 && !road[r][c]) { // if row and col are in bounds and its not visited
            road[r][c] = true;
            if (cow[r][c]) {
                counter[i]++;
            }
            floodfill(r-1, c, i);
            floodfill(r+1, c, i);
            floodfill(r, c-1, i);
            floodfill(r, c+1, i);
        }
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

//        BufferedReader fin = new BufferedReader(new FileReader("countcross.in"));
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());

        road = new boolean[N*2+1][N*2+1];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(fin.readLine());
            int r1 = Integer.parseInt(st.nextToken())*2, c1 = Integer.parseInt(st.nextToken())*2;
            int r2 = Integer.parseInt(st.nextToken())*2, c2 = Integer.parseInt(st.nextToken())*2;
            road[r1][c1] = true;
            road[r2][c2] = true;
            road[(r1+r2)/2][(c1+c2)/2] = true;
        }

        int[][] pos = new int[K][2];
        cow = new boolean[N*2+1][N*2+1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(fin.readLine());
            int r = Integer.parseInt(st.nextToken())*2, c = Integer.parseInt(st.nextToken())*2;
            pos[i][0] = r; pos[i][1] = c;
            cow[r][c] = true;
            road[r][c] = false;
        }

        for (int i = 0; i < road.length; i++) {
            for (int j = 0; j < road.length; j++) {
                if (road[i][j]) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }

        counter = new int[K];
        int ans = 0;
        for (int i = 0; i < K; i++) {
            floodfill(pos[i][0], pos[i][1], i);
            K -= counter[i];
            ans += counter[i] * K;
        }

        System.out.println(ans);
//        out.println(ans);
//        out.close();

//        int N = 5, K = 2, R = 2;
//        boolean[][] road = new boolean[N][N];
//        road[4][1] = true; road[4][2] = true;
//        int[][] pos = {{0, 3}, {3, 1}};

//        int[] lr = {-1, 1, 0, 0}; // left, right
//        int[] ud = {0, 0, -1, 1}; // up, down
//        int counter = 0;
//        for (int m = 0; m < K; m++) { // bfs on every cow to find other cows
//            int[][] ans = new int[N][N];
//            for (int a = 0; a < N;   a++) {
//                Arrays.fill(ans[a], R);
//            }
//            boolean[][] vis = new boolean[N][N];
//            Queue<Integer[]> nums = new LinkedList();
//            Queue<Integer> roads = new LinkedList();
//            nums.add(new Integer[]{pos[m][0], pos[m][1]});
//            roads.add(0);
//            vis[pos[m][0]][pos[m][1]] = true;
//
//            while (!nums.isEmpty()) {
//                Integer[] x = nums.poll(); // remove current position
//                int i = x[0], j = x[1]; // current coordinates
//                int layer = roads.poll();
//                ans[i][j] = Math.min(ans[i][j], layer);
//                // iterate through all positions x can go to
//                for (int a = 0; a < 4; a++) {
//                    int r = i + lr[a], c = j + ud[a]; // new coordinates
//                    if (r < N && r >= 0 && c < N && c >= 0) {
//                        if (!vis[r][c] || road[r][c] && road[i][j] && layer+1 < ans[r][c] || (!road[r][c] || !road[i][j]) && layer < ans[r][c]) { // if the position is not visited yet
//                            vis[r][c] = true; // mark as visited
//                            nums.add(new Integer[]{r, c});
//
//                            if (road[r][c] && road[i][j]) roads.add(layer+1);
//                            else roads.add(layer);
//                        }
//                    }
//                }
//            }

//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(ans[i][j] + " ");
//                }
//                System.out.println();
//            }

//            for (int i = m+1; i < K; i++) {
//                if (ans[pos[i][0]][pos[i][1]] > 0) counter++;
//            }
//        }
//        System.out.println(counter);
//        out.println(counter);
//        out.close();
    }
}

//        20 2 2
//        17 4 17 5
//        9 15 8 15
//        2 15
//        13 4

/*
 6 5
2 1 2 2
2 2 1 2
2 2 2 3
2 2 3 2
2 3 1 3
1 3 1 4
1 1
2 2
1 3
3 3
4 2
 */