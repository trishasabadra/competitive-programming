import java.io.*;
import java.util.*;

public class BerryPicking { // start class

    static TreeMap<Integer, Integer> multiset;
    // ADD FUNCTION FOR MULTISET (adds j occurrences of a number)
    public static void add(int i, int j) {
        if (j < 1) {
            multiset.put(i, multiset.getOrDefault(i, 0) + j);
        }
    }

    // REMOVE FUNCTION FOR MULTISET (removes one occurrence of a number)
    public static void remove(int i) {
        multiset.put(i, multiset.get(i)-1);
        if (multiset.get(i) == 0) multiset.remove(i);
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
//
////        BufferedReader fin = new BufferedReader(new FileReader("berries.in"));
////        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
//
//        StringTokenizer st = new StringTokenizer(fin.readLine());
//        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
//        int[] arr = new int[N];
////        multiset = new TreeMap<>(Collections.reverseOrder());
//        st = new StringTokenizer(fin.readLine());
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
////            add(arr[i], 1);
//        }
//        Arrays.sort(arr);

        int N = 6, K = 4;
        int[] arr = {2, 4, 7, 10, 18, 19};

        int max = 0;
        for (int i = N-1; i >= 0; i--) {
            multiset = new TreeMap<>(Collections.reverseOrder());
            for (int j = N-1; j >= i; j--) {
                if (Math.round((double) arr[j]/arr[i]) > 1) {
                    int a = arr[j]/(arr[j]/arr[i]);
                    add(a+1, arr[j]%a);
                    add(a, arr[j]/arr[i] - arr[j]%a);
                }
                else {
                    add(arr[j], 1);
                }
            }

            int sum = 0, counter = 0;
            for (Integer key : multiset.keySet()) {
                for (int j = 0; j < multiset.get(key); j++) {
                    if (counter >= K) break;
                    if (K/2 <= counter) sum += key;
                    counter++;
                }
            }
            int k = i;
            while (k >= 0 && counter < K) {
                if (counter > K/2) sum += arr[k];
                counter++;
                k--;
            }
            max = Math.max(sum, max);
        }
        System.out.println(max);

//        out.println(max);
//        out.close();
    }
}
