import java.io.*;
import java.util.*;

public class RearrangeGifts { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        int[][] arr = new int[N][N];
        int[] curPlace = new int[N]; // curPlace[i] = index of gift cow i gets

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken())-1;
                if (arr[i][j] == i) curPlace[i] = j;
            }
        }

        for (int i = 0; i < N; i++) {
            if (curPlace[i] > 0) {
                for (int j = i + 1; j < N; j++) { // cow j

                    int jgift = 0, igift = 0;
                    for (int k = 0; k < N; k++) {
                        if (arr[j][curPlace[j]] == arr[i][k]) { // found j's gift in i
                            jgift = k;
                        }
                        if (arr[i][curPlace[i]] == arr[j][k]) { // found i's gift in j
                            igift = k;
                        }
                    }

                    //System.out.println(i+1 + " " + (j+1) + " " + jgift  + " " + igift + " "+ curPlace[i] +" "+ curPlace[j]);
                    if (jgift < curPlace[i] && igift < curPlace[j]) { // swap gifts
                        curPlace[i] = jgift;
                        curPlace[j] = igift;
                    }
                }
            }
            System.out.println(arr[i][curPlace[i]]+1);
        }
    }
}
