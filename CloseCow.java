import java.io.*;
import java.util.*;

public class CloseCow { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int K = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());

        // fields
        int[][] arr = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            arr[i][0] = a; arr[i][1] = b;
        }
        Arrays.sort(arr, (a,b)->(int)(a[0] - b[0])); // sorts based on position in ascending order

        // other cows
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(fin.readLine());
            set.add(a);
        }



//        int K = 6, M = 5, N = 2;
//        int[][] arr = {{0, 4}, {4, 6}, {8, 10}, {10, 8}, {12, 12}, {13, 14}};
//        TreeSet<Integer> set = new TreeSet<>();
//        set.add(2); set.add(3); set.add(5); set.add(7); set.add(11);

        // fields
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            ArrayList<Integer> fields = new ArrayList<>(); // fields one cow can take
            int lower = set.lower(arr[i][0]) == null ? -1*arr[K-1][0] : set.lower(arr[i][0]); // lower cow
            while (i < K-1 && (set.higher(arr[i][0]) == null || set.higher(arr[i][0]) > arr[i+1][0])) { // while there is no cow between both fields
                fields.add(arr[i][1]);
                i++;
            }
            Integer higher = set.higher(arr[i+1][0]);
            if (higher == null || arr[i+1][0]-(arr[i][0]-lower) <= higher - arr[i+1][0]) {
                fields.add(arr[i+1][1]);
                i++;
            }
            groups.add(fields);
        }

        long[] ans = new long[groups.size()];
        for (int a = 0; a < groups.size(); a++) {
            for (int i : groups.get(a)) {
                ans[a] += i;
            }
        }
        Arrays.sort(ans);

        long answer = 0;
        for (int i = ans.length-1; i >= ans.length-N; i--) {
            answer += ans[i];
        }
        System.out.println(answer);
    }
}
