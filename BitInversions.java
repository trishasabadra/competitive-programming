import java.io.*;
import java.util.*;

public class BitInversions { // start class

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

        String str = fin.readLine();
        int M = str.length();
        TreeMap<Integer, Integer> zero = new TreeMap<>(), one = new TreeMap<>(); // stores ranges of 0s and 1s inclusive
        multiset = new TreeMap<>(); // stores lengths of ranges
        for (int i = 0; i < M; i++) {
            int j = i;
            while (j < M-1 && str.charAt(j) == str.charAt(j+1)) {
                j++;
            }
            if (str.charAt(i) == '0') zero.put(i, j);
            else one.put(i, j);
            add(j-i+1);
            i = j;
        }

//        for (Integer i : zero.keySet()) {
//            System.out.println(i + ": " + zero.get(i));
//        }
//        System.out.println("one: ");
//        for (Integer i : one.keySet()) {
//            System.out.println(i + ": " + one.get(i));
//        }
//        System.out.println("map: ");
//        for (Integer i : multiset.keySet()) {
//            System.out.println(i + ": " + multiset.get(i));
//        }
//        System.out.println();

//        int N = 1;
//        String str = "001011";
//        TreeMap<Integer, Integer> zero = new TreeMap<>(), one = new TreeMap<>(); // stores ranges of 0s and 1s inclusive
//        zero.put(0, 1); zero.put(3, 3); one.put(2, 2); one.put(4, 5);
//        multiset = new TreeMap<>(); // stores lengths of ranges
//        multiset.put(1, 2); multiset.put(2, 2);

        int N = Integer.parseInt(fin.readLine());
        StringTokenizer st = new StringTokenizer(fin.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken())-1;
//            int a = 3;
            if (str.charAt(a) == '0') {
                Integer low = zero.floorKey(a), up = zero.get(low); // lower bound, upper bound
                // UPDATING ZERO
                //remove
                zero.remove(low);
                for (Integer j : multiset.keySet()) {
                    System.out.println(j + ": " + multiset.get(j));
                }
                remove(up-low+1);
                // add
                if (low <= a-1) {
                    zero.put(low, a-1);
                    add(a - low);
                }
                if (a+1 <= up) {
                    zero.put(a+1, up);
                    add(up - a);
                }
                // UPDATING ONE
                Integer low2 = one.lowerKey(a), up2 = -1, low3 = one.higherKey(a), up3 = -1; // left and right lower bound
                if (low2 != null) up2 = one.get(low2);
                if (low3 != null) up3 = one.get(low3);

                if (low2 != null && low3 != null && up2 == a-1 && low3 == a+1) { // 101 (zero is surrounded by 1s)
                    one.remove(low2);
                    remove(up2 - low2+1);

                    one.remove(low3);
                    remove(up3 - low3+1);
                    one.put(low2, up3);
                    add(up3-low2+1);
                }
                else if (low2 != null && up2 == a-1) {
                    one.remove(low2);
                    remove(up2 - low2+1);
                    one.put(low2, a);
                    add(a-low+1);
                }
                else if (low3 != null && low3 == a+1) {
                    one.remove(low3);
                    remove(up3 - low3+1);
                    one.put(a, up3);
                    add(up3-a+1);
                }
                else {
                    one.put(a, a);
                }
            }
            System.out.print(multiset.lastKey() + " ");
        }
    }
}
