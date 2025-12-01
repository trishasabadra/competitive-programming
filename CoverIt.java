import java.io.*;
import java.util.*;

public class CoverIt { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(fin.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] adj = new ArrayList[N];
            for (int j = 0; j < N; j++) {
                adj[j] = new ArrayList<>();
            }
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(fin.readLine());
                int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
                adj[a].add(b);
                adj[b].add(a);
            }

            int root = 0, size = 0;
            for (int j = 0; j < N; j++) {
                if (adj[j].size() > size) {
                    root = j; size = adj[j].size();
                }
            }

            Queue<Integer> nums = new LinkedList(), layers = new LinkedList();
            boolean[] vis = new boolean[N];
            nums.add(root); layers.add(0);
            vis[root] = true;
            System.out.println(N/2);
            ArrayList<Integer> evens = new ArrayList<>(), odds = new ArrayList<>();
            while (!nums.isEmpty()) {
                int x = nums.poll(), layer = layers.poll(); // remove current number and layer
                if (layer % 2 == 0) evens.add(x+1);
                else odds.add(x+1);

                for (int n : adj[x]) { // iterate through all neighbors of x
                    if (!vis[n]) { // if the number is not visited yet
                        vis[n] = true; // mark as visited
                        nums.add(n); layers.add(layer+1);
                    }
                }
            }

            if (evens.size() < odds.size()) {
                for (int j : evens) System.out.print(j + " ");
                for (int j = 0; j < N/2 - evens.size(); j++) System.out.print(odds.get(j) + " ");
            }
            else {
                for (int j : odds) System.out.print(j + " ");
                for (int j = 0; j < N/2 - odds.size(); j++) System.out.print(evens.get(j) + " ");
            }
            System.out.println();
        }
    }
}

