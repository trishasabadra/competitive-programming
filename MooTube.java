import java.io.*;
import java.util.*;

public class MooTube { // start class

    static boolean[] vis;
    static ArrayList<Video>[] adj;
    static int K, count;
    public static void dfs(int num) {
        if (!vis[num]) {
            vis[num] = true;
            count++;
            for (Video n : adj[num]) {
                if (n.r >= K)
                    dfs(n.toNode);
            }
        }
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method
//
//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fin = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(fin.readLine());
            int p = Integer.parseInt(st.nextToken())-1, q = Integer.parseInt(st.nextToken())-1, r = Integer.parseInt(st.nextToken());
            adj[p].add(new Video(q, r));
            adj[q].add(new Video(p, r));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(fin.readLine());
            K = Integer.parseInt(st.nextToken()); int v = Integer.parseInt(st.nextToken())-1;
            vis = new boolean[N];
            count = 0;
            dfs(v);
            out.println(count-1);
        }

        out.close();
    }
}
class Video {
    int toNode, r;
    public Video (int toNode, int r) {
        this.toNode = toNode;
        this.r = r;
    }
}
