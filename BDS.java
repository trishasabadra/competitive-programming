import javax.swing.event.TreeSelectionEvent;
import java.io.*;
import java.util.*;

public class BDS { // start class

    static int S, N;

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
//        N = 3; S = 9;

        int[] arr = new int[N];
        TreeSet<Integer> t = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
            t.add(i+1);
        }

        Queue<ArrayList<Integer>> nums = new LinkedList<>();
        Queue<TreeSet<Integer>> sets = new LinkedList<>();
        nums.add(new ArrayList<>());
        sets.add(t);
        while (!nums.isEmpty()) {
            ArrayList<Integer> a = nums.poll();
            TreeSet<Integer> set = sets.poll();
            if (a.size() == N) {
                ArrayList<Integer> ar = (ArrayList<Integer>) a.clone();
                while (ar.size() > 1) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int i = 0; i < ar.size()-1; i++) {
                        temp.add(ar.get(i)+ar.get(i+1));
                    }
                    ar = (ArrayList<Integer>) temp.clone();
                }
                if (ar.get(0) == S) {
                    for (int i = 0; i < N; i++) {
                        System.out.print(a.get(i) + " ");
                    }
                    System.exit(0);
                }
            }
            else {
                for (int n : set) {
                    ArrayList<Integer> ar = (ArrayList<Integer>) a.clone();
                    ar.add(n);
                    TreeSet<Integer> temp = (TreeSet<Integer>) set.clone();
                    temp.remove(n);
                    nums.add(ar); sets.add(temp);
                }
            }
        }
    }
}
