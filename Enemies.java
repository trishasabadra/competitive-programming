import java.io.*;
import java.util.*;

public class Enemies { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(fin.readLine());
//        TreeSet<Integer>[] adj = new TreeSet[N]; // dwarf index : all adversaries strength
//        int[] enemy = new int[N];
//        StringTokenizer st = new StringTokenizer(fin.readLine());
//        for (int i = 0; i < N; i++) {
//            enemy[i] = Integer.parseInt(st.nextToken())-1;
//            adj[i] = new TreeSet<>();
//        }
//
//        int[] d = new int[N], e = new int[N]; // strength of dwarfs and elves
//        st = new StringTokenizer(fin.readLine());
//        for (int i = 0; i < N; i++) {
//            d[i] = Integer.parseInt(st.nextToken());
//        }
//        st = new StringTokenizer(fin.readLine());
//        for (int i = 0; i < N; i++) {
//            e[i] = Integer.parseInt(st.nextToken());
//            adj[enemy[i]].add(e[i]);
//        }

        int N = 3;
        TreeSet<Integer>[] adj = new TreeSet[N]; // dwarf index : all adversaries strength
        int[] enemy = {1, 2, 2}, d = {4, 1, 10}, e = {2, 7, 3};
        for (int i = 0; i < N; i++) adj[i] = new TreeSet<>();
        for (int i = 0; i < N; i++) adj[enemy[i]].add(e[i]);

        int count = 0;
        for (int i = 0; i < N; i++) { // iterate through all dwarves
            if (!adj[i].isEmpty()) {
                if (adj[i].higher(d[i]) == null) {
                    adj[i].remove(adj[i].first());
                }
                else {
                    count++;
                    adj[i].remove(adj[i].higher(d[i]));
                }
                adj[(i+1)%N].addAll(adj[i]);
                adj[i].clear();
            }
        }
        System.out.println(count);
    }
}
