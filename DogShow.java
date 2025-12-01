import java.io.*;
import java.util.*;

public class DogShow { // start class

    static TreeMap<Long, Integer> multiset;
    // ADD FUNCTION FOR MULTISET (adds one occurrence of a number)
    public static void add(long i) {
        multiset.put(i, multiset.getOrDefault(i, 0)+1);
    }
    // REMOVE FUNCTION FOR MULTISET (removes one occurrence of a number)
    public static void remove(long i) {
        multiset.put(i, multiset.get(i)-1);
        if (multiset.get(i) == 0) multiset.remove(i);
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        TreeSet<Long> all = new TreeSet<>();
        long[][] arr = new long[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            arr[i][0] = Long.parseLong(st.nextToken()); arr[i][1] = Long.parseLong(st.nextToken());
            all.add(arr[i][1]);
        }
        Arrays.sort(arr, (a,b)->(int)(a[0] - b[0])); // sorts based on first column in ascending order

//        int N = 6;
//        long[][] arr = {{14, 1}, {19, 1}, {21, 2}, {24, 5}, {25, 1}, {29, 1}};
//        all.add(1L); all.add(2L); all.add(5L);

        long min = arr[N-1][0];
        multiset = new TreeMap<>();
        int right = 0;
        for (int left = 0; right < N;) {
            while (right < N && multiset.size() != all.size()) {
                add(arr[right][1]);
                right++;
            }
            while (left < right-1 && multiset.size() == all.size()) {
                remove(arr[left][1]);
                left++;
            }
            min = Math.min(min, arr[right-1][0] - arr[left-1][0]);
        }
        System.out.println(min);
    }
}
