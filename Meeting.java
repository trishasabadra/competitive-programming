import java.io.*;
import java.util.*;

public class Meeting { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(fin.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(fin.readLine());
            int[][] arr = new int[N][2];
            StringTokenizer st = new StringTokenizer(fin.readLine());
            for (int i = 0; i < N; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = i+1;
            }
            Arrays.sort(arr, (a,b)->(int)(b[0] - a[0])); // sorts from most to least sociability

            long counter = 0;
            ArrayList<Integer[]> ans = new ArrayList<>();
            int l = 0, r = 1;
            while (r < N) {
                while (arr[l][0] > 0 && arr[r][0] > 0) {
                    ans.add(new Integer[] {arr[r][1], arr[l][1]});
                    arr[l][0]--;
                    arr[r][0]--;
                    counter++;
                }
                if (arr[r][0] == 0) r++;
                if (arr[l][0] == 0) { l = r; r++; }
            }

            System.out.println(counter);
            for (int k = 0; k < counter; k++) {
                System.out.println(ans.get(k)[0] + " " + ans.get(k)[1]);
            }
        }
    }
}
