import java.io.*;
import java.util.*;

public class SetIncrease { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        ArrayList<Stack<Integer>> sets = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(fin.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (sets.isEmpty() || sets.get(sets.size()-1).peek() > a) { // creates new group
                Stack<Integer> stack = new Stack<>();
                stack.push(a);
                sets.add(stack);
                continue;
            }

            // BINARY SEARCH TO FIND LARGEST NUMBER SMALLER THAN A
            int l = 0, r = sets.size()-1;
            while (l < r) {
                int m = (l+r)/2;
                if (sets.get(m).peek() < a) {
                    r = m;
                }
                else l = m+1;
            }
            sets.get(r).push(a);
        }

        for (Stack<Integer> s : sets) {
            for (int i : s) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
