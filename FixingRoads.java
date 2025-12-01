import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class FixingRoads { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] x = new int[N], y = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(fin.readLine());
            x[i] = Integer.parseInt(st.nextToken()); y[i] = Integer.parseInt(st.nextToken());
        }

        TreeSet<Integer>[] connected = new TreeSet[N];
        for (int i = 0; i < N; i++) {
            connected[i] = new TreeSet<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
            connected[a].add(b);
            connected[b].add(a);
        }

        ArrayList<City>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (connected[i].contains(j)) adj[i].add(new City(j, 0));
                else {
                    long dist = (long) (Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
                    adj[i].add(new City(j, dist));
                }
            }
        }

        long[] dist = new long[N];
        Arrays.fill(dist, -1);

        PriorityQueue<City> q =  new PriorityQueue<>(); // sorts in reverse order
        q.add(new City(0, 0));

        boolean[] vis = new boolean[N];

        while (!q.isEmpty()) {
            City dv = q.poll();
            int n = dv.node;
            long c = dv.cost;
            dist[n] = dist[n] != -1 ? Math.min(dist[n], c) : c;
            vis[n] = true;
            for (City j : adj[n]) {
                if (!vis[j.node] && (dist[j.node] == -1 || dist[j.node] > j.cost)) {
                    q.add(new City (j.node, j.cost));
                }
            }
        }

        double sum = 0;
        for (int i = 0; i < N; i++) {
//            System.out.print(dist[i] + " ");
            sum += Math.sqrt(dist[i]);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(sum));

    }
}

class City implements Comparable<City> {
    int node;
    long cost;
    public City(int node, long cost) { // constructor
        this.cost = cost;
        this.node = node;
    }
    public int compareTo(City o) { // sorting method
        return Long.compare(cost, o.cost);
    }
}