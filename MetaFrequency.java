import java.io.*;
import java.util.*;

public class MetaFrequency { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int S = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> count = new TreeMap<>(); // player : # of times been late
        st = new StringTokenizer(fin.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken())-1;
            count.put(a, count.getOrDefault(a, 0)+1);
        }

//        int S = 4, N = 6;
//        TreeMap<Integer, Integer> count = new TreeMap<>(); // player : # of times been late
//        count.put(0, 2); count.put(1, 3); count.put(3, 1);

        TreeMap<Integer, Integer> preSum = new TreeMap<>(); // player : sum of # of time 0 -> player-1 have been late
        for (int player : count.keySet()) {
            if (preSum.isEmpty()) preSum.put(player, count.get(player));
            else preSum.put(player, preSum.get(preSum.lowerKey(player))+count.get(player));
        }

        TreeMap<Integer, Integer> map = new TreeMap<>(); // key : end index
        for (int player : preSum.keySet()) {
            map.put(preSum.get(player), player);
        }

        int Q = Integer.parseInt(fin.readLine());
        for (int i = 0; i < Q; i++) {
            int a = Integer.parseInt(fin.readLine());
            Integer ans = map.higherKey(a) == null ? S : map.get(map.higherKey(a));
            System.out.println(ans);
        }

    }
}
