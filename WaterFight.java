import java.io.*;
import java.util.*;

public class WaterFight { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        long[] height = new long[N];
        int[] power = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            height[i] = Long.parseLong(st.nextToken());
            power[i] = Integer.parseInt(st.nextToken());
        }

        // left to right
        Stack<Integer> cows = new Stack<>();
        long[] ans = new long[N];
        for (int i = 0; i < N; i++) {
            while (!cows.isEmpty() && height[cows.peek()] <= height[i]) {
                cows.pop();
            }
            if (!cows.isEmpty()) {
                ans[cows.peek()] += power[i];
            }
            cows.add(i);
        }

        // right to left
        cows = new Stack<>();
        for (int i = N-1; i >= 0; i--) {
            while (!cows.isEmpty() && height[cows.peek()] <= height[i]) {
                cows.pop();
            }
            if (!cows.isEmpty()) {
                ans[cows.peek()] += power[i];
            }
            cows.add(i);
        }

        Arrays.sort(ans);
        System.out.println(ans[N-1]);
    }
}

