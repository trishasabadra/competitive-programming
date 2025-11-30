import java.io.*;
import java.util.*;

public class Proco2022 { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(fin.readLine());
//        StringTokenizer st = new StringTokenizer(fin.readLine());
//        TreeMap<Integer, Integer> pos = new TreeMap<>();
//        for (int i = 0; i < N; i++) {
//            pos.put(Integer.parseInt(st.nextToken()), i);
//        }

        int N = 6;
        TreeMap<Integer, Integer> pos = new TreeMap<>();
        pos.put(0, 0); pos.put(2, 1); pos.put(6, 2); pos.put(9, 3); pos.put(14, 4); pos.put(20, 5);

        Queue<Integer> nums = new LinkedList(), layers = new LinkedList(), length = new LinkedList<>();
        for (int i = 1; i <= 3; i++) {
            if (pos.containsKey(pos.firstKey()+i)) { nums.add(pos.firstKey()+i); layers.add(1); length.add(i); }
        }

        int[] a = {-2, -1, 1, 2};
        boolean[][] vis = new boolean[N][5000]; // position speed
        while (!nums.isEmpty()) {
            int x = nums.poll(), layer = layers.poll(), len = length.poll();
            if (x == pos.lastKey()) {
                System.out.println(layer); System.exit(0);
            }
            for (int n : a) { // iterate through all neighbors of x
                int y = x+(len+n);
                // System.out.println(len-n);
                if (y > x && pos.containsKey(y) && !vis[pos.get(y)][len-n]) { // if the number is not visited yet
                    nums.add(y); layers.add(layer+1); length.add(len-n);
                    vis[pos.get(y)][len-n] = true;
                }
            }
        }
        System.out.println(-1);

    }
}
