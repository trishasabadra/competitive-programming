import java.io.*;
import java.util.*;

public class Matrix { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());

        ArrayList<Integer>[] zero = new ArrayList[N]; // stores the positions of zeroes in the array sum
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            zero[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 0) zero[i].add(j);
            }
        }

        int[][] b = new int[N][N];
        int[] bSums = new int[N]; // sums of each col
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < N; j++) b[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) bSums[i] += b[j][i];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k : zero[i]) {
                    sum += b[k][j];
                }
                System.out.print(bSums[j]-sum + " ");
            }
            System.out.println();
        }

    }
}
