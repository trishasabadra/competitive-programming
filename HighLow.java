import java.io.*;
import java.util.*;

public class HighLow { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fin = new BufferedReader(new FileReader("cardgame.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cardgame.out")));

        int N = Integer.parseInt(fin.readLine());
        TreeSet<Integer> e = new TreeSet<>(), b1 = new TreeSet<>(), b2 = new TreeSet<>();
        int[] el = new int[N];
        for (int i = 0; i < N; i++) {
            el[i] = Integer.parseInt(fin.readLine());
            e.add(el[i]);
        }
        for (int i = 1; i <= N*2; i++) {
            if (!e.contains(i)) {
                if (b1.size() < N/2) b1.add(i);
                else b2.add(i);
            }
        }

//        for (int i : b1) System.out.print(i + " ");
//        System.out.println();
//        for (int j : b2) System.out.print(j + " ");

        int count = 0;
        // first half (high wins)
        for (int i = 0; i < N/2; i++) {
            if (b2.higher(el[i]) != null) {
                b2.remove(b2.higher(el[i]));
                count++;
            }
        }
        // second half (lower wins)
        for (int i = N/2; i < N; i++) {
            if (b1.lower(el[i]) != null) {
                b1.remove(b1.lower(el[i]));
                count++;
            }
            else if (b2.lower(el[i]) != null) {
                b2.remove(b2.lower(el[i]));
                count++;
            }
        }
        out.println(count);
        out.close();
    }
}
