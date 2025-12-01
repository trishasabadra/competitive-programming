
import java.io.*;
import java.util.*;

public class CuttingGraph { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        }

        int[][] input = new int[Q][3]; // union = 0, query = 1
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(fin.readLine());
            input[i][0] = st.nextToken().charAt(0) == 'c' ? 0 : 1;
            input[i][1] = Integer.parseInt(st.nextToken())-1; input[i][2] = Integer.parseInt(st.nextToken())-1;
        }

        ArrayList<Boolean> ans = new ArrayList<>();
        DisjointSets3 ds = new DisjointSets3(N);
        for (int i = Q-1; i >= 0; i--) {
            if (input[i][0] == 0) { // union
                ds.union(input[i][1], input[i][2]);
            }
            else { // query
                ans.add(ds.connected(input[i][1], input[i][2]));
            }
        }

        for (int i = ans.size()-1; i >= 0; i--) {
            if (ans.get(i)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

class DisjointSets3 {
    int[] parents;  // 0-indexed
    int[] sizes, init, points;

    public DisjointSets3(int size) {
        sizes = new int[size];
        parents = new int[size];
        Arrays.fill(sizes, 1);
        for (int i = 0; i < size; i++) parents[i] = i;
    }

    // finds the root node of node x’s component
    public int find(int x) {
        return parents[x] == x ? x : (parents[x] = find(parents[x]));
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


