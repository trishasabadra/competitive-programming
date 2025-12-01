
import java.io.*;
import java.util.*;

public class DisjointSetsUnion { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        DisjointSets ds = new DisjointSets(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(fin.readLine());
            boolean u = st.nextToken().charAt(0) == 'u';
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
            if (u) {
                ds.union(a, b);
            }
            else {
                if (ds.connected(a, b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}

class DisjointSets {
    int[] parents;  // 0-indexed
    int[] sizes;

    public DisjointSets(int size) {
        sizes = new int[size];
        parents = new int[size];
        Arrays.fill(sizes, 1);
        Arrays.fill(parents, -1);
    }

    // finds the root node of node x’s component
    public int find(int x) {
        return parents[x] == -1 ? x : (parents[x] = find(parents[x]));
    }

    // returns whether the merge changed connectivity
    public boolean union(int x, int y) { // combines x and y components
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return false;
        }
        if (sizes[xRoot] < sizes[yRoot]) {
            parents[xRoot] = yRoot;
            sizes[yRoot] += sizes[xRoot];
        } else {
            parents[yRoot] = xRoot;
            sizes[xRoot] += sizes[yRoot];
        }
        return true;
    }

    // returns whether two nodes are in the same connected component
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}


