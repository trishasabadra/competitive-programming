import java.io.*;
import java.util.*;

public class ParallelLines { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        int[] x = new int[N], y = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            x[i] = Integer.parseInt(st.nextToken()); y[i] = Integer.parseInt(st.nextToken());
        }

        TreeSet<Double> set = new TreeSet<>();
        boolean undefined = false;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int yDif = y[j]-y[i], xDif = x[j]-x[i];
                if (xDif == 0) undefined = true;
                else set.add(((double) yDif / xDif) + 1000);
            }
        }
        int inc = undefined ? 1 : 0;
        System.out.println(set.size()+inc);
    }
}
