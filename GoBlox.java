//import java.io.*;
//import java.lang.reflect.Array;
//import java.util.*;
//
//public class GoBlox { // start class
//
//    public static int N, M;
//    public static ArrayList<Node>[] adj;
//    public static int[] parent; // holds parent of every node
//
//    public static int dijkstra(int child, int par) {
//        int[] dist = new int[N];
//        Arrays.fill(dist, -1);
//        dist[0] = 0;
//
//        PriorityQueue<Node> q =  new PriorityQueue<>(); // sorts in reverse order
//        q.add(new Node(0, 0));
//
//        while (!q.isEmpty()) {
//            Node dv = q.poll();
//            int n = dv.node, c = dv.cost;
//            for (Node j : adj[n]) {
//                if (dist[j.node] == -1 || par == j.node && child == n && dist[j.node] > c+j.cost*2 || !(par == j.node && child == n) && dist[j.node] > c+j.cost) {
//                    q.add(new Node (j.node, c+j.cost));
//                    dist[j.node] = c+j.cost;
//                    parent[j.node] = n;
//                }
//            }
//        }
//        return dist[N-1];
//    }
//
////_______________________________main method__________________________________
//
//    public static void main(String args[]) throws IOException { // start method
//
//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(fin.readLine());
//        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); // nodes, edges
////        N = 4; M = 5;
//
//        adj = new ArrayList[N];
//        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
//        parent = new int[N];
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(fin.readLine());
//            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken());
//            adj[a].add(new Node(b, c)); adj[b].add(new Node(a, c));
//        }
//
////        adj[0].add(new Node(1, 2)); adj[0].add(new Node(2, 2)); adj[0].add(new Node(3, 5));
////        adj[1].add(new Node(0, 2)); adj[1].add(new Node(3, 2));
////        adj[2].add(new Node(0, 2)); adj[2].add(new Node(3, 3));
////        adj[3].add(new Node(0, 5)); adj[3].add(new Node(1, 2)); adj[3].add(new Node(2, 3));
//
//        int cur = dijkstra(-1, -1);
//
//        int curNode = N-1, min = Integer.MAX_VALUE;
//        while (curNode != 0) {
//            System.out.println(curNode + " " + parent[curNode]);
//            min = Math.min(dijkstra(curNode, parent[curNode]), min);
//            curNode = parent[curNode];
//        }
//
//        System.out.println(min - cur);
//
//    }
//}
//
//class Node implements Comparable<Node> {
//    int node, cost;
//    public Node(int node, int cost) { // constructor
//        this.cost = cost;
//        this.node = node;
//    }
//    public int compareTo(Node o) { // sorting method
//        return Integer.compare(cost, o.cost);
//    }
//}
//
//
