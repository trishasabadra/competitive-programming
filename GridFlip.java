import java.io.*;
import java.util.*;

public class GridFlip { // start class

    static int R, C;
    static ArrayList<TreeSet<Integer>> sets = new ArrayList<>();
    static boolean[][] newGrid;

    static public void combinations(TreeSet<Integer> set) {
        sets.add(set);
        for (int i = set.last(); i < C; i++) {
            if (!set.contains(i)) {
                TreeSet<Integer> temp = (TreeSet<Integer>) set.clone();
                temp.add(i);
                combinations(temp);
            }
        }
    }

    public static void flip(int r, int c) {
        newGrid[r][c] = !newGrid[r][c];
        if (c-1 >= 0) newGrid[r][c-1] = !newGrid[r][c-1];
        if (c+1 < C) newGrid[r][c+1] = !newGrid[r][c+1];
        if (r-1 >= 0) newGrid[r-1][c] = !newGrid[r-1][c];
        if (r+1 < R) newGrid[r+1][c] = !newGrid[r+1][c];
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        boolean[][] grid = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < C; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken()) == 0;
            }
        }

//        R = 4; C = 4;
//        boolean[][] grid = {{true, false, false, true}, {false, false, false, false}, {false, false, false, false}, {true, false, false, true}};

        // create all combinations
        sets.add(new TreeSet<>());
        for (int i = 0; i < C; i++) {
            TreeSet<Integer> t = new TreeSet<>();
            t.add(i);
            combinations(t);
        }

        boolean isPossible = false;
        int minCount = R*C;
        int[][] finGrid = new int[R][C]; // answer grid
        for (int i = 0; i < R; i++) {
            Arrays.fill(finGrid[i], 1);
        }

        // for all possible combinations of the first row
        for (TreeSet<Integer> set : sets) {
            // copy new grid
            newGrid = new boolean[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    newGrid[i][j] = grid[i][j];
                }
            }
            // set first row
            int[][] ans = new int[R][C];
            for (int i : set) {
                // flipping
                flip(0, i);
                ans[0][i]++;
            }
            // set remaining rows
            for (int i = 1; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (!newGrid[i-1][j]) { // if above is 1
                        flip(i, j);
                        ans[i][j]++;
                    }
                }
            }
            // count answer
            int count = 0;
            boolean isValid = true;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (!newGrid[i][j]) {
                        isValid = false;
                        break;
                    }
                    count += ans[i][j];
                }
            }
            if (isValid && count <= minCount) {
                isPossible = true;
                boolean isSmaller = true;
                if (count == minCount) { // if same count, find lexicographical smaller ordering
                    StringBuilder a = new StringBuilder(), b = new StringBuilder();
                    for (int i = 0; i < R; i++) {
                        for (int j = 0; j < C; j++) {
                            a.append(ans[i][j]);
                            b.append(finGrid[i][j]);
                        }
                    }
                    // if a is NOT smaller than b, do nothing
                    if (a.toString().compareTo(b.toString()) >= 0) isSmaller = false;
                }
                if (isSmaller) { // if better answer, copy the current answer
                    minCount = count;
                    for (int i = 0; i < R; i++) {
                        for (int j = 0; j < C; j++) {
                            finGrid[i][j] = ans[i][j];
                        }
                    }
                }
            }
        }

        if (isPossible) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(finGrid[i][j] + " ");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("IMPOSSIBLE");
        }

    }
}

