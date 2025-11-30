import java.io.*;
import java.util.*;

public class EmailFiling { // start class

    static TreeMap<Integer, Integer> multiset;
    // ADD FUNCTION FOR MULTISET (adds one occurrence of a number)
    public static void add(int i) {
        multiset.put(i, multiset.getOrDefault(i, 0)+1);
    }
    // REMOVE FUNCTION FOR MULTISET (removes one occurrence of a number)
    public static void remove(int i) {
        multiset.put(i, multiset.get(i)-1);
        if (multiset.get(i) == 0) multiset.remove(i);
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(fin.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()); // # of files, # of emails, size
            TreeMap<Integer, Integer> emails = new TreeMap<>(); // index : folder
            // multiset = new TreeMap<>();
            st = new StringTokenizer(fin.readLine());
            for (int i = 0; i < N; i++) {
                emails.put(i, Integer.parseInt(st.nextToken())-1);
                // add(emails[i]);
            }

            int k = 0; // window for emails goes from k -> k+K
            // TreeSet<Integer> vis = new TreeSet<>();

//            TreeMap<Integer, Integer> map = new TreeMap<>();
//            while (k < K) { // adds more emails till capacity
//                map.put(emails[k], multiset.getOrDefault(emails[k], 0)+1);
//                k++;
//            }

            int r = 0; // window of folders is from r -> r+K
            while (!emails.isEmpty() && r < M) {
                // try to use as many emails in current window as possible
                for (int i = k; i < k+K && i < N && !emails.isEmpty(); i++) { // go down range
                    if (emails.containsKey(i) || r <= emails.get(i) && emails.get(i) < r+K) { // in range
                        emails.remove(i);
                        k++;
                    }
                }
                // go up range
                if (k+K >= N) {
                    k = N-K;
                    for (int i = N-1; i > 0 && i > k && !emails.isEmpty(); i--) {
                        if (emails.containsKey(i) || r <= emails.get(i) && emails.get(i) < r + K) { // in range
                            emails.remove(i);
                            k--;
                        }
                    }
                }
                // move down email if lower in the list, there is an email with the top folder
                boolean downFolder = true;
                for (int i = k+K; i < N; i++) {
                    if (emails.get(i) == k) {
                        downFolder = false;
                        k = i; break;
                    }
                }
                // if you don't need to move down an email, move down a folder
                if (downFolder) r++;
            }

            if (!emails.isEmpty()) System.out.println("NO");
            else System.out.println("YES");

        }
    }
}
