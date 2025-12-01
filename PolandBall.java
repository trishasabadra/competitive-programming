import java.io.*;
import java.util.*;

public class PolandBall { // start class

    static ArrayList<Integer>[] adj;
    static boolean[] vis;

    public static void dfs(int num) {
        vis[num] = true;
        for (Integer n : adj[num]) {
            if (!vis[n]) {
                dfs(n);
            }
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
        StringTokenizer st = new StringTokenizer(fin.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken())-1;
            adj[i].add(a);
            adj[a].add(i);
        }

        int counter = 0;
        vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                dfs(i);
                counter++;
            }
        }
        System.out.println(counter);
    }
}
