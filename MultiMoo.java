import java.io.*;
import java.util.*;

// Floodfill / DFS
public class MultiMoo{ // start class

    static boolean[][] visited;
    static int N;
    static int[][] grid;
    static int curCount = 0;

    static TreeMap<Integer, TreeSet<Integer>> map;
    public static void add(int key, int value) {
        TreeSet<Integer> temp = map.getOrDefault(key, new TreeSet<>());
        temp.add(value);
        map.put(key, temp);
    }

    public static void floodfill(int r, int c, int num1, int num2) {
        // if row and col are in bounds and it's the correct number
        if (r >= 0 && r < N && c >= 0 && c < N && !visited[r][c] && (grid[r][c] == num1 || grid[r][c] == num2)) {
            visited[r][c] = true; // marks as visited
            curCount++; // adds to the score
            floodfill(r-1, c, num1, num2);
            floodfill(r+1, c, num1, num2);
            floodfill(r, c-1, num1, num2);
            floodfill(r, c+1, num1, num2);
        }
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new FileReader("multimoo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(fin.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N];

        // INPUT
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // LARGEST ONE-COW GROUP (PART 1)
        int max1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    curCount = 0;
                    floodfill(i, j, grid[i][j], grid[i][j]);
                    max1 = Math.max(max1, curCount);
                }
            }
        }
         out.println(max1);
//         System.out.println(max1);

        // LARGEST TWO-COW GROUP (PART 2)
        int max2 = 0;
        map = new TreeMap<>();
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N-1; j++) {
                if (grid[i][j] != grid[i][j+1] && (!map.containsKey(grid[i][j]) || !map.get(grid[i][j]).contains(grid[i][j+1]))) { // partners with right side
                    visited = new boolean[N][N];
                    curCount = 0;
                    floodfill(i, j, grid[i][j], grid[i][j+1]);
                    max2 = Math.max(max2, curCount);
                    add(grid[i][j], grid[i][j+1]);
                    add(grid[i][j+1], grid[i][j]);
                }
                if (grid[i][j] != grid[i+1][j] && (!map.containsKey(grid[i][j]) || !map.get(grid[i][j]).contains(grid[i+1][j]))) { // partners with bottom
                    visited = new boolean[N][N];
                    curCount = 0;
                    floodfill(i, j, grid[i][j], grid[i+1][j]);
                    max2 = Math.max(max2, curCount);
                    add(grid[i][j], grid[i+1][j]);
                    add(grid[i+1][j], grid[i][j]);
                }
            }
        }
        out.println(max2);
//        System.out.println(max2);

        out.close();

    }
}


