import java.io.*;
import java.util.*;

public class Invite { // start class

    static boolean[] vis, done;
    static TreeSet<Integer>[] groups;
    static int N, G;
    static int invite = 0;

    public static void dfs(int num) {
        if (!vis[num]) {
            vis[num] = true;
            invite++;
            for (int i = 0; i < G; i++) {
                if (!done[i]) { // if the entire group is not invited yet
                    ArrayList<Integer> notVis = new ArrayList<>();
                    for (int n : groups[i]) { // check how many are already invited
                        if (!vis[n]) notVis.add(n);
                        if (notVis.size() == 2) break;
                    }
                    if (notVis.size() == 1) { // must invite the rest of the group
                        done[i] = true;
                        dfs(notVis.get(0));
                    }
                }
            }
        }
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        N = Integer.parseInt(st.nextToken())+1; G = Integer.parseInt(st.nextToken());

        groups = new TreeSet[G];
        vis = new boolean[N];
        done = new boolean[G];

        for (int i = 0; i < G; i++) {
            st = new StringTokenizer(fin.readLine());
            int S = Integer.parseInt(st.nextToken());
            groups[i] = new TreeSet<>();
            for (int j = 0; j < S; j++) {
                int a = Integer.parseInt(st.nextToken());
                groups[i].add(a);
            }
        }

        dfs(1);
        System.out.println(invite);
    }
}
