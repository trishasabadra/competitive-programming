import java.io.*;
import java.util.*;

public class CutEmAll { // start class

    static boolean[] vis;
    static ArrayList<Integer>[] adj;
    static int[] degree;
    static int count = -1;

    public static void dfs(int num) {
        vis[num] = true;
        for (int n : adj[num]) {
            if (!vis[n]) {
                dfs(n);
                degree[num] += degree[n];
            }
        }
        if (degree[num] % 2 == 0) {
            // System.out.println(num+1 + " " + degree[num]);
            count++;
            degree[num] = 0;
        }
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
            adj[a].add(b);
            adj[b].add(a);
        }

        if (N % 2 == 1) {
            System.out.println(-1);
            System.exit(0);
        }

        degree = new int[N];
        Arrays.fill(degree, 1);
        vis = new boolean[N];
        dfs(0);
        System.out.println(count);

    }
}
