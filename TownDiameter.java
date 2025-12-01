import java.io.*;
import java.util.*;

public class TownDiameter { // start class

    static ArrayList<Integer> comp; // current connected component
    static boolean[] vis;
    static ArrayList<Integer>[] adj;
    public static void dfs(int num) {
        if (!vis[num]) {
            vis[num] = true;
            comp.add(num);
            for (int n : adj[num]) {
                dfs(n);
            }
        }
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        int[] x = new int[N], y = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            x[i] = Integer.parseInt(st.nextToken()); y[i] = Integer.parseInt(st.nextToken());
        }

        double[][] arr = new double[N][N];
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    arr[i][j] = Math.sqrt(Math.pow(x[i]-x[j], 2) + Math.pow(y[i]-y[j], 2));
                    adj[i].add(j);
                }
                else arr[i][j] = -1;
            }
        }

        // creating connected components
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                comp = new ArrayList<>();
                dfs(i);
                comps.add(comp);
            }
        }

        // floyd-warshall
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] != -1 && arr[i][k] != -1 && arr[k][j] != -1)
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        // finding max path for every node
        double[] max = new double[N];
        for (int i = 0; i < N; i++) {
            double m = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != -1)
                    m = Math.max(m, arr[i][j]);
            }
            max[i] = m;
        }


    }
}
/*
1. floyd-warshall on every group
2. F
 */

