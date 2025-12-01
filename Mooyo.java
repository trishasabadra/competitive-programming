import java.io.*;
import java.util.*;

public class Mooyo { // start class

    static int R, C, K;
    static int[][] arr;
    static boolean vis[][];
    static int count;
    static ArrayList<Integer[]> list;

    public static void floodfill(int r, int c, int color) {
        if (r >= 0 && r < R && c >= 0 && c < C && !vis[r][c] && color == arr[r][c]) { // if row and col are in bounds and its not visited
            vis[r][c] = true;
            count++;
            list.add(new Integer[] {r, c});
            floodfill(r-1, c, color);
            floodfill(r+1, c, color);
            floodfill(r, c-1, color);
            floodfill(r, c+1, color);
        }
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fin = new BufferedReader(new FileReader("mooyomooyo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        R = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken()); C = 10;
        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            String s = fin.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(s.substring(j, j+1));
            }
        }

        while (true) {
            boolean isValid = false;
            vis = new boolean[R][C];
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (arr[r][c] != 0 && !vis[r][c]) {
                        count = 0;
                        list = new ArrayList<>();
                        floodfill(r, c, arr[r][c]);
                        if (count >= K) {
                            isValid = true;
                            for (Integer[] a : list) {
                                arr[a[0]][a[1]] = 0;
                            }
                        }
                    }
                }
            }
            if (isValid) {
                for (int c = 0; c < C; c++) {
                    Queue<Integer> q = new LinkedList(); // keeps row of 0
                    for (int r = R-1; r >= 0; r--) {
                        if (arr[r][c] == 0) q.add(r);
                        else if (!q.isEmpty()) {
                            int low = q.poll();
                            arr[low][c] = arr[r][c];
                            arr[r][c] = 0;
                            q.add(r);
                        }
                    }
                }
            }
            else break;
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                out.print(arr[r][c]);
            }
            out.println();
        }
        out.close();
    }
}
