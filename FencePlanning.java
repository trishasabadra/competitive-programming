import java.io.*;
import java.util.*;

public class FencePlanning { // start class

    static boolean[] vis;
    static ArrayList<Integer>[] adj;
    static int[] x, y;
    static int maxX, minX, maxY, minY;
    public static void dfs(int num) {
        if (!vis[num]) {
            maxX = Math.max(maxX, x[num]); minX = Math.min(minX, x[num]);
            maxY = Math.max(maxY, y[num]); minY = Math.min(minY, y[num]);

            vis[num] = true;
            for (int n : adj[num]) {
                dfs(n);
            }
        }
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fin = new BufferedReader(new FileReader("fenceplan.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        x = new int[N]; y = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(fin.readLine());
            x[i] = Integer.parseInt(st.nextToken()); y[i] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList[N];
        for (int j = 0; j < N; j++) {
            adj[j] = new ArrayList<>();
        }
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
            adj[a].add(b);
            adj[b].add(a);
        }

        vis = new boolean[N];
        int minPer = 400000000;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                maxX = x[i]; minX = x[i]; maxY = y[i]; minY = y[i];
                dfs(i);
                minPer = Math.min(minPer, 2*(maxX-minX)+2*(maxY-minY));
            }
        }
        out.println(minPer);
        out.close();
    }
}

