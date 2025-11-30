import java.awt.*;
import java.io.*;
import java.util.*;

public class Cereal { // start class

    static boolean[] vis, cvis; // cow visited, cereal visited
    static ArrayList<Integer[]>[] adj; // {cereal, cow}
    static PriorityQueue<Edge> q;
    static int[] degree;
    public static void dfs(int num) {
        cvis[num] = true;
        for (Integer[] n : adj[num]) {
            if (!vis[n[1]]) {
                vis[n[1]] = true;
                q.add(new Edge(n[1], adj[num].size() + adj[n[0]].size(), num, n[0]));
                dfs(n[0]);
            }
        }
    }

    static int[] used, fav, sfav;
    //  = {1, 2, 1, 5, 6, 5, 6, 4}
    static ArrayList<Integer> arr;
    public static void recur(int num) {
        vis[num] = true;
        if (used[fav[num]] == -1) {
            used[fav[num]] = num;
            used[sfav[num]] = -1;
        }
        else if (!vis[used[fav[num]]]) { // if has parent and parent is not visited
            recur(used[fav[num]]);
        }
        arr.add(num);
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        fav = new int[N]; sfav = new int[N];
//        int N = 8, M = 10;
//        int[] sfav = {0, 3, 2, 4, 7, 6, 4, 7};

        adj = new ArrayList[M];
        for (int i = 0; i < M; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(fin.readLine());
            fav[i] = Integer.parseInt(st.nextToken())-1; sfav[i] = Integer.parseInt(st.nextToken())-1;
            adj[fav[i]].add(new Integer[] {sfav[i], i}); adj[sfav[i]].add(new Integer[] {fav[i], i});
        }
        degree = new int[M]; // degree of cereal
        for (int i = 0; i < M; i++) degree[i] = adj[i].size();

        vis = new boolean[N];
        cvis = new boolean[M];
        used = new int[M]; // used[i] = what cow gets cereal i, -1 if no cow
        Arrays.fill(used, -1);
        int[] getsFav = new int[N]; // 1 = fav, 0 = nothing, -1 = second fav
        for (int i = 0; i < M; i++) {
            if (!cvis[i]) {
                q = new PriorityQueue(); // contains edges (cows)
                dfs(i);
                // edges = cows
                while (!q.isEmpty()) {
                    Edge c = q.poll();
                    if (degree[c.a] == 1) { // if cereal A is leaf
                        used[c.a] = c.cow;
                        if (fav[c.cow] == c.a) getsFav[c.cow] = 1;
                        else getsFav[c.cow] = -1;
                        for (Integer[] j : adj[c.a]) {
                            degree[j[0]]--;
                        }
                    }
                    else if (degree[c.b] == 1) { // if cereal B is leaf
                        used[c.b] = c.cow;
                        if (fav[c.cow] == c.b) getsFav[c.cow] = 1;
                        else getsFav[c.cow] = -1;
                        for (Integer[] j : adj[c.b]) {
                            degree[j[0]]--;
                        }
                    }
                    else { // not a leaf
                        if (used[fav[c.cow]] == -1) {
                            used[fav[c.cow]] = c.cow;
                            getsFav[c.cow] = 1;
                        }
                        else if (used[sfav[c.cow]] == -1) {
                            used[sfav[c.cow]] = c.cow;
                            getsFav[c.cow] = -1;
                        }
                    }
                }
            }
        }

        int count = 0;
        vis = new boolean[N];
        ArrayList<Integer> order = new ArrayList<>();
        // FAVORITE
        for (int i = 0; i < N; i++) {
            if (getsFav[i] == 1) {
                vis[i] = true;
                order.add(i);
                // System.out.println(i+1);
            }
        }
        // System.out.println("_____________");
        // SECOND FAVORITE
        for (int i = 0; i < N; i++) {
            if (getsFav[i] == -1 && !vis[i]) {
                arr = new ArrayList<>();
                recur(i);
                order.addAll(arr);
                // System.out.println(i+1 + " " + arr.toString());
            }
        }
        // for (int i = 0; i < M; i++) System.out.println( "cow: " + (used[i]+1) + " cereal: " + (i+1));
        // System.out.println("_____________");
        // NO FAVORITE
        for (int i = 0; i < N; i++) {
            if (getsFav[i] == 0) {
                count++;
                //System.out.println(i+1);
                order.add(i);
            }
        }
        // System.out.println("_____________");

        System.out.println(count);
        for (int i = 0; i < N; i++) {
            System.out.println(order.get(i)+1);
        }
    }
}
class Edge implements Comparable<Edge> {
    int cow, size, a, b;
    public Edge(int cow, int size, int to, int from) { // constructor
        this.size = size;
        this.cow = cow;
        this.a = to;
        this.b = from;
    }
    public int compareTo(Edge o) { // sorting method
        return Integer.compare(size, o.size);
    }
}
/*
solution:
1. remove leaves of graph one by one. if no leaves, choose randomly
2. determine if the cereal is the first or second favorite. if it is the second favorite, make a new graph making it come after the cow that gets its first favorite.
3. to topological sort to find the ordering
4. add cows that don't get anything to the back.
 */

/*
6 7
2 1
3 2
5 7
5 6
7 6
5 2
 */


