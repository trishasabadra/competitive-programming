import java.io.*;
import java.util.*;

public class Radio { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        ArrayList<Station>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                long dist = (2019201913L*(i+1) + 2019201949L*(j+1)) % 2019201997;
                adj[i].add(new Station(j, dist));
                adj[j].add(new Station(i, dist));
            }
        }

        long[] dist = new long[N];
        Arrays.fill(dist, -1);

        PriorityQueue<Station> q =  new PriorityQueue<>(); // sorts in reverse order
        q.add(new Station(0, 0));

        boolean[] vis = new boolean[N];

        while (!q.isEmpty()) {
            Station dv = q.poll();
            int n = dv.node;
            long c = dv.cost;
            dist[n] = dist[n] != -1 ? Math.min(dist[n], c) : c;
            vis[n] = true;
            System.out.println(n);
            for (Station j : adj[n]) {
                if (!vis[j.node] && (dist[j.node] == -1 || dist[j.node] > j.cost)) {
                    q.add(new Station (j.node, j.cost));
                }
            }
        }

        Arrays.sort(dist);
        System.out.println(dist[N-K+1]);
    }
}

class Station implements Comparable<Station> {
    int node;
    long cost;
    public Station(int node, long cost) { // constructor
        this.cost = cost;
        this.node = node;
    }
    public int compareTo(Station o) { // sorting method
        return Long.compare(cost, o.cost);
    }
}
