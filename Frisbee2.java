import java.io.*;
import java.util.*;

public class Frisbee2 { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        StringTokenizer st = new StringTokenizer(fin.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        int N = 7;
//        int[] arr = {7, 6, 5, 4, 3, 1, 2};

//        long start = System.currentTimeMillis();
//        // generate input
//        int[] arr = new int[N];
//        for (int i = 0; i < N; i++) arr[i] = i+1;
//        for (int i = 0; i < N; i++) {
//            int r1 = (int) (Math.random() * (N-1)), r2 = (int) (Math.random() * (N-1));
//            int j = arr[r1];
//            arr[r1] = arr[r2];
//            arr[r2] = j;
//        }

        TreeSet<Integer> pos = new TreeSet<>(); // stores indexes of current lows
        for (int i = 1; i < N-1; i++) {
            if (arr[i+1] > arr[i] && arr[i-1] > arr[i]) {
                pos.add(i);
            }
        }

        int count = 0;
        long sum = 2L * (N-1);
        for (int i : pos) {
            int l = i-1, r = i+1;
            TreeSet<Integer> set = new TreeSet<>();
            while (l >= 0 && arr[l] > arr[l+1]) {
                while (true) {
                    count++;
                    if (set.higher(arr[r]) == null) { // if range is valid
                        // System.out.println(arr[l] + " " + arr[r]);
                        sum += r - l + 1;
                    }
                    set.add(arr[r]);
                    if (arr[r] > arr[l] || r == N-1) break; // if reached end of array or hit bigger number
                    r++;
                }
                set.add(arr[l]);
                l--;
            }
        }
        System.out.println(sum);
        // System.out.println(count);
//        long end = System.currentTimeMillis();
//        System.out.println((end-start)/1000.0);
    }
}

