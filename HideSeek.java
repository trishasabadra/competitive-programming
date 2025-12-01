
import java.io.*;
import java.util.*;

public class HideSeek { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        Queue<Integer> nums = new LinkedList(), layers = new LinkedList();
        HashSet<Integer> vis = new HashSet<>();
        nums.add(N); layers.add(0);

        if (N > K) {
            System.out.println(N-K);
            System.exit(0);
        }

        while (!nums.isEmpty()) {
            int x = nums.poll(), layer = layers.poll(); // remove current number and layer
            if (x == K) { // if done
                System.out.println(layer);
                System.exit(0);
            }
            vis.add(x);
            if (!vis.contains(x + 1)) { // +1
                nums.add(x + 1);
                layers.add(layer + 1);
            }
            if (x - 1 > 0 && !vis.contains(x - 1)) { // -1
                nums.add(x - 1);
                layers.add(layer + 1);
            }
            if ((x * 2 <= K || x * 2 - K <= Math.abs(K - x)) && !vis.contains(x * 2)) { // *2
                nums.add(x * 2);
                layers.add(layer + 1);
            }
        }
    }
}
