import java.io.*;
import java.util.*;

public class RankFile { // start class

    static List[] arr;
    static int N, ans;
    static boolean isDone;
    static int[][] grid;
    public static void recur (int num, ArrayList<Integer> indexes) {
        if (indexes.size() == N) {
            boolean[] used = new boolean[N*2-1];
            grid = new int[N][N]; // columns
            for (int i = 0; i < N; i++) {
                used[indexes.get(i)] = true;
                for (int j = 0; j < N; j++) {
                    grid[j][i] = arr[indexes.get(i)].list[j];
                }
            }
            ArrayList<Integer> notUsed = new ArrayList<>();
            for (int i = 0; i < N*2-1; i++) if (!used[i]) notUsed.add(i);
            isDone = true;
            for (int i = 0; i < N-1; i++) { // index of columns
                ans = -1;
                boolean isSame = true;
                for (int k = 0; k < N; k++) {
                    if (grid[i][k] != arr[notUsed.get(i)].list[k]) {
                        if (ans == -1) ans = k;
                        else {
                            isSame = false;
                            break;
                        }
                    }
                }
                if (!isSame) {
                    isDone = false;
                    break;
                }
            }
            return;
        }

        indexes.add(num);
        for (int i = num+1; i < N*2-1; i++) {
            recur(i, indexes);
        }
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(fin.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(fin.readLine());
            arr = new List[N * 2 - 1];
            for (int i = 0; i < N*2-1; i++) {
                StringTokenizer st = new StringTokenizer(fin.readLine());
                arr[i] = new List(new int[N]);
                for (int j = 0; j < N; j++) {
                    arr[i].list[j] = Integer.parseInt(st.nextToken());
                }
            }
            Arrays.sort(arr);

//            for (List i : arr) {
//                for (int j = 0; j < i.list.length; j++) {
//                    System.out.print(i.list[j] + " ");
//                }
//                System.out.println();
//            }

            int f = arr[0].list[0]; // top left corner
            int i = 0;
            while (i < N && arr[i].list[0] == f) {
                recur(i, new ArrayList<>());
                if (isDone) {
                    for (int j = 0; j < N; j++) {
                        System.out.println(grid[ans][j] + " ");
                    }
                    System.out.println();
                }
            }

        }
    }
}
class List implements Comparable<List> {
    int[] list;
    public List(int[] list) { // constructor
        this.list = list;
    }
    public int compareTo(List o) { // sorting method
        for (int i = 0; i < list.length; i++) {
            if (o.list[i] < list[i]) return 1;
            else if (list[i] < o.list[i]) return -1;
        }
        return 0;
    }
}


