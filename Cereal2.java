//import java.awt.*;
//import java.io.*;
//import java.util.*;
//
//public class Cereal2 { // start class
//
//    static boolean[] vis, cvis; // cow visited, cereal visited
//    static ArrayList<Integer[]>[] adj; // {cereal, cow}
//    static PriorityQueue<Edge> q;
//    static int nodes, edges; // cereal
//    public static void dfs(int num) {
//        if (!cvis[num]) nodes++;
//        cvis[num] = true;
//        for (Integer[] n : adj[num]) {
//            if (!vis[n[1]]) {
//                vis[n[1]] = true;
//                q.add(new Edge(n[1], adj[num].size() + adj[n[0]].size()));
//                dfs(n[0]);
//                edges++;
//            }
//        }
//    }
//
////_______________________________main method__________________________________
//
//    public static void main(String args[]) throws IOException { // start method
//
//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(fin.readLine());
//        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
//
//        int[] fav = new int[N], sfav = new int[N];
////        int N = 6, M = 6;
////        int[] fav = {0, 1, 3, 4, 3, 4}, sfav = {1, 2, 4, 5, 5, 1};
//
//        adj = new ArrayList[M];
//        for (int i = 0; i < M; i++) adj[i] = new ArrayList<>();
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(fin.readLine());
//            fav[i] = Integer.parseInt(st.nextToken())-1; sfav[i] = Integer.parseInt(st.nextToken())-1;
//            if (fav[i] != sfav[i]) adj[fav[i]].add(new Integer[] {sfav[i], i}); adj[sfav[i]].add(new Integer[] {fav[i], i});
//        }
//
//        vis = new boolean[N];
//        cvis = new boolean[M];
//        int count = 0;
//        boolean[] used = new boolean[M];
//        ArrayList<Integer> order = new ArrayList<>();
//        for (int i = 0; i < M; i++) {
//            if (!cvis[i]) {
//                q = new PriorityQueue(); // contains edges (cows)
//                nodes = 0; edges = 0;
//                dfs(i);
//                // edges = cows
//                while (!q.isEmpty()) {
//                    Edge c = q.poll();
//                    if (!used[fav[c.cow]]) used[fav[c.cow]] = true;
//                    else if (!used[sfav[c.cow]]) used[sfav[c.cow]] = true;
//                    order.add(c.cow);
//                }
//                if (edges > nodes) count += edges - nodes;
//            }
//        }
//        System.out.println(count);
//        for (int i : order) System.out.println(i+1);
//
//    }
//}
//
//class Edge implements Comparable<Edge> {
//    int cow, size;
//    public Edge(int cow, int size) { // constructor
//        this.size = size;
//        this.cow = cow;
//    }
//    public int compareTo(Edge o) { // sorting method
//        return -Integer.compare(size, o.size);
//    }
//}
//
//
//
