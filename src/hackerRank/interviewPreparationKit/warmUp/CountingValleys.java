package hackerRank.interviewPreparationKit.warmUp;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        boolean isUnderSeaLevel = false;
        int level = 0;
        int valleyCnt = 0;

        for (int i = 0; i < steps; i++) {
            if (path.charAt(i) == 'U') {
                level++;
            } else {
                level--;
                if (level < 0) {
                    isUnderSeaLevel = true;
                }
            }

            if (isUnderSeaLevel && level == 0) {
                valleyCnt++;
                isUnderSeaLevel = false;
            }
        }

        return  valleyCnt;
    }

}

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

