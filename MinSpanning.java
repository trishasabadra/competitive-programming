import java.io.*;
import java.util.*;

public class MinSpanning { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }

        int[] dist = new int[N];
        Arrays.fill(dist, -1);

        PriorityQueue<Node> q =  new PriorityQueue<Node>(); // sorts in reverse order
        q.add(new Node(0, 0));

        boolean[] vis = new boolean[N];

        while (!q.isEmpty()) {
            Node dv = q.poll();
            int n = dv.node, c = dv.cost;
            dist[n] = dist[n] != -1 ? Math.min(dist[n], c) : c;
            vis[n] = true;
            for (Node j : adj[n]) {
                if (!vis[j.node] && (dist[j.node] == -1 || dist[j.node] > j.cost)) {
                    q.add(new Node (j.node, j.cost));
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += dist[i];
        }
        System.out.println(sum);
    }
}

class Node implements Comparable<Node> {
    int node, cost;
    public Node(int node, int cost) { // constructor
        this.cost = cost;
        this.node = node;
    }
    public int compareTo(Node o) { // sorting method
        return Integer.compare(cost, o.cost);
    }
}

