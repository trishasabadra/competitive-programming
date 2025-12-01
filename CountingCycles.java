import java.io.*;
import java.util.*;

// counts number of nodes in cycles
public class CountingCycles { // start class

//_______________________________main method__________________________________

    @SuppressWarnings("unchecked")
    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] indegree = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            if (c > d) {
                adj[b].add(a);
                indegree[a]++;
            }
            else {
                adj[a].add(b);
                indegree[b]++;
            }
        }

        Queue<Integer> nums = new LinkedList();
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                nums.add(i);
            }
        }

        int count = 0;
        while (!nums.isEmpty()) {
            int x = nums.poll();
            count++;
            for (int n : adj[x]) { // iterate through all neighbors of x
                indegree[n]--;
                if (indegree[n] == 0) {
                    nums.add(n);
                }
            }
        }
        System.out.println(N-count);
    }
}
