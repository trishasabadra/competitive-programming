import java.io.*;
import java.util.*;

public class Stuck { // start class

    static ArrayList<Integer>[] adj;
    static int counter = 0;

    public static void dfs(int num) {
        for (int n : adj[num]) {
            counter++;
            dfs(n);
        }
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        int[][] arr = new int[N][2];
        boolean[] isNorth = new boolean[N];
        int n = 0, e = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            char dir = st.nextToken().charAt(0);
            arr[i][0] = Integer.parseInt(st.nextToken()); arr[i][1] = Integer.parseInt(st.nextToken());
            isNorth[i] = dir == 'N';
            if (isNorth[i]) n++; else e++;
        }

        int[][] north = new int[n][3], east = new int[e][3];
        n = 0; e = 0;
        for (int i = 0; i < N; i++) {
            if (isNorth[i]) {
                north[n][0] = arr[i][0]; north[n][1] = arr[i][1]; north[n][2] = i;
                n++;
            }
            else {
                east[e][0] = arr[i][0]; east[e][1] = arr[i][1]; east[e][2] = i;
                e++;
            }
        }

//        int N = 6;
//        int n = 2, e = 4;
//        int[][] north = {{11, 1, 4}, {5, 3, 1}}, east = {{3, 5, 0}, {4, 6, 2}, {10, 4, 3}, {9, 2, 5}};

        Arrays.sort(north, (a,b)->(int)(a[0] - b[0])); // sorts based on x
        Arrays.sort(east, (a,b)->(int)(a[1] - b[1])); // sorts based on y

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        boolean[] blocked = new boolean[N];
        for (int i = 0; i < n; i++) {
            int nx = north[i][0], ny = north[i][1], ni = north[i][2];
            for (int j = 0; j < e; j++) {
                int ex = east[j][0], ey = east[j][1], ei = east[j][2];

                if (nx >= ex && ey >= ny && !blocked[ei] && !blocked[ni]) { // if they intersect and neither are already blocked
                    if (ey-ny > nx-ex) { // east blocks north
                        blocked[ni] = true;
                        adj[ei].add(ni);
                        break;
                    }
                    else if (ey-ny < nx-ex) { // north blocks east
                        blocked[ei] = true;
                        adj[ni].add(ei);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            counter = 0;
            dfs(i);
            System.out.println(counter);
        }
    }
}


