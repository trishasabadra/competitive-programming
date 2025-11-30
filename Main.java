import java.io.*;
import java.util.*;

public class Main { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(fin.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            if (a == 1 && b > 2 || b == 1 && a > 2) {
                System.out.println(-1);
            }
            else if (a == b) {
                System.out.println((a-1)*2);
            }
            else if (Math.abs(a-b) == 1) {
                System.out.println(Math.min(a,b)*2-1);
            }
            else {
                System.out.println(a+b);
            }
        }
    }
}
