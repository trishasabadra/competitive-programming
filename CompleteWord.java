import java.io.*;
import java.util.*;

public class CompleteWord { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int W = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken()); // words, queries

        String3[] words = new String3[W];
        for (int i = 0; i < W; i++) {
            words[i] = new String3(fin.readLine(), i+1);
        }
        Arrays.sort(words);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(fin.readLine());
            int k = Integer.parseInt(st.nextToken());
            String x = st.nextToken();

            // lower bound
            int l = 0, r = W - 1; // left, right
            while (l <= r-1) {
                int m = (r + l) / 2; // middle
//                System.out.println(words[m].s);
                if (x.compareTo(words[m].s) <= 0) {
                    r = m;
                }
                else {
                    l = m+1;
                }
            }

            if (r+k-1 < W && words[r+k-1].s.length() >= x.length() && words[r+k-1].s.substring(0, x.length()).equals(x)) {
                System.out.println(words[r+k-1].i);
            }
            else {
                System.out.println(-1);
            }
        }
    }
}

class String3 implements Comparable<String3> {
    String s;
    int i;
    public String3(String s, int i) { // constructor
        this.s = s;
        this.i = i;
    }
    public int compareTo(String3 o) { // sorting method
        return s.compareTo(o.s);
    }
}

