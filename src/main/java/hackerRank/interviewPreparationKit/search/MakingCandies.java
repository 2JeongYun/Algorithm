package hackerRank.interviewPreparationKit.search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MakingCandies {

    // Complete the minimumPasses function below.
    static long minimumPasses(long m, long w, long p, long n) {
        long day = 0;
        long minDay = Long.MAX_VALUE;
        long candy = 0;

        while (true) {
            day++;
            long produce = 0;
            try {
                produce = Math.multiplyExact(m, w);
            } catch (Exception e) {
                return day;
            }
            candy += produce;

            if (candy >= n) {
                break;
            }

            long remainDay = day + divideCeil(n - candy, produce);
            minDay = Long.min(minDay, remainDay);

            if (candy >= p) {
                long hiring = candy / p;
                long gap = Math.abs(m - w);
                if (gap <= hiring) {
                    if (m < w) {
                        m += gap;
                    } else {
                        w += gap;
                    }
                    m += (hiring - gap) / 2;
                    w += divideCeil(hiring - gap, 2L);
                } else {
                    if (m < w) {
                        m += hiring;
                    } else {
                        w += hiring;
                    }
                }
                candy = candy % p;
            } else {
                long buyDay = divideCeil(p - candy, produce) - 1;
                candy += produce * buyDay;
                day += buyDay;
            }

            //System.out.printf("candy:%d day:%d m:%d w:%d\n", candy, day, m, w);
        }

        minDay = Long.min(minDay, day);
        return minDay;
    }

    static long divideCeil(long a, long b) {
        return (a % b == 0) ? a / b : (a / b) + 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] mwpn = scanner.nextLine().split(" ");

        long m = Long.parseLong(mwpn[0]);

        long w = Long.parseLong(mwpn[1]);

        long p = Long.parseLong(mwpn[2]);

        long n = Long.parseLong(mwpn[3]);

        long result = minimumPasses(m, w, p, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

