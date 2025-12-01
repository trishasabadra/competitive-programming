import java.io.*;
import java.util.*;

public class ConnectBarns { // start class

    static boolean[] vis;
    static ArrayList<Integer>[] adj;
    static ArrayList<TreeSet<Integer>> comp; // connected components
    static TreeSet<Integer> group;

    public static void dfs(int num) {
        if (!vis[num]) {
            vis[num] = true;
            group.add(num);
            for (int n : adj[num]) {
                dfs(n);
            }
        }
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(fin.readLine());
//        int T = 1;
        outer: for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

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

//            int N = 20, M = 2;
//            adj = new ArrayList[N];
//            for (int i = 0; i < N; i++) {
//                adj[i] = new ArrayList<>();
//            }
//            adj[0].add(4); adj[2].add(19); adj[4].add(0); adj[19].add(2);

            vis = new boolean[N];
            comp = new ArrayList<>();

            // 0 roads
            group = new TreeSet<>();
            dfs(0);
            if (group.contains(N-1)) {
                System.out.println(0);
                continue;
            }
            comp.add(group);

            // 1 road
            group = new TreeSet<>();
            dfs(N-1);
            comp.add(group);
            long min = N*N;
            for (Integer i : group) {
                if (comp.get(0).lower(i) != null && comp.get(0).lower(i)+1 == i || comp.get(0).higher(i) != null && comp.get(0).higher(i)-1 == i) {
                    System.out.println(1);
                    continue outer;
                }
                if (comp.get(0).lower(i) != null) min = (long) Math.min(min, Math.pow(i-comp.get(0).lower(i), 2));
                if (comp.get(0).higher(i) != null) min = (long) Math.min(min, Math.pow(comp.get(0).higher(i)-i, 2));
            }

            // 2 roads
            for (int i = 1; i < N-1; i++) {
                if (!vis[i]) {
                    group = new TreeSet<>();
                    dfs(i);
                    comp.add(group);

                    long min1 = min, min2 = min;
                    for (Integer j : group) {
                        min1 = Math.min(min1, (long) Math.pow(j-comp.get(0).lower(j), 2));
                        min2 = Math.min(min2, (long) Math.pow(comp.get(1).higher(j)-j, 2));
                    }
                    min = Math.min(min, min1+min2);
                }
            }
            System.out.println(min);
        }
    }
}
