package hackerRank.interviewPreparationKit.greedyAlgorithms;

import java.io.*;
import java.util.*;

public class ReverseShuffleMerge {
    static public HashMap<Integer, Integer> sRemain = new HashMap<>();
    static public HashMap<Integer, Integer> rRemain;

    // Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i);
            sRemain.put(cur, sRemain.getOrDefault(cur, 0) + 1);
        }
        for (int key : sRemain.keySet()) {
            sRemain.put(key, sRemain.get(key) / 2);
        }
        rRemain = (HashMap<Integer, Integer>) sRemain.clone();

        PriorityQueue<Integer> pQue = new PriorityQueue<>();
        StringBuffer ret = new StringBuffer();
        int rIdx = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = s.charAt(i);
            pQue.add(cur);
            sRemain.put(cur, sRemain.get(cur) - 1);
            if (sRemain.get(cur) == -1) {
                rIdx = makeString(ret, pQue, i, rIdx, s);
            }
        }

        return ret.toString();
    }

    static int makeString(StringBuffer ret, PriorityQueue<Integer> pQue, int blockIdx, int rIdx, String s) {
        while (pQue.isEmpty() == false && sRemain.get((int) s.charAt(blockIdx)) < 0) {
            int min = pQue.poll();
            for (int i = rIdx; i >= blockIdx; i--) {
                int cur = s.charAt(i);
                if (min == cur && rRemain.get(cur) > 0) {
                    rRemain.put(cur, rRemain.get(cur) - 1);
                    sRemain.put(cur, sRemain.get(cur) + 1);
                    ret.append((char) cur);
                    rIdx = i - 1;
                    break;
                }
            }
        }
        return rIdx;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = reverseShuffleMerge(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

