import java.io.*;
import java.util.*;

public class PerfectKeyboard { // start class

    static boolean[] vis;
    static TreeSet<Integer>[] adj;
    static ArrayList<Integer> comp;
    // static boolean isValid;

    public static void dfs(int num) {
        vis[num] = true;
        for (int n : adj[num]) {
            if (!vis[n]) {
//                if (comp.get(comp.size()-1) != num) comp.add(0, n);
//                else comp.add(n);
                comp.add(n);
                dfs(n);
            }
//            else if (comp.indexOf(num) == 0 || comp.get(comp.indexOf(num)-1) != n) isValid = false;
        }
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(fin.readLine());
//        int T = 1;
        for (int t = 0; t < T; t++) {
            // isValid = true;
            char[] c = fin.readLine().toCharArray();
//            char[] c = "zxzytyz".toCharArray();
            adj = new TreeSet[26];
            for (int i = 0; i < 26; i++) {
                adj[i] = new TreeSet<>();
            }

            for (int i = 0; i < c.length-1; i++) {
                adj[c[i]-97].add(c[i+1]-97);
                adj[c[i+1]-97].add(c[i]-97);
            }

            boolean isValid = true;
            ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
            vis = new boolean[26];
            for (int i = 0; i < 26; i++) {
                if (!vis[i] && adj[i].size() <= 1) {
                    comp = new ArrayList<>();
                    comp.add(i);
                    dfs(i);
                    comps.add(comp);
                }
                else if (adj[i].size() > 2) isValid = false;
            }

            for (int i = 0; i < 26; i++) {
                if (!vis[i]) {
                    isValid = false; break;
                }
            }

            if (!isValid) {
                System.out.println("NO");
                continue;
            }

            System.out.println("YES");
            for (ArrayList<Integer> a : comps) {
                for (int n : a) {
                    System.out.print((char) (n+97));
                }
            }
            System.out.println();
        }
    }
}
