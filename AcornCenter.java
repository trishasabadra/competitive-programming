import java.io.*;
import java.util.*;

public class AcornCenter { // start class

    static ArrayList<Integer[]>[] to;
    static ArrayList<Integer>[] from;
    static boolean[] vis;
    static int[] dist;

    public static void dfs(Integer num) {
        vis[num] = true;
        for (Integer[] n : to[num]) {
            if (!vis[n[0]] || dist[num]+n[1] > dist[n[0]]) {
                dist[n[0]] = Math.max(dist[num] + n[1], dist[n[0]]);
                from[n[0]].remove(num);
                if (from[n[0]].isEmpty()) dfs(n[0]);
            }
        }
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken()); // # of nodes, days, edges
        st = new StringTokenizer(fin.readLine());

        dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        to = new ArrayList[N]; from = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            to[i] = new ArrayList<>();
            from[i] = new ArrayList<>();
        }

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken());
            to[a].add(new Integer[] {b, c});
            from[b].add(a);
        }

        vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!vis[i] && from[i].isEmpty()) {
                dfs(i);
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(dist[i]);
        }

    }
}
