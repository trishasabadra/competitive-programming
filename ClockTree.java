import java.io.*;
import java.util.*;

public class ClockTree { // start class

    static ArrayList<Integer>[] adj;
    static boolean isPossible = false;

    public static void dfs(int num, int[] arr) {
        if (isDone(arr)) {
            isPossible = true;
            return;
        }
        for (int n : adj[num]) {
            if (arr[num] > 0 && arr[n] > 0) {
                arr[n]--;
                dfs(n, arr);
            }
        }
    }

    public static boolean isDone(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(fin.readLine());
//        StringTokenizer st = new StringTokenizer(fin.readLine());
//        int[] arr = new int[N];
//        for (int i = 0; i < N; i++) {
//            arr[i] = 12 - Integer.parseInt(st.nextToken());
//        }

        int N = 4; int[] arr = {1, 2, 1, 1};

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

//        for (int i = 0; i < N-1; i++) {
//            st = new StringTokenizer(fin.readLine());
//            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
//            adj[a].add(b);
//            adj[b].add(a);
//        }

        adj[0].add(1); adj[1].add(0); adj[2].add(1); adj[1].add(2); adj[3].add(1); adj[1].add(3);

        int counter = 0;
        for (int i = 1; i < N; i++) { // iterates through all possible roots of tree
            dfs(i, arr);
            if (isPossible) counter++;
        }

        System.out.println(counter);
    }
}
