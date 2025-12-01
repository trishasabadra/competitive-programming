//import java.io.*;
//import java.util.*;
//
//public class LightsOn{ // start class
//
//    static int N, M;
//    static boolean[][] lightOn, visited;
//    static Node[][] grid;
//    static int[] x = {1, -1, 0, 0};
//    static int[] y = {0, 0, 1, -1};
//
//    public static boolean inBounds(int r, int c) {
//        return (r >= 0 && r < N && c >= 0 && c < N);
//    }
//
//    public static void floodfill(int r, int c) {
//        // if the room is in bounds, the room is not visited, and the lights are on
//        if (inBounds(r, c) && lightOn[r][c] && !visited[r][c]) {
//            visited[r][c] = true; // mark room as visited
//
//            for (Node n : grid[r][c].nodesToLightUp) {
//                lightOn[n.row][n.col] = true; // turn on lights
//                for (int i = 0; i < 4; i++) {
//                    int newR = n.row+x[i], newC = n.col+y[i];
//                    if (inBounds(newR, newC) && visited[newR][newC]) { // checks if adjacent rooms are lit
//                        floodfill(n.row, n.col); break;
//                    }
//                }
//            }
//            for (int i = 0; i < 4; i++) {
//                floodfill(r+x[i], c+y[i]);
//            }
//        }
//    }
//
////_______________________________main method__________________________________
//
//    public static void main(String args[]) throws IOException { // start method
//
//        BufferedReader fin = new BufferedReader(new FileReader("lightson.in"));
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
//
////        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(fin.readLine());
//        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
//        lightOn = new boolean[N][N]; visited = new boolean[N][N];
//        lightOn[0][0] = true;
//
//        // CREATING A GRID OF NODES
//        grid = new Node[N][N];
//        for (int r = 0; r < N; r++) {
//            for (int c = 0; c < N; c++) {
//                grid[r][c] = new Node(r, c);
//            }
//        }
//
//        // INPUT
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(fin.readLine());
//            int x = Integer.parseInt(st.nextToken())-1, y = Integer.parseInt(st.nextToken())-1; // switch position
//            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1; // toggle position
//            grid[x][y].nodesToLightUp.add(grid[a][b]);
//        }
//
//        floodfill(0, 0);
//
//        // COUNT HOW MANY ROOMS ARE LIT UP AT THE END
//        int counter = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (lightOn[i][j]) counter++;
//            }
//        }
//        out.println(counter);
//        out.close();
////        System.out.println(counter);
//
//    }
//}
//
//class Node {
//    public int node;
//    int row, col;
//    ArrayList<Node> nodesToLightUp;
//
//    public Node(int r, int c) {
//        row = r; col = c;
//        nodesToLightUp = new ArrayList<>();
//    }
//}
//
