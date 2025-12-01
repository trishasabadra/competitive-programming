import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

// DFS
public class MaxDist{ // start class

    static ArrayList<Integer>[] adj; // adjacent nodes
    // dist[0][i] = distance from node a to node i
    // dist[1][i] = distance from node b to node i
    static int[][] dist;

    public static int dfs(int curr, int par, int dis, int i) { // int current node, parent node, current level of tree, division
        dist[i][curr] = dis;
        int index = -1;
        for (int n : adj[curr]) { // checks the nodes that it is adjacent to
            if (n == par) { // skip over the parent node
                continue;
            }
            int x = dfs(n, curr, dis+1, i); // the index of the farthest node
            if (index == -1 || dist[i][x] > dist[i][index]) index = x;
        }
        return index == -1 ? curr : index;
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        FastIO fin = new FastIO();
        // INPUT
        int N = fin.nextInt(); // # of nodes
        adj = new ArrayList[N];
        for(int i = 0; i < N; i++)
            adj[i] = new ArrayList<Integer>();

        for (int i = 1; i < N; i++) {
            int a = fin.nextInt()-1, b = fin.nextInt()-1;
            adj[a].add(b); adj[b].add(a);
        }

        dist = new int[2][N];

        // first, find node a by finding the farthest node from an arbitrary node x
        int mxNode = dfs(0, 0, 0, 0);
        // then, find node b and compute distance from a to every other node)
        int mxNode2 = dfs(mxNode, mxNode, 0, 0);
        // finally, compute the distance from b to every other node
        dfs(mxNode2, mxNode2, 0, 1);

        for (int j = 0; j < N; j++) {
            System.out.print(Math.max(dist[0][j], dist[1][j]) + " ");
        }
    }
}


class FastIO extends PrintWriter {
    private InputStream stream;
    private byte[] buf = new byte[1<<16];
    private int curChar, numChars;

    // standard input
    public FastIO() { this(System.in,System.out); }
    public FastIO(InputStream i, OutputStream o) {
        super(o);
        stream = i;
    }
    // file input
    public FastIO(String i, String o) throws IOException {
        super(new FileWriter(o));
        stream = new FileInputStream(i);
    }

    // throws InputMismatchException() if previously detected end of file
    private int nextByte() {
        if (numChars == -1) throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars == -1) return -1; // end of file
        }
        return buf[curChar++];
    }

    // to read in entire lines, replace c <= ' '
    // with a function that checks whether c is a line break
    public String next() {
        int c; do { c = nextByte(); } while (c <= ' ');
        StringBuilder res = new StringBuilder();
        do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
        return res.toString();
    }
    public int nextInt() { // nextLong() would be implemented similarly
        int c; do { c = nextByte(); } while (c <= ' ');
        int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res = 10*res+c-'0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
    }
    public double nextDouble() { return Double.parseDouble(next()); }
}

