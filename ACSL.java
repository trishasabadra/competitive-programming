import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ACSL {

    /*
     * Complete the 'printNumbers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER fibNumber as parameter.
     */

    public static String printNumbers(int fibNumber) {
        int prev = 1, cur = 1, count = 2;
        while (cur != fibNumber) {
            int t = cur;
            cur += prev;
            prev = t;
            count++;
        }

        int[][] pt = new int[count][count];
        for (int i = 0; i < count; i++) {
            pt[i][0] = 1; pt[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pt[i][j] = pt[i-1][j-1] + pt[i-1][j];
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = count-1, j = 0; pt[i][j] != 0; i--, j++) {
            ans.append(pt[i][j] + " ");
        }
        return ans.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(printNumbers(5));
    }

}

