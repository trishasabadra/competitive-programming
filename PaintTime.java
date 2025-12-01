import java.io.*;
import java.util.*;

public class PaintTime { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(fin.readLine());
//        int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
//        char[] letters = fin.readLine().toCharArray();

        int N = 100, Q = 1;
        // AADCBBADC
        String s = "TDVTKTFDVTDTFCTDFKKKVTCTVCTFFTVTVFKCFTVKTKCTDVTCTFVKKKDCKKFKTDCTKTVTTTCFDKVTTFKTTDTKCDVTVVFTDCCTVKTF";
        char[] letters = s.toCharArray();
//        char[] letters = {'A', 'A', 'D', 'C', 'B', 'B', 'A', 'D', 'C'};

        TreeSet<Integer>[] pos = new TreeSet[26]; // stores the positions of each letter
        for (int i = 0; i < 26; i++) {
            pos[i] = new TreeSet<>();
        }

        int[] rightPrefix = new int[N+1]; // -->
        rightPrefix[1] = 1; pos[letters[0]-65].add(0);
        for (int i = 1; i < N; i++) {
            int index = letters[i]-65;
            rightPrefix[i+1] += rightPrefix[i];
            if (letters[i] != letters[i-1]) {
                if (pos[index].size() > 0) {
                    for (int j = 0; j < index; j++) { // if there is a lighter color that occurs between the last and current occurrence of this color
                        if (pos[j].higher(pos[index].last()) != null) {
                            rightPrefix[i+1]++; break;
                        }
                    }
                }
                else rightPrefix[i+1]++; // if this color occurs for the first time
            }
            pos[index].add(i);
        }

        for (int i = 0; i <= N; i++) {
            System.out.print(rightPrefix[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < 26; i++) {
            pos[i] = new TreeSet<>();
        }
        int[] leftPrefix = new int[N]; // <--
        leftPrefix[N-1] = 1; pos[letters[N-1]-65].add(N-1);
        for (int i = N-2; i >= 0; i--) {
            int index = letters[i]-65;
            leftPrefix[i] += leftPrefix[i+1];
            if (letters[i] != letters[i+1]) {
                if (pos[index].size() > 0) {
                    for (int j = 0; j < index; j++) { // if there is a lighter color that occurs between the last and current occurrence of this color
                        if (pos[j].lower(pos[index].last()) != null) {
                            leftPrefix[i]++; break;
                        }
                    }
                }
                else leftPrefix[i]++; // if this color occurs for the first time
            }
            pos[index].add(i);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(leftPrefix[i] + " ");
        }
        System.out.println();

//        for (int i = 0; i < Q; i++) {
//            st = new StringTokenizer(fin.readLine());
//            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken());
//            if (b == N) System.out.println(rightPrefix[a]);
//            else System.out.println(rightPrefix[a] + leftPrefix[b]);
//            int a = 9, b = 9;
//            System.out.println(rightPrefix[8]);
//        }
    }
}
