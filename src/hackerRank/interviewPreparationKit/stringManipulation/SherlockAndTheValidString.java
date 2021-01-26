package hackerRank.interviewPreparationKit.stringManipulation;

import java.io.*;
import java.util.*;

public class SherlockAndTheValidString {

    // Complete the isValid function below.
    //'a' = 97
    //'z' = 122
    static String isValid(String s) {
        HashMap<Integer, Integer> charCntMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 97;
            charCntMap.put(ch, charCntMap.getOrDefault(ch, 0) + 1);
        }

        Set<Integer> frequencys = new HashSet<>();
        int mainFrequency = -1;
        for (Integer i : charCntMap.values()) {
            if (frequencys.add(i) == false) {
                if (mainFrequency == -1) {
                    mainFrequency = i;
                } else if (mainFrequency != i) {
                    return "NO";
                }
            }
            if (frequencys.size() > 2) {
                return "NO";
            }
        }

        for (Integer frequency : frequencys) {
            if (frequency != mainFrequency) {
                if (frequency != 1 && frequency != mainFrequency + 1) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

