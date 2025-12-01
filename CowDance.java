import java.io.*;
import java.util.*;

public class CowDance { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fin = new BufferedReader(new FileReader("cowdance.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(fin.readLine());
        }

        // BINARY SEARCH ON SIZE
        int l = 1, r = N;
        while (l < r-1) {
            int m = (l + r) / 2;
            TreeMap<Integer, Integer> multiset = new TreeMap<>();
            multiset.put(0, m);
            boolean isValid = true;
            for (int i = 0; i < N; i++) {
                int j = multiset.firstKey();
                // remove an occurrence of j
                if (multiset.get(j) > 1) {
                    multiset.put(j, multiset.get(j)-1);
                }
                else multiset.remove(j);
                // add new
                multiset.put(j+arr[i], multiset.getOrDefault(j+arr[i], 0)+1);
                if (multiset.lastKey() > T) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) { // if it works, try smaller stage size
                r = m;
            }
            else l = m;
        }
//        System.out.println(r);

        out.println(r);
        out.close();
    }
}

/*
Solution:
1. Binary search for smallest possible sized stage
2.
 */