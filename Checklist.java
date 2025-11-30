import java.io.*;
import java.util.*;

public class Checklist { // start class

    public static int dist (int x1, int y1, int x2, int y2) {
        return (int) (Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int H = Integer.parseInt(st.nextToken()), G = Integer.parseInt(st.nextToken());

        int[] hx = new int[H], hy = new int[H];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(fin.readLine());
            hx[i] = Integer.parseInt(st.nextToken()); hy[i] = Integer.parseInt(st.nextToken());
        }

        int[] gx = new int[G+1], gy = new int[G+1];
        for (int i = 1; i <= G; i++) {
            st = new StringTokenizer(fin.readLine());
            gx[i] = Integer.parseInt(st.nextToken()); gy[i] = Integer.parseInt(st.nextToken());
        }

//        int H = 3, G = 2;
//        int[] hx = {0, 1, 2}, hy = {0, 0, 0}, gx = {0, 0, 1}, gy = {0, 3, 3};

//        int H = 2, G = 3;
//        int[] hx = {0, 1}, hy = {0, 0}, gx = {0, 2, 0, 1}, gy = {0, 0, 3, 3};

//        int H = 3, G = 3;
//        int[] hx = {0, 1, 2}, hy = {0, 0, 0}, gx = {0, 0, 1, 2}, gy = {0, 3, 3, 1};

        int[][][] dp = new int[H][G+1][2]; // dp[i][j][0,1] = min dist with i holsteins and j guernseys and the current cow (0 = h, 1 = g)
        for (int h = 0; h < H; h++) {
            for (int g = 0; g <= G; g++) {
                // at cow h, already visited h-1 cows and g cows
                if (h == 1 && g > 0) dp[h][g][0] = dp[h - 1][g][1] + dist(hx[h], hy[h], gx[g], gy[g]); // if 2 h, must come from cur g
                else if (h > 0 && g == 0) dp[h][g][0] = dp[h - 1][g][0] + dist(hx[h], hy[h], hx[h - 1], hy[h - 1]); // if 0 g, must come from prev h
                else if (h > 1 && g > 0) dp[h][g][0] = Math.min(dp[h - 1][g][0] + dist(hx[h], hy[h], hx[h - 1], hy[h - 1]), dp[h - 1][g][1] + dist(hx[h], hy[h], gx[g], gy[g])); // min (came from prev h, came from cur g)

                // at cow g, already visited h cows and g-1 cows
                if (g == 1) dp[h][g][1] = dp[h][g - 1][0] + dist(hx[h], hy[h], gx[g], gy[g]); // if 1 g, must come from cur h
                else if (g > 0 && h > 0) dp[h][g][1] = Math.min(dp[h][g - 1][1] + dist(gx[g], gy[g], gx[g - 1], gy[g - 1]), dp[h][g - 1][0] + dist(hx[h], hy[h], gx[g], gy[g])); // min (came from prev g, came from cur h)
                else if (g > 0) dp[h][g][1] = dp[h][g - 1][1] + dist(gx[g], gy[g], gx[g - 1], gy[g - 1]); // if 1 h, must come from previous g
            }
        }
        System.out.println(dp[H-1][G][0]);
    }
}
