import java.io.*;
import java.util.*;

public class SonicGrid { // start class

    static int[] lr = {-1, 1, 0, 0}, ud = {0, 0, -1, 1}; // north, south, west, east
    static int N, M;
    static boolean[][] clear;
    static boolean[][][][] minSpeed;
//    static boolean[][] clear = {{true, false},{true, true}, {false, true}, {true, true}};
    static Queue<Integer[]> nums = new LinkedList();
    static Queue<Integer> times = new LinkedList(), speeds = new LinkedList<>(), dir = new LinkedList<>();
    static Queue<Boolean> cDir = new LinkedList<>(); // changed direction or not

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        clear = new boolean[N][M]; // true if no civilian, false if there is a civilian
        for (int i = 0; i < N; i++) {
            String in = fin.readLine();
            for (int j = 0; j < M; j++) {
                clear[i][j] = Integer.parseInt(in.substring(j, j+1)) == 0;
            }
        }

//        N = 4; M = 2;

        nums.add(new Integer[]{0, 0}); times.add(0); speeds.add(0); cDir.add(false); dir.add(1);
        minSpeed = new boolean[N][M][(int) Math.sqrt(2*Math.max(N, M))+1][4];
        while (!nums.isEmpty()) {
            Integer[] x = nums.poll(); // remove current position
            int i = x[0], j = x[1];
            int time = times.poll(), speed = speeds.poll(), d = dir.poll(); 
            boolean b = cDir.poll();
            minSpeed[i][j][speed][d] = true;

            if (i == N-1 && j == M-1) {
                System.out.println(time);
                System.exit(0);
            }
            
            // direction change
            if (speed == 0 && !b) { // can change direction if speed = 0, and hasn't just changed direction
                for (int a = 0; a < 4; a++) {
                    int r = i + lr[a], c = j + ud[a];
                    if (d != a && r < N && r >= 0 && c < M && c >= 0 && clear[r][c] && !minSpeed[r][c][0][a]) { // if different direction, in bounds, and spot is clear
                        nums.add(new Integer[]{i, j});
                        times.add(time + 1); speeds.add(0); dir.add(a); cDir.add(true);
                    }
                }
            }

            // accelerate
            if (speed <= (int) Math.sqrt(2*Math.max(N, M))) allClear(i, j, speed+1, d, time);

            // decelerate
            if (speed > 0) allClear(i, j, speed-1, d, time);
        }
        System.out.println(-1);
    }

    public static void allClear(int i, int j, int speed, int d, int time) {
        int r = i + lr[d]*speed, c = j + ud[d]*speed;
        if (r < N && r >= 0 && c < M && c >= 0 && clear[r][c] && !minSpeed[r][c][speed][d]) {
            boolean allClear = true;
            for (int s = 1; s < speed; s++) {
                if (!clear[i + lr[d]*s][j + ud[d]*s]) {
                    allClear = false; break;
                }
            }
            if (allClear) {
                nums.add(new Integer[]{r, c});
                times.add(time + 1); speeds.add(speed); dir.add(d); cDir.add(false);
                // clear[r][c] = false;
            }
        }
    }
}

