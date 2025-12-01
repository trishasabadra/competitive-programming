import java.io.*;
import java.util.*;

public class Meetings { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fin = new BufferedReader(new FileReader("meetings.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
        Point[] arr = new Point[N];
        int totalWeight = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(fin.readLine());
            int w = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            arr[i] = new Point(w, p, d);
            totalWeight += w;
        }
        Arrays.sort(arr);

//        int N = 3, L = 5;
//        Point[] arr = {new Point(1, 1, 1), new Point(2, 2, -1), new Point(3, 3, -1)};
//        int totalWeight = 6;

        int curWeight = 0, totalMeetings = 0;
        int s = 0, e = N;
        while (curWeight < totalWeight/2) {
            // FINDING EARLIEST INTERSECTION
            TreeSet<Double> right = new TreeSet<>(), left = new TreeSet<>();
            for (int i = s; i < e; i++) {
                if (arr[i].dir == 1) right.add(arr[i].pos);
                else left.add(arr[i].pos);
            }
            double minDist = arr[N-1].pos-arr[0].pos, rp = 0, lp = 0;
            boolean isDone = false; // if there are no intersections, you are done
            for (Double p : right) { // positions that go right
                if (left.higher(p) != null) {
                    if (left.ceiling(p)-p < minDist) {
                        minDist = left.higher(p)-p; rp = left.higher(p); lp = p;
                    }
                }
                else {
                    if (p == right.first()) isDone = true;
                    break;
                }
            }
            if (isDone) break;

            for (int i = s; i < e; i++) { //updates the positions to the new time
                arr[i].pos += (arr[i].dir * (rp-lp)/2);
            }
            // updates the points that have reached a barn
            Arrays.sort(arr);
            int n = e;
            for (int i = s; i < n; i++) {
                if (arr[i].pos <= 0) {
                    s++; curWeight += arr[i].weight;
                }
                else if (arr[i].pos >= L) {
                    e--; curWeight += arr[i].weight;
                }
            }
            // checks for intersections and updates velocities
            for (int i = s; i < e-1; i++) {
                if (arr[i].pos == arr[i+1].pos) {
                    totalMeetings++;
                    arr[i].dir *= (-1);
                    arr[i+1].dir *= (-1);
                }
            }
        }
        out.println(totalMeetings);
        out.close();
    }
}

class Point implements Comparable<Point> {
    int weight, dir;
    double pos;
    private int x;

    public Point(int weight, int pos, int dir) { // constructor
        this.weight = weight;
        this.pos = pos;
        this.dir = dir;
    }
    public int compareTo(Point o) { // sorting method
        return Double.compare(pos, o.pos);
    }
}

