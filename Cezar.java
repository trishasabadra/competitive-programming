import java.io.*;
import java.util.*;

public class Cezar { // start class

    static boolean[] vis;
    static TreeSet<Integer>[] adj;
    static boolean hasCycles = false;
    public static void detectCycle(int num) {
        if (!vis[num]) {
            vis[num] = true;
            for (int n : adj[num]) {
                if (vis[n]) {
                    hasCycles = true; return;
                }
                detectCycle(n);
            }
        }
    }

    public static void topologicalSort(int num, ArrayList<Integer> arr) {
        vis[num] = true;
        for (int n : adj[num]) {
            if (!vis[n]) {
                topologicalSort(n, arr);
            }
        }
        arr.add(0, num);
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        // read input
        int N = Integer.parseInt(fin.readLine());
        String[] input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = fin.readLine();
        }

        // fixing order
        String[] strings = new String[N];
        StringTokenizer st = new StringTokenizer(fin.readLine());
        for (int i = 0; i < N; i++) {
            int j = Integer.parseInt(st.nextToken())-1;
            strings[i] = input[j];
        }

//        int N = 3;
//        String[] strings = {"ccc", "ddd", "bbb"};
//        int N = 5;
//        //String[] strings = {"ffbcd", "fa", "fabbf", "abfa", "abaa"};
//        String[] strings = {"efg", "c", "ca", "ab", "de"};

        // creating adjacency list
        adj = new TreeSet[26];
        int[] toCount = new int[26];
        for (int i = 0; i < 26; i++) {
            adj[i] = new TreeSet<>();
        }
        for (int i = 0; i < N-1; i++) {
            int j = i+1;
            boolean isSame = true;
            for (int k = 0; k < Math.min(strings[i].length(), strings[j].length()); k++) {
                if (strings[i].charAt(k) != strings[j].charAt(k)) {
                    isSame = false;
                    adj[strings[i].charAt(k)-97].add(strings[j].charAt(k)-97);
                    toCount[strings[j].charAt(k)-97]++;
                    break;
                }
            }
            // not possible
            if (isSame && strings[j].length() < strings[i].length()) {
                System.out.println("NE");
                System.exit(0);
            }
        }

        // check for cycles
        for (int i = 0; i < 26; i++) {
            vis = new boolean[26];
            detectCycle(i);
        }
        if (hasCycles) {
            System.out.println("NE");
            System.exit(0);
        }

        // topological sort
        vis = new boolean[26];
        ArrayList<Integer> order = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (!vis[i] && !adj[i].isEmpty() && toCount[i] == 0) {
                ArrayList<Integer> arr = new ArrayList<>();
                topologicalSort(i, arr);
                order.addAll(arr);
            }
        }

//        for (int i = 0; i < order.size(); i++) {
//            System.out.print((char) (order.get(i)+97) + " ");
//        }

        // creating alphabet
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < 26; i++) set.add(i);

        for (int i = 0; i < order.size(); i++) {
            alphabet[order.get(i)] = i;
            set.remove(i);
        }

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] == -1) {
                alphabet[i] = set.first();
                set.remove(set.first());
            }
            // alphabet[i] = order.get(i);
        }

        System.out.println("DA");
        for (int i = 0; i < 26; i++) {
            System.out.print((char) (alphabet[i]+97));
        }
    }
}
