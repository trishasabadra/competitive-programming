import java.io.*;
import java.util.*;

public class TreeHeights { // start class

    static int N, I, H, M;

    static TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
    public static void add(int key, int value) {
        TreeSet<Integer> temp = map.getOrDefault(key, new TreeSet<>());
        temp.add(value);
        map.put(key, temp);
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = Integer.parseInt(st.nextToken()); I = Integer.parseInt(st.nextToken())-1; H = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        int[] preSum = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;

            if (map.containsKey(a) && map.get(a).contains(b)) continue;

            preSum[Math.min(a, b)+1]--;
            preSum[Math.max(b, a)]++;
            add(a, b);
        }
        int cur = H;
        for (int i = 0; i < N; i++) {
            cur += preSum[i];
            System.out.println(cur);
        }
    }
}
