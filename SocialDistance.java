import java.io.*;
import java.util.*;

public class SocialDistance { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(fin.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(fin.readLine());
            int[] pos = new int[N], dist = new int[N];
            for (int i = 0; i < N; i++) dist[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(dist);

            boolean inValid = false;
            for (int i = 0; i < N; i++) {
                if (i == 0) pos[i] = dist[i];
                else {
                    int p = Math.max(dist[i], dist[i-1]) + pos[i-1] + 1;
                    if (p < M && M-p+pos[0]-1 >= dist[i]) pos[i] = p;
                    else {
                        inValid = true;
                        break;
                    }
                }
            }
            //for (int i = 0; i < N; i++) System.out.print(pos[i] + " ");
            if (inValid) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
