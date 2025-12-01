import java.io.*;
import java.util.*;

public class Banner { // start class

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }


//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int R = Integer.parseInt(st.nextToken())+1, C = Integer.parseInt(st.nextToken())+1, L1 = Integer.parseInt(st.nextToken()), L2 = Integer.parseInt(st.nextToken());

//        int R = 2, C = 3, L1 = 1, L2 = 2;

        long sum = 0;
        for (int x = 1; x < R; x++) {
            for (int y = 1; y < C; y++) {
                if (gcd(x, y) == 1 && L1*L1 <= x*x+y*y && x*x+y*y <= L2*L2) {
                    sum += (R-x)*(C-y)*2;
                }
            }
        }
        if (L1 == 1) sum += (C-1)*R+(R-1)*C;
        System.out.println(sum);
    }
}
