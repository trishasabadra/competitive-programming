//import java.io.*;
//import java.lang.reflect.Array;
//import java.util.*;
//
//// DFS
//public class SumDist{ // start class
//
//    static ArrayList<Integer>[] adj; // adjacent nodes
//    static int[] sum; // sums of all the distances from every node
//    static int[] size; // size of all the nodes subtrees
//    static int N;
//
//    // FINDS SUM FROM NODE 1 AND SUB-TREE SIZES OF EVERY NODE
//    public static void dfs(int curr, int par, int depth) { // int current node, parent node, distance from root to current node
//        sum[0] += depth;
//        size[curr] = 1;
//        for (int n : adj[curr]) { // checks the nodes that it is adjacent to
//            if (n == par) { // skip over the parent node
//                continue;
//            }
//            dfs(n, curr, depth+1);
//            size[curr] += size[n];
//        }
//    }
//
//    // FINDS SUM FOR REST OF NODES
//    public static void dfs2(int curr, int par) {
//        for (int n : adj[curr]) { // checks the nodes that it is adjacent to
//            if (n == par) { // skip over the parent node
//                continue;
//            }
//            sum[n] = sum[curr] + N - 2 * size[n];
//            dfs2(n, curr);
//        }
//    }
//
////_______________________________main method__________________________________
//
//    public static void main(String args[]) throws IOException { // start method
//
//        FastIO fin = new FastIO();
//        // INPUT
//        N = fin.nextInt(); // # of nodes
//        adj = new ArrayList[N];
//        for(int i = 0; i < N; i++)
//            adj[i] = new ArrayList<Integer>();
//
//        for (int i = 1; i < N; i++) {
//            int a = fin.nextInt()-1, b = fin.nextInt()-1;
//            adj[a].add(b); adj[b].add(a);
//        }
//
//        sum = new int[N]; size = new int[N];
//        // find sum of distances from node 1 to every node
//        dfs(0, -1, 0);
//        // compute the distance from node 2-N to every other node
//        dfs2(0, -1);
//
//        for (int i = 0; i < N; i++) {
//            System.out.print(sum[i] + " ");
//        }
//    }
//}
//
//
//class FastIO extends PrintWriter {
//    private InputStream stream;
//    private byte[] buf = new byte[1<<16];
//    private int curChar, numChars;
//
//    // standard input
//    public FastIO() { this(System.in,System.out); }
//    public FastIO(InputStream i, OutputStream o) {
//        super(o);
//        stream = i;
//    }
//    // file input
//    public FastIO(String i, String o) throws IOException {
//        super(new FileWriter(o));
//        stream = new FileInputStream(i);
//    }
//
//    // throws InputMismatchException() if previously detected end of file
//    private int nextByte() {
//        if (numChars == -1) throw new InputMismatchException();
//        if (curChar >= numChars) {
//            curChar = 0;
//            try {
//                numChars = stream.read(buf);
//            } catch (IOException e) {
//                throw new InputMismatchException();
//            }
//            if (numChars == -1) return -1; // end of file
//        }
//        return buf[curChar++];
//    }
//
//    // to read in entire lines, replace c <= ' '
//    // with a function that checks whether c is a line break
//    public String next() {
//        int c; do { c = nextByte(); } while (c <= ' ');
//        StringBuilder res = new StringBuilder();
//        do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
//        return res.toString();
//    }
//    public int nextInt() { // nextLong() would be implemented similarly
//        int c; do { c = nextByte(); } while (c <= ' ');
//        int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
//        int res = 0;
//        do {
//            if (c < '0' || c > '9')
//                throw new InputMismatchException();
//            res = 10*res+c-'0';
//            c = nextByte();
//        } while (c > ' ');
//        return res * sgn;
//    }
//    public double nextDouble() { return Double.parseDouble(next()); }
//}
//
