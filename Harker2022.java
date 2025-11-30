import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Harker2022 {

    static int[] planets;
    static ArrayList<Integer>[] adj;
    static int ans;
    static boolean[] visited;

    public static void dfs(int b, int node, int count, int c) {
        if(planets[node] == c) count++;
        if(node == b) {
            ans = count;
            return;
        }
        visited[node] = true;
        for(int i : adj[node]) {
            if(!visited[i]) {
                dfs(b, i, count, c);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        planets = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N;i++) planets[i] = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        for(int i = 0;i<N;i++) {
            adj = new ArrayList[N];
        }

        for(int i = 0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            adj[a-1].add(b-1);
            adj[b-1].add(a-1);
        }

        for(int i = 0;i<Q;i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if(type == 1) {
                // type 1: change planet type
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                planets[a-1] = b;
            }
            else {
                // type 2: find # of certain type on a direct path
                ans = 0;
                visited = new boolean[N];

                int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1, c = Integer.parseInt(st.nextToken());

                dfs(b, a, 0, c);

                System.out.println(ans);
            }
        }
    }
}

