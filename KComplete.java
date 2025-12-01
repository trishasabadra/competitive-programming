import java.io.*;
import java.util.*;

public class KComplete { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

//        int T = Integer.parseInt(fin.readLine());
        int T = 1;
        for (int t = 0; t < T; t++) {
//            StringTokenizer st = new StringTokenizer(fin.readLine());
//            int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), M = N/K; // length of word, size of group, # of groups
//            char[] c = fin.readLine().toCharArray();
            int N = 6, K = 3, M = 2;
            char[] c = "abaaba".toCharArray();

            TreeMap<Character, Integer> map = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                map.put(c[i], map.getOrDefault(c[i], 0)+1);
            }
            int min = 0;
            for (int v : map.values()) {
                min = Math.max(min, v);
            }
            min = N - min;

            if (K <= 2) {
                System.out.println(min);
                continue;
            }

//            TreeSet<String> arr = new TreeSet<>();
//            for (int i = 0; i < M; i++) { // iterates through all groups
//                // first half
//                StringBuilder sb = new StringBuilder();
//                sb.append(s.substring(i*K, i*K+(K+1)/2));
//                for (int j = i*K+K/2-1; j >= i*K; j--) {
//                    sb.append(s.substring(j, j+1));
//                }
//                arr.add(sb.toString());
//                // second half
//                sb = new StringBuilder();
//                for (int j = (i+1)*K-1; j >= (i+1)*K-K/2; j--) {
//                    sb.append(s.substring(j, j+1));
//                }
//                sb.append(s.substring((i+1)*K-K/2-1, (i+1)*K));
//                arr.add(sb.toString());
//            }
//
//            for (String str : arr) {
//                System.out.println(str);
//                int count = 0;
//                for (int i = 0; i < N;) {
//                    int k = 0;
//                    while (k < K) {
//                        count += str.charAt(k) == s.charAt(i) ? 0 : 1;
//                        k++; i++;
//                    }
//                }
//                System.out.println(count);
//                min = Math.min(min, count);
//            }
//            System.out.println(min);

            Queue<Integer> index = new LinkedList(), levels = new LinkedList(); // stores index of char and tree level
            boolean[] vis = new boolean[N];
            for (int i = 0; i < M; i++) { // iterate through all groups
                index.add(K/2 + K*i);
                levels.add(0);
                vis[K/2 + K*i] = true;
                if (K % 2 == 0) {
                    index.add(K/2 + K*i - 1);
                    levels.add(0);
                    vis[K/2 + K*i - 1] = true;
                }
            }

            map = new TreeMap<>();
            Character[] ans = new Character[K];
            while (!index.isEmpty()) {
                int x = index.poll(), lev = levels.poll(); // remove current number and layer
                map.put(c[x], map.getOrDefault(c[x], 0)+1);

                if (x-1 >= 0 && !vis[x-1]) {
                    index.add(x-1);
                    levels.add(lev+1);
                    vis[x-1] = true;
                }
                if (x+1 < N && !vis[x+1]) {
                    index.add(x+1);
                    levels.add(lev+1);
                    vis[x+1] = true;
                }

                if (!levels.isEmpty() && levels.peek() != lev) { // next level
                    int max = 0; char m = 'a';
                    for (Character key : map.keySet()) {
                        if (map.get(key) > max) {
                            max = map.get(key);
                            m = key;
                        }
                    }
                    ans[lev] = m;
                    map = new TreeMap<>();
                }
            }

            int count = 0, i = 0;
            while (i < N) {
                int k = 0;
                while (k < K) {
                    count += ans[k] == c[i] ? 0 : 1;
                    k++; i++;
                }
            }
            min = Math.min(min, count);
            System.out.println(min);

        }
    }
}
