import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Revegetate { // start class

    static ArrayList<Integer>[] same, diff;
    static int[] type;
    static boolean impossible = false;

    public static void dfs(int node, int color) {
        type[node] = color;

        //Check all of the nodes that are supposed to share the same color.
        for (int next : same[node]) {
            //There is a contradiction here.
            if (type[next] == 3 - color) {
                impossible = true;
            }
            if (type[next] == 0) {
                dfs(next, color);
            }
        }

        //Check all of the nodes that are supposed to have a different color.
        for (int next : diff[node]) {
            //There is a contradiction here.
            if (type[next] == color) {
                impossible = true;
            }
            if (type[next] == 0) {
                dfs(next, 3 - color);
            }
        }
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fin = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        //Initialize the adjacency lists.
        same = new ArrayList[N];
        diff = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            same[i] = new ArrayList<>();
            diff[i] = new ArrayList<>();
        }
        int comps = 0; //The number of connected components.

        //Read in the edges.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(fin.readLine());
            char type = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;

            //They share the same type of grass
            if (type == 'S') {
                same[a].add(b);
                same[b].add(a);
            }
            //They share different types of grass.
            if (type == 'D') {
                diff[a].add(b);
                diff[b].add(a);
            }
        }

        type = new int[N];
        for (int i = 0; i < N; i++) {
            //This node is unvisited, so try to color it with color '1'.
            if (type[i] == 0) {
                dfs(i, 1);
                comps++;
            }
        }
        //It is impossible to color the fields.
        if (impossible) {
            out.println(0);
        } else {
            //The solution is 2^(number of components).
            out.print(1);
            for (int i = 0; i < comps; i++) {
                out.print(0);
            }
        }
        out.close();
    }
}
