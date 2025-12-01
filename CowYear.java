import java.io.*;
import java.util.*;

public class CowYear { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        // input
        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken())+1; // # of years
        int K = Integer.parseInt(st.nextToken())-1; // # of jumps (subtracting 1 for the first jump)
        int[] arr = new int[N];
        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(fin.readLine());
        }
        Arrays.sort(arr);

        // group years into ranges of 12
        ArrayList<Integer> years = new ArrayList<>();
        for (int i = N-1; i >= 0;) {
            int lastYear = (int) Math.ceil(arr[i]/12.0) * 12;
            years.add(lastYear);
            while (i >= 0 && arr[i] > lastYear-12) {
                i--;
            }
        }

        // find waitime between every range
        int[] waitTime = new int[years.size()-1];
        for (int i = 0; i < years.size()-1; i++) {
            waitTime[i] = years.get(i)-years.get(i+1);
        }
        Arrays.sort(waitTime);

        // take sum of K smallest wait times
        int ans = 12*K;
        for (int i = 0; i < (waitTime.length-K); i++) {
            ans += waitTime[i];
        }
        System.out.println(ans);
    }
}
