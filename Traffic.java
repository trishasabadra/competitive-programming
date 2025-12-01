import java.io.*;
import java.util.*;

public class Traffic { // start class

    static TreeMap<Integer, Integer> multiset;
    public static void add(int i) {
        multiset.put(i, multiset.getOrDefault(i, 0)+1);
    }
    public static void remove(int i) {
        multiset.put(i, multiset.get(i)-1);
        if (multiset.get(i) == 0) multiset.remove(i);
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> range = new TreeMap<>();
        multiset = new TreeMap<>();
        range.put(0, N); multiset.put(N, 1);

        st = new StringTokenizer(fin.readLine());
        for (int i = 0; i < K; i++) {
            int a = Integer.parseInt(st.nextToken());
            int low = range.lowerKey(a), up = range.get(low); // lower bound, upper bound
            //remove
            range.remove(low);
            remove(up-low);
            // add
            range.put(low, a);
            range.put(a, up);
            add(a-low);
            add(up-a);

            System.out.print(multiset.lastKey() + " ");
        }
    }
}
