import java.io.*;
import java.util.*;

public class DPHPS { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new FileReader("hps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N]; // 0 = H; 1 = P; 2 = S;
        for (int i = 0; i < N; i++) {
            char a = fin.readLine().charAt(0);
            if (a == 'P') arr[i] = 1;
            else if (a == 'S') arr[i] = 2;
        }

        int[][] cur = new int[3][K+1], prev = new int[3][K+1]; // max points at each index, gesture, and # of switches
        prev[arr[0]][0] = 1;

        for (int i = 1; i < N; i++) { // index
            for (int g = 0; g < 3; g++) { // gesture
                for (int k = 0; k <= K; k++) { // switches
                    if (k > 0) cur[g][k] = Math.max(prev[g][k] + (arr[i] == g ? 1 : 0), prev[arr[i]][k-1]+1); // max (keep same gesture, switch gesture)
                    else cur[g][k] = prev[g][k] + (arr[i] == g ? 1 : 0);
                }
            }
            prev = cur.clone();
            cur = new int[3][K+1];
        }

        int ans = 0;
        for (int i = 0; i < 3; i++) { // gesture
            for (int k = 0; k <= K; k++) { // switches
                ans = Math.max(ans, prev[i][k]);
            }
        }

        out.println(ans);
        out.close();
    }
}
