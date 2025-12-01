import java.io.*;
import java.util.*;

public class Harvest { // start class

    static int max = 0, K, N;

    static ArrayList<TreeSet<Integer>> sets = new ArrayList<>();
    static public void combinations(TreeSet<Integer> set) {
        sets.add(set);
        for (int i = set.last(); i < N; i++) {
            if (!set.contains(i)) {
                TreeSet<Integer> temp = (TreeSet<Integer>) set.clone();
                temp.add(i);
                combinations(temp);
            }
        }
    }

//    static TreeMap<Integer, Integer> multiset;
//    // ADD FUNCTION FOR MULTISET (adds one occurrence of a number)
//    public static void add(int i) {
//        multiset.put(i, multiset.getOrDefault(i, 0)+1);
//    }
//    // REMOVE FUNCTION FOR MULTISET (removes one occurrence of a number)
//    public static void remove(int i) {
//        multiset.put(i, multiset.get(i)-1);
//        if (multiset.get(i) == 0) multiset.remove(i);
//    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(fin.readLine());
        }

        sets.add(new TreeSet<>());
        for (int i = 0; i < N; i++) {
            TreeSet<Integer> t = new TreeSet<>();
            t.add(i);
            combinations(t);
        }

        System.out.println(max);

//        for (int i : arr) {
//            TreeSet<Integer> temp = new TreeSet<>();
//            temp.add(i);
//            combinations(temp, i);
//        }
//        System.out.println(max);

//        int N = 4, K = 23;
//        int[] arr = {2, 5, 8, 14};

//        int max = arr[0];
//        long iterations = 0;
//        TreeSet<Integer> sums = new TreeSet<>();
//        for (int i = 0; i < N; i++) { // current list
//            TreeSet<Integer> temp = new TreeSet<>();
//            temp.add(arr[i]);
//            for (int k : sums) { // numbers in lists before
//                iterations++;
//                if (arr[i]+k <= K) {
//                    max = Math.max(max, arr[i]+k);
//                    temp.add(arr[i] + k);
//                }
//                else break;
//            }
//            sums.addAll(temp);
//        }
//        System.out.println(max);
//        System.out.println(iterations);

//        int max = 0;
//        for (int i = N-1; i >= 0; i--) {
//
//            multiset = new TreeMap<>();
//            for (int j = 0; j < N; j++) {
//                add(arr[j]);
//            }
//
//            int sum = arr[i], k = K-sum;
//            remove(arr[i]);
//            while (k > 0) {
//                Integer j = multiset.floorKey(k);
//                if (j == null) break;
//                sum += j;
//                k -= j;
//                remove(j);
//            }
//            if (k > 0) max = Math.max(max, sum);
//        }
//        System.out.println(max);
    }
}
