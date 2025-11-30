import java.io.*;
import java.util.*;

public class LetterFlip  { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        char[] s = fin.readLine().toCharArray(), t = fin.readLine().toCharArray();

        TreeMap<Character, Character> set = new TreeMap<>(); // old char : new char
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!set.containsKey(s[i])) { // changes all s[i] to t[i]
                set.put(s[i], t[i]);
                if (s[i] != t[i]) count++;
            }
            else if (set.get(s[i]) != t[i]) { // not possible
                System.out.println(-1);
                System.exit(0);
            }
        }
        System.out.println(count);
    }
}

