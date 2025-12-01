//import java.io.*;
//import java.util.*;
//
//public class Dijkstra { // start class
//
////_______________________________main method__________________________________
//
//    public static void main(String args[]) throws IOException { // start method
//
//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(fin.readLine());
//        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken())-1; // nodes, edges, start node
//        ArrayList<Node>[] adj = new ArrayList[N];
//        for (int i = 0; i < N; i++) {
//            adj[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(fin.readLine());
//            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken());
//            adj[a].add(new Node(b, c)); adj[b].add(new Node(a, c));
//        }
//
//        int[] dist = new int[N];
//        Arrays.fill(dist, -1);
//
//        PriorityQueue<Node> q =  new PriorityQueue<Node>(); // sorts in reverse order
//        q.add(new Node(S, 0));
//
//        while (!q.isEmpty()) {
//            Node dv = q.poll();
//            int n = dv.node, c = dv.cost;
//            dist[n] = dist[n] != -1 ? Math.min(dist[n], c) : c;
//            for (Node j : adj[n]) {
//                if (dist[j.node] == -1 || dist[j.node] > c+j.cost) {
//                    q.add(new Node (j.node, c+j.cost));
//                }
//            }
//        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(dist[i]);
//        }
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
