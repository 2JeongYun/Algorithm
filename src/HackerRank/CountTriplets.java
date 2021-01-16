package HackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import java.lang.*;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long answer = 0;
        HashMap<Long, Long> firstMap = new HashMap<>();
        HashMap<Long, Long> secondMap = new HashMap<>();
        long curNum;

        for (int idx = 0; idx < arr.size(); idx++) {
            curNum = arr.get(idx);


            if (curNum % r == 0) {
                answer += secondMap.getOrDefault(curNum / r, 0L);
                secondMap.put(curNum, secondMap.getOrDefault(curNum, 0L) + firstMap.getOrDefault(curNum / r, 0L));
            }

            firstMap.put(curNum, firstMap.getOrDefault(curNum, 0L) + 1);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
