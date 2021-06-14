package programmers.dfsbfs;

import myutil.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static myutil.Util.*;

public class Travel {

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });

        ArrayList<String> ret = new ArrayList<>();
        ret.add("ICN");
        findRoot(tickets, "ICN", new boolean[tickets.length], ret);

        return ret.toArray(new String[] {});
    }

    public boolean findRoot(String[][] tickets, String cur, boolean[] isUsed, ArrayList<String> ret) {
        boolean isEnd = true;
        for (int i = 0; i < isUsed.length; i++) {
            if (isUsed[i] == false) {
                isEnd = false;
                break;
            }
        }
        if (isEnd) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(cur) && isUsed[i] == false) {
                isUsed[i] = true;
                ret.add(tickets[i][1]);
                if (findRoot(tickets, tickets[i][1], isUsed, ret)) {
                    return true;
                }
                ret.remove(ret.size() - 1);
                isUsed[i] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Travel p = new Travel();

        int t = 1;
        t = getTestCaseCount();

        for (int i = 0; i < t; i++) {
            /*
             * Type var = getTypeArr[]
             * Type ...
             * ...
             * print(p.solution());
             */
            print(p.solution(getTwoDimensionalStringArray()));
        }

        Util.closeUtil();
    }
}
