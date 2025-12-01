import java.io.*;
import java.util.*;

// sort the odd digits ascendengly and even digits descendengly
public class StringSort { // start class

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(fin.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        String2[] arr = new String2[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new String2(fin.readLine(), i+1);
        }

        // int N = 3;
//        String2[] arr = {new String2("AA", 1), new String2("AB", 2), new String2("BB", 3), new String2("BA", 4),
//                new String2("AZ", 5)};
//        String2[] arr = {new String2("AAD", 1), new String2("AAC", 2), new String2("BAB", 3)};

        Arrays.sort(arr);

        for (String2 str : arr) {
            System.out.print(str.index + " ");
//            System.out.println(str.str);
        }
    }
}

class String2 implements Comparable<String2> {
    String str;
    int index;
    private String s;

    public String2(String str, int index) { // constructor
        this.str = str;
        this.index = index;
    }
    public int compareTo(String2 o) { // sorting method
        int i = 0;
        while (i < str.length()-1 && str.charAt(i) == o.str.charAt(i)) {
            if (str.charAt(i+1) != o.str.charAt(i+1)) {
                if (i % 2 == 1) return str.compareTo(o.str);
                else return o.str.compareTo(str);
            }
            i++;
        }
        return str.compareTo(o.str);
    }
}
