import java.io.*;
import java.util.*;

public class DanceMooves { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
//        int N = 5, K = 4;
        TreeSet<Integer>[] pos = new TreeSet[N]; // stores positions each cow has visited
        int[][] arr = new int[K][2]; // switches
//        int[][] arr = {{0,2}, {0, 1}, {1, 2}, {1, 3}};
        int[] swap = new int[N];
        for (int i = 0; i < N; i++) {
            swap[i] = i;
            pos[i] = new TreeSet<>();
            pos[i].add(i);
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(fin.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken())-1;
            arr[i][1] = Integer.parseInt(st.nextToken())-1;
        }

        while (true) {
            boolean isDone = true;
            for (int i = 0; i < K; i++) {
                int a = swap[arr[i][0]], b = swap[arr[i][1]]; // cows being swapped
                if (!pos[a].contains(arr[i][1]) || !pos[b].contains(arr[i][0])) {
                    isDone = false;
                    pos[a].add(arr[i][1]); pos[b].add(arr[i][0]);
                }
                swap[arr[i][0]] = b;
                swap[arr[i][1]] = a;
            }
            if (isDone) break;
        }

        for (TreeSet<Integer> set : pos) {
            System.out.println(set.size());
        }
    }
}
