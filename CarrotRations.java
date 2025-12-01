import java.io.*;
import java.util.*;

public class CarrotRations { // start class

    static TreeSet<Integer>[] adj;
    static ArrayList<Integer>[] observe;
    static int N, M;

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        observe = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            observe[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                observe[i].add(Integer.parseInt(st.nextToken())-1);
            }
        }

        // binary search on how many observation going to be used
        ArrayList<Integer> ans = new ArrayList<>();
        int l = 0, r = N-1;
        while (l <= r) {
            int m = (l+r) / 2;

            // create adj graph
            adj = new TreeSet[N];
            for (int i = 0; i < N; i++) {
                adj[i] = new TreeSet<>();
            }
            int[] degree = new int[N];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j < observe[i].size()-1; j++) {
                    adj[observe[i].get(j)].add(observe[i].get(j+1));
                    degree[observe[i].get(j+1)]++;
                }
            }

            // create ordering
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                if (degree[i] == 0) {
                    q.add(i);
                }
            }
            ArrayList<Integer> order = new ArrayList<>();
            while (!q.isEmpty()) {
                int x = q.poll(); // remove current number
                order.add(x);
                for (int n : adj[x]) { // iterate through all neighbors of x
                    degree[n]--;
                    if (degree[n] == 0) q.add(n);
                }
            }
            if (order.size() == N) { // if there are no cycles
                System.out.println(m);
                l = m+1;
                ans = (ArrayList<Integer>) order.clone();
            }
            else r = m-1;
        }

        for (int i : ans) {
            System.out.print(i+1 + " ");
        }
    }
}
