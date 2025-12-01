import java.io.*;
import java.util.*;

public class CatchPokemon { // start class

    static TreeMap<Character, Integer> multiset;
    // ADD FUNCTION FOR MULTISET (adds one occurrence of a number)
    public static void add(char i) {
        multiset.put(i, multiset.getOrDefault(i, 0)+1);
    }
    // REMOVE FUNCTION FOR MULTISET (removes one occurrence of a number)
    public static void remove(char i) {
        multiset.put(i, multiset.get(i)-1);
        if (multiset.get(i) == 0) multiset.remove(i);
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        char[] in = fin.readLine().toCharArray();
//        int N = 6; char[] in = "AaAaab".toCharArray();

        TreeSet<Character> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            set.add(in[i]);
        }

        int l = set.size(), r = N;
        while (l < r) {
            int m = (l+r)/2;
            // System.out.println(m);
            // sliding window
            multiset = new TreeMap<>();
            int i = 0;
            while (i < m && multiset.size() < set.size()) {
                add(in[i]);
                i++;
            }
            while (i < N && multiset.size() < set.size()) {
                remove(in[i-m]);
                add(in[i]);
                i++;
            }
            // binary search
            if (multiset.size() == set.size()) r = m;
            else l = m+1;
        }
        System.out.println(r);
    }
}
