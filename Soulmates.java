import java.io.*;
import java.util.*;

public class Soulmates { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());

//            long c = a, d = b;

            long j = 0;
            TreeMap<Long, Long> map = new TreeMap<>();
            while (a >= 1) {
                map.put(a, j);
                if (a == 1) break;
                if (a % 2 == 1) a += 1;
                else a /= 2;
                j++;
            }

            long min = Long.MAX_VALUE;
            j = 0;
            while (b >= 1) {
                if (map.floorKey(b) != null) min = Math.min(min, map.get(map.floorKey(b))+j+(b-map.floorKey(b)));
                if (b % 2 == 1) b -= 1;
                else b /= 2;
                j++;
            }

            System.out.println(min);

            // SECOND SOLUTION
//            Queue<Long> nums = new LinkedList(), layers = new LinkedList();
//            TreeSet<Long> vis = new TreeSet<>();
//            nums.add(c); layers.add(0L);
//            vis.add(c);
//            while (!nums.isEmpty()) {
//                long x = nums.poll(), layer = layers.poll(); // remove current number and layer
//                if (x == d) {
//                    System.out.println(layer);
//                    break;
//                }
//                if (x*2 <= d*2 && !(x % 2 == 0 && x > d) && !vis.contains(x*2)) {
//                    nums.add(x*2); layers.add(layer+1);
//                    vis.add(x*2);
//                }
//                if (x % 2 == 0 && !vis.contains(x/2)) {
//                    nums.add(x/2); layers.add(layer+1);
//                    vis.add(x/2);
//                }
//                if ((x % 2 == 1 || x < d) && !vis.contains(x+1)) {
//                    nums.add(x+1); layers.add(layer+1);
//                    vis.add(x+1);
//                }
//            }
        }
    }
}

