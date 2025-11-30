import java.io.*;
import java.util.*;

public class StringEditDist { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        char[] s1 = fin.readLine().toCharArray(), s2 = fin.readLine().toCharArray();

//        char[] s1 = "SUNDAY".toCharArray(), s2 = "SATURDAY".toCharArray();

        int[] prev, cur = new int[s2.length];
        for (int i = 0; i < s1.length; i++) {
            prev = cur.clone();
            cur = new int[s2.length];
            for (int j = 0; j < s2.length; j++) {
                if (i == 0 && j == 0) {
                    if (s1[i] != s2[j]) cur[j]++;
                    continue;
                }
                // min(delete, insert, replace)
                int del = Integer.MAX_VALUE, add = Integer.MAX_VALUE, rep = Integer.MAX_VALUE;
                if (i > 0) del = prev[j]+1;
                if (j > 0) add = cur[j-1]+1;
                if (i > 0 && j > 0) {
                    rep = prev[j-1];
                    if (s1[i] != s2[j]) rep++;
                }
                cur[j] = Math.min(del, Math.min(add, rep));
            }
        }

        System.out.println(cur[s2.length-1]);
    }
}
