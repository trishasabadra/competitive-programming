import java.io.*;
import java.util.*;

public class SplittingField { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
//
////        BufferedReader fin = new BufferedReader(new FileReader("split.in"));
////        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("split.out")));
//
//        int N = Integer.parseInt(fin.readLine());
//        int[][] points = new int[N][2];
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(fin.readLine());
//            points[i][0] = Integer.parseInt(st.nextToken());
//            points[i][1] = Integer.parseInt(st.nextToken());
//        }

        int N = 5;
        int[][] points = {{1, 1}, {3, 3}, {5, 5}, {1, 5}, {5,1}};

        Arrays.sort(points, (a,b)->(int)(a[0] - b[0])); // sorts based on x
        // LEFT
        int minX = 1000000000, maxX = 0, minY = 1000000000, maxY = 0;
        ArrayList<Long> leftArea = new ArrayList<>();
        leftArea.add((long) 0);
        for (int i = 0; i < N; i++) {
            while (i < N-1 && points[i][0] == points[i+1][0]) {
                i++;
            }
            minX = Math.min(minX, points[i][0]); maxX = Math.max(maxX, points[i][0]);
            minY = Math.min(minY, points[i][1]); maxY = Math.max(maxY, points[i][1]);
            if ((maxX - minX) * (maxY - minY) == 0) leftArea.add((long)1);
            else leftArea.add((long) (maxX - minX) * (maxY - minY));
        }
        // RIGHT
        minX = 1000000000; maxX = 0; minY = 1000000000; maxY = 0;
        ArrayList<Long> rightArea = new ArrayList<>();
        for (int i = N-1; i >= 0; i--) {
            while (i > 0 && points[i][0] == points[i-1][0]) {
                minY = Math.min(minY, points[i][1]); maxY = Math.max(maxY, points[i][1]);
                i--;
            }
            minX = Math.min(minX, points[i][0]); maxX = Math.max(maxX, points[i][0]);
            minY = Math.min(minY, points[i][1]); maxY = Math.max(maxY, points[i][1]);
            if ((maxX - minX) * (maxY - minY) == 0) rightArea.add((long)1);
            else rightArea.add((long) (maxX - minX) * (maxY - minY));
        }
        rightArea.add((long)0);

        Arrays.sort(points, (a,b)->(int)(a[1] - b[1])); // sorts based on y
        // UP
        minX = 1000000000; maxX = 0; minY = 1000000000; maxY = 0;
        ArrayList<Long> upArea = new ArrayList<>();
        upArea.add((long)0);
        for (int i = 0; i < N; i++) {
            while (i < N-1 && points[i][1] == points[i+1][1]) {
                minX = Math.min(minX, points[i][0]); maxX = Math.max(maxX, points[i][0]);
                i++;
            }
            minX = Math.min(minX, points[i][0]); maxX = Math.max(maxX, points[i][0]);
            minY = Math.min(minY, points[i][1]); maxY = Math.max(maxY, points[i][1]);
            if ((maxX - minX) * (maxY - minY) == 0) upArea.add((long)1);
            else upArea.add((long) (maxX - minX) * (maxY - minY));
        }
        // DOWN
        minX = 1000000000; maxX = 0; minY = 1000000000; maxY = 0;
        ArrayList<Long> downArea = new ArrayList<>();
        for (int i = N-1; i >= 0; i--) {
            while (i > 0 && points[i][1] == points[i-1][1]) {
                minX = Math.min(minX, points[i][0]); maxX = Math.max(maxX, points[i][0]);
                i--;
            }
            minX = Math.min(minX, points[i][0]); maxX = Math.max(maxX, points[i][0]);
            minY = Math.min(minY, points[i][1]); maxY = Math.max(maxY, points[i][1]);
            if ((maxX - minX) * (maxY - minY) == 0) leftArea.add((long)1);
            else leftArea.add((long) (maxX - minX) * (maxY - minY));
        }
        downArea.add((long)0);
        // FIND MIN
        long min = (long) 1e+18;
        for (int i = 0; i < leftArea.size(); i++) {
            min = Math.min(min, leftArea.get(i)+rightArea.get(i));
            min = Math.min(min, upArea.get(i)+downArea.get(i));
        }
        System.out.println(rightArea.get(0)-min);

//        out.println(rightArea[0]-min);
//        out.close();
    }
}
