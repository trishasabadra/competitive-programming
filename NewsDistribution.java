import java.io.*;
import java.util.*;

public class NewsDistribution { // start class

    static int[] group;
    static ArrayList<Integer>[] adj;
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    static int index = 0, size;
    public static void dfs(int num) {
        if (group[num] == -1) {
            group[num] = index;
            size++;
            for (int n : adj[num]) {
                dfs(n);
            }
        }
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken());
            int[] group = new int[a];
            for (int j = 0; j < a; j++) {
                group[j] = Integer.parseInt(st.nextToken())-1;
            }
            for (int j = 0; j < a-1; j++) {
                adj[group[j]].add(group[j+1]);
                adj[group[j+1]].add(group[j]);
            }
        }

        group = new int[N];
        Arrays.fill(group, -1);
        for (int i = 0; i < N; i++) {
            if (group[i] == -1) {
                size = 0;
                dfs(i);
                map.put(index, size);
                index++;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(map.get(group[i]) + " ");
        }
    }
}
