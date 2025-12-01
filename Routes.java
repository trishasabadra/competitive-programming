import java.io.*;
import java.util.*;

public class Routes { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int S = Integer.parseInt(st.nextToken())-1, E = Integer.parseInt(st.nextToken())-1, N = Integer.parseInt(st.nextToken());

//        ArrayList<Train>[] adj = new ArrayList[1000];
//        for (int i = 0; i < 1000; i++) {
//            adj[i] = new ArrayList<>();
//        }
//
//        ArrayList<Integer> start = new ArrayList<>();
//        int[] costOfRoute = new int[N];
//        for (int i = 0; i < N; i++) { // routes
//            st = new StringTokenizer(fin.readLine());
//            int c = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken()); // cost, # of cities
//            costOfRoute[i] = c;
//            ArrayList<Integer> route = new ArrayList<>();
//
//            st = new StringTokenizer(fin.readLine());
//            for (int j = 0; j < t; j++) { // cities in route
//                int a = Integer.parseInt(st.nextToken())-1;
//                route.add(a);
//                if (a == S) {
//                    start.add(i);
//                }
//            }
//            for (int j = 0; j < route.size()-1; j++) {
//                int a = route.get(j), b = route.get(j+1);
//                adj[a].add(new Train(b, i, c, 0));
//            }
//        }
//
//        Long[] dist = new Long[1000];
//        int[] numOfTrains = new int[1000];
//        Arrays.fill(dist, -1L);
//        Arrays.fill(numOfTrains, -1);
//
//        PriorityQueue<Train> q =  new PriorityQueue<Train>();
//        for (int i : start) q.add(new Train(S, i, costOfRoute[i], 0));
//
//        while (!q.isEmpty()) {
//            Train dv = q.poll();
//            int n = dv.n, r = dv.route, t = dv.trains;
//            long c = dv.cost;
////            System.out.println(n + " " + r + " " + c);
//            if (dist[n] == -1 || dist[n] > c) {
//                dist[n] = c; numOfTrains[n] = t;
//            }
//            for (Train j : adj[n]) {
//                if (j.route == r && (dist[j.n] == -1 || dist[j.n] > c)) { // same route
//                    q.add(new Train (j.n, r, c, t+1));
//                }
//                else if (j.route != r && (dist[j.n] == -1 || dist[j.n] > c+j.cost)) { // different route
//                    q.add(new Train (j.n, j.route, c+j.cost, t+1));
//                }
//            }
//        }
//
//        System.out.println(dist[E] + " " + numOfTrains[E]);

        Train[][] adj = new Train[1000][1000];

        for (int i = 0; i < N; i++) { // routes
            st = new StringTokenizer(fin.readLine());
            int c = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken()); // cost, # of cities
            int[] route = new int[t];

            st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < t; j++) { // cities in route
                int a = Integer.parseInt(st.nextToken())-1;
                route[j] = a;
            }
            for (int j = 0; j < route.length; j++) {
                for (int k = j+1; k < route.length; k++) {
                    int a = route[j], b = route[k];
                    Train newT = new Train(b, c, k-j);
                    adj[a][b] = adj[a][b] == null ? newT : Collections.min(Arrays.asList(adj[a][b], newT));
                }
            }
        }

//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(adj[i][j] + " ");
//            }
//            System.out.println();
//        }

        Long[] dist = new Long[1000];
        int[] numOfTrains = new int[1000];
        Arrays.fill(dist, -1L);
        Arrays.fill(numOfTrains, -1);

        PriorityQueue<Train> q =  new PriorityQueue<>();
        q.add(new Train(S, 0, 0));

        while (!q.isEmpty()) {
            Train dv = q.poll();
            int n = dv.n, t = dv.trains;
            long c = dv.cost;
//            System.out.println(n + " " + r + " " + c);
            if (dist[n] == -1 || dist[n] > c) {
                dist[n] = c; numOfTrains[n] = t;
            }
            for (int i = 0; i < 1000; i++) {
                if (adj[n][i] != null && n != i) {
                    if (dist[i] == -1 || dist[i] > c + adj[n][i].cost) { // different route
                        q.add(new Train(i, c + adj[n][i].cost, t + adj[n][i].trains));
                    }
                }
            }
        }

        System.out.println(dist[E] + " " + numOfTrains[E]);

    }
}

//class Train implements Comparable<Train> {
//    int n, route, trains;
//    long cost;
//    public Train(int n, int route, long cost, int trains) { // constructor
//        this.n = n;
//        this.route = route;
//        this.cost = cost;
//        this.trains = trains;
//    }
//    public int compareTo(Train o) { // sorting method
//        if (cost == o.cost)
//            return Integer.compare(trains, o.trains);
//        return Long.compare(cost, o.cost);
//    }
//}

class Train implements Comparable<Train> {
    int n, trains;
    long cost;
    public Train(int n, long cost, int trains) { // constructor
        this.n = n;
        this.cost = cost;
        this.trains = trains;
    }
    public int compareTo(Train o) { // sorting method
        if (cost == o.cost)
            return Integer.compare(trains, o.trains);
        return Long.compare(cost, o.cost);
    }
}



