import java.io.*;
import java.util.*;

public class Proco19D { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());

        TreeSet<Integer>[] adj = new TreeSet[N+1], triangle = new TreeSet[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new TreeSet<>();
            triangle[i] = new TreeSet<>();
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken()), u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());

            if (a == 0) { // add edge
                adj[u].add(i); adj[i].add(u);
                if (u != v) {
                    adj[u].add(i); adj[i].add(u);
                    adj[v].add(i); adj[i].add(v);
                    if (adj[v].contains(u)) {
                        count++;
                        triangle[v].add(u); triangle[v].add(i); triangle[i].add(v); triangle[i].add(u); triangle[u].add(i); triangle[u].add(v);
                    }
                }
            }

            else { // remove edge
                adj[v].remove(u); adj[u].remove(v);
                adj[u].add(i); adj[i].add(u);
                adj[v].add(i); adj[i].add(v);

                if (triangle[v].contains(u)) {
                    triangle[v].remove(u); triangle[u].remove(v);

                    TreeSet<Integer> remove = new TreeSet<>();
                    for (int j : triangle[v]) {
                        if (triangle[u].contains(j)) remove.add(j);
                    }
                    for (int j : remove) {
                        triangle[v].remove(j); triangle[u].remove(j);
                    }
                    count -= remove.size();
                }
            }
            System.out.println(count);
        }
    }
}
