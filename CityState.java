import java.io.*;
import java.util.*;

public class CityState { // start class

    static TreeMap<String, TreeMap<String, Integer>> map;
    public static void add(String key, String value) {
        TreeMap<String, Integer> temp = map.getOrDefault(key, new TreeMap<>());
        temp.put(value, temp.getOrDefault(value, 0)+1);
        map.put(key, temp);
    }

//_______________________________main method__________________________________

    public static void main(String args[]) throws IOException { // start method

//        BufferedReader fin = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fin = new BufferedReader(new FileReader("citystate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));

        int N = Integer.parseInt(fin.readLine());
        map = new TreeMap<>();
        int counter = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(fin.readLine());
            String city = st.nextToken().substring(0, 2), state = st.nextToken();
            if (!city.equals(state) && map.containsKey(state) && map.get(state).containsKey(city)) counter += map.get(state).get(city);
            add(city, state);
        }
//        System.out.println(counter);

        out.println(counter);
        out.close();
    }
}