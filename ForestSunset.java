import java.io.*;
import java.util.*;

public class ForestSunset { // start class

    static TreeMap<Long, Long> multiset;
    // ADD FUNCTION FOR MULTISET (adds one occurrence of a number)
    public static void add(long i) {
        multiset.put(i, multiset.getOrDefault(i, 0L)+1);
    }
    // REMOVE FUNCTION FOR MULTISET (removes one occurrence of a number)
    public static void remove(long i) {
        multiset.put(i, multiset.get(i)-1);
        if (multiset.get(i) == 0) multiset.remove(i);
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(fin.readLine());
        Tree[] positions = new Tree[N*2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken()), h = Long.parseLong(st.nextToken());
            positions[i*2] = new Tree(a, true, h); positions[i*2+1] = new Tree(b, false, h);
        }
        Arrays.sort(positions);

        multiset = new TreeMap<>();
        long total = 0, lastPos = positions[0].pos;
        for (int i = 0; i < positions.length;) {
            long cur = positions[i].pos;
            if (!multiset.isEmpty()) total += (cur - lastPos) * multiset.lastKey();
            lastPos = cur;

            while (i < 2*N && positions[i].pos == cur) {
                if (positions[i].isStart) add(positions[i].height);
                else remove(positions[i].height);
                i++;
            }
        }
        System.out.println(total);
    }
}

class Tree implements Comparable<Tree> {
    long pos, height;
    boolean isStart;
    public Tree(long pos, boolean isStart, long height) { // constructor
        this.pos = pos;
        this.isStart = isStart;
        this.height = height;
    }
    public int compareTo(Tree o) { // sorting method
        return (int) (pos - o.pos);
    }
}

