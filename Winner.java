import java.io.*;
import java.util.*;

public class Winner { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fin = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), A = Integer.parseInt(st.nextToken());
        Entry[] log = new Entry[N];
        TreeMap<Integer, HashSet<Integer>> map = new TreeMap<>(); // # of acorns : list of ID's that have that many acorns
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // ID : # of acorns
        HashSet<Integer> temp = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(fin.readLine());
            log[i] = new Entry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            treeMap.put(log[i].ID, A);
            temp.add(log[i].ID);
        }

        map.put(A, temp);
        Arrays.sort(log);
        int change = 0; // counts the changes in winners
        for (Entry e : log) {
            HashSet<Integer> oldWinners = new HashSet<>();
            oldWinners = (HashSet<Integer>) map.get(map.lastKey()).clone();
            // removing the ID from last place
            int value = treeMap.get(e.ID); // # of acorns e.ID has
            if (map.get(value).size() == 1) map.remove(value);
            else {
                temp = map.get(value);
                temp.remove(e.ID);
                map.put(value, temp);
            }
            // putting in new place
            value += e.increment;
            temp = map.getOrDefault(value, new HashSet<Integer>());
            temp.add(e.ID);
            map.put(value, temp);
            // updating treemap
            treeMap.put(e.ID, treeMap.get(e.ID)+ e.increment);
            if (e.day == log[0].day || !oldWinners.equals(map.get(map.lastKey()))) {
                change++; // if the original winner or number of winners does not match the new winners, there is a change
            }
        }
        out.println(change);
        out.close();
    }
}

class Entry implements Comparable<Entry> {
    Integer day, ID, increment;
    public Entry(int day, int ID, int increment) { // constructor
        this.day = day;
        this.ID = ID;
        this.increment = increment;
    }
    public int compareTo(Entry o) { // sorting method
        return day - o.day;
    }
}

/*
Solution:
map 1 - amount of milk : list of id's
map 2 - id : amount of milk
sort the log entries by the day #
iterate through the day
    get cur winners
    update cur winners
    if cur winners != new winners, increment counter
 */