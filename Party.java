import java.io.*;
import java.util.*;

public class Party { // start class

    static boolean[] vis;
    static ArrayList<Integer>[] adj;
    static TreeSet<Integer> curComp;
    public static void dfs(int num) {
        if (!vis[num]) {
            vis[num] = true;
            curComp.add(num);
            for (int n : adj[num]) {
                dfs(n);
            }
        }
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken()); // nodes, edges, queries

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
            adj[a].add(b);
            adj[b].add(a);
        }

        vis = new boolean[N];
        ArrayList<TreeSet<Integer>> comps = new ArrayList<>(); // connected components
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                curComp = new TreeSet<>();
                dfs(i);
                comps.add(curComp);
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
            for (TreeSet<Integer> j : comps) {
                if (j.contains(a) && j.contains(b)) {
                    System.out.println("Y"); break;
                }
                else if (j.contains(a) || j.contains(b)) {
                    System.out.println("N"); break;
                }
            }
        }

    }
}
