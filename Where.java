import java.io.*;
import java.util.*;

public class Where { // start class

    static int[][] grid;
    static boolean[][] vis;
    static int x1, x2, y1, y2; // top left, bottom right

    public static void floodfill(int r, int c, int color) {
        if (r >= x1 && r < x2 && c >= y1 && c < y2 && !vis[r][c] && grid[r][c] == color) { // if row and col are in bounds and its not visited
            vis[r][c] = true;
            floodfill(r-1, c, color);
            floodfill(r+1, c, color);
            floodfill(r, c-1, color);
            floodfill(r, c+1, color);
        }
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

//        BufferedReader fin = new BufferedReader(new FileReader("fileName.in"));
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fileName.out")));

        int N = Integer.parseInt(fin.readLine());
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = fin.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = str.charAt(j)-64;
            }
        }

        ArrayList<Integer> r1 = new ArrayList<>(), r2 = new ArrayList<>(), c1 = new ArrayList<>(), c2 = new ArrayList<>();
        // top left corner
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; b++) {
                // bot right corner
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {

                        vis = new boolean[N][N];
                        x1 = a; x2 = r; y1 = b; y2 = c;
                        int[] color = new int[26]; // number of connected components of each color
                        int count = 0; // counts # of colors

                        // iterates through subgrid
                        for (int i = x1; i <= x2; i++) {
                            for (int j = y1; j <= y2; j++) {
                                if (!vis[i][j]) {
                                    int col = grid[i][j];
                                    if (color[col] == 0) count++; // if first occurrence of color
                                    color[col]++;
                                    floodfill(i, j, col);
                                }
                            }
                        }

                        // check if subgrid is valid
                        boolean one = false, more = false;
                        for (int i = 0; i < 26; i++) {
                            if (color[i] == 1) one = true;
                            else if (color[i] > 1) more = true;
                        }
                        if (count == 2 && one && more) {
                            r1.add(x1);
                            r2.add(x2);
                            c1.add(y1);
                            c2.add(y2);
                        }
                    }
                }
            }
        }

        int counter = 0;
        for (int i = 0; i < r1.size(); i++) {
            x1 = r1.get(i); y1 = c1.get(i); x2 = r2.get(i); y2 = c2.get(i);
            boolean isValid = true;
            for (int j = 0; j < r1.size(); j++) {
                int x3 = r1.get(j), y3 = c1.get(j), x4 = r2.get(j), y4 = c2.get(j);
                if (i != j && x3 >= x1 && y3 >= y1 && x4 <= x2 && y4 <= y2) {
                    isValid = false; break;
                }
            }
            if (isValid) counter++;
        }
        System.out.println(counter);

//        out.close();
    }
}
