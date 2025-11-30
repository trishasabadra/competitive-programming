import java.io.*;
import java.util.*;

public class DiceGame {

    public static void main(String[] args) throws Exception {

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(fin.readLine());

        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        double[] a = new double[m+A+1], b = new double[m+A+1];
        a[0] = 1; b[0] = 0;
        for(int i = 1; i <= m + A; i++) {
            for(int j = 1; j <= A && i-j >= 0; j++) {
                if(i-j > m) continue;
                a[i] += (double) 1/A * b[i-j];
            }

            for(int j = 1; j <= B && i-j >= 0; j++) {
                if(i-j > m) continue;
                b[i] += (double) 1/B * a[i-j];
            }
        }

        double ans = 0;
        for(int i = m+1; i <= m+A; i++) {
            ans += a[i];
        }
        System.out.format("%.4f", ans);
    }
}


