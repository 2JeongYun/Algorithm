package HackerRank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {
    static final int INSERT = 1;
    static final int DELETE = 2;
    static final int CHECK = 3;

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> answer = new LinkedList<>();

        for (List<Integer> query : queries) {
            int operation = query.get(0);
            int value = query.get(1);
            int valueCnt = map.getOrDefault(value, 0);

            switch(operation) {
                case INSERT :
                    map.put(value, valueCnt + 1);
                    frequencyMap.put(valueCnt + 1, frequencyMap.getOrDefault(valueCnt + 1, 0) + 1);
                    frequencyMap.put(valueCnt, frequencyMap.getOrDefault(valueCnt, 1) - 1);
                    break;
                case DELETE :
                    if (valueCnt <= 1) {
                        map.put(value, 0);
                    } else {
                        map.put(value, map.get(value) - 1);
                    }

                    frequencyMap.put(valueCnt, frequencyMap.getOrDefault(valueCnt, 1) - 1);
                    frequencyMap.put(valueCnt - 1, frequencyMap.getOrDefault(valueCnt - 1, 0) + 1);
                    break;
                case CHECK :
                    int cnt = frequencyMap.getOrDefault(value, 0);
                    if (cnt > 0) {
                        answer.add(1);
                    } else {
                        answer.add(0);
                    }
                    break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

