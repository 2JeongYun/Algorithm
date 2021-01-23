package HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MakingAnagrams {

    // Complete the makeAnagram function below.
    //z = 122
    //a = 97
    static int makeAnagram(String a, String b) {
        int[] aCntArr = new int[26];
        int[] bCntArr = new int[26];
        int ret = 0;

        for (int i = 0; i < a.length(); i++) {
            int ch = (int) a.charAt(i) - 97;
            aCntArr[ch]++;
        }

        for (int i = 0; i < b.length(); i++) {
            int ch = (int) b.charAt(i) - 97;
            bCntArr[ch]++;
        }

        for (int i = 0; i < aCntArr.length; i++) {
            ret += Math.abs(aCntArr[i] - bCntArr[i]);
        }

        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

