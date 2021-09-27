package programmers.kakaoprev.q2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Menu {

    public String[] solution(String[] orders, int[] course) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int courseSize : course) {
            int max = 0;
            Set<Integer> possible = new HashSet<>();
            ArrayList<Integer> result = new ArrayList<>();

            for (String order : orders) {
                combination(order, courseSize, 0, 0, 0, possible);
            }

            for (int comb : possible) {
                int count = getCount(orders, comb);
                if (count >= 2) {
                    if (count > max) {
                        max = count;
                        result.clear();
                        result.add(comb);
                    } else if (count == max) {
                        result.add(comb);
                    }
                }
            }

            answer.addAll(result);
        }

        ArrayList<String> ret = convert(answer);
        Collections.sort(ret);

        System.out.println(ret.toString());
        return ret.toArray(new String[] {});
    }

    private ArrayList<String> convert(ArrayList<Integer> answer) {
        ArrayList<String> ret = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int ans : answer) {
            for (int i = 0; i < 26; i++) {
                if ((ans & (1 << i)) != 0) {
                    sb.append((char) ('A' + i));
                }
            }
            ret.add(sb.toString());
            sb.setLength(0);
        }
        return ret;
    }

    public int getCount(String[] orders, int course) {
        int ret = 0;
        for (String order : orders) {
            int orderBi = 0;
            for (char ch : order.toCharArray()) {
                orderBi |= (1 << (ch - 'A'));
            }

            if ((orderBi & course) == course) {
                ret++;
            }
        }
        return ret;
    }

    private void combination(String order, int courseSize, int idx, int curLength, int curCombination, Set<Integer> result) {
        if (curLength == courseSize) {
            result.add(curCombination);
        }

        for (int i = idx; i < order.length(); i++) {
            int menu = (1 << (order.charAt(i) - 'A'));
            combination(order, courseSize, i + 1, curLength + 1, curCombination | menu, result);
        }
    }

    public static void main(String[] args) {
        Menu m = new Menu();
        m.solution(new String[] {
                "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
        }, new int[] {
                2,3,4
        });
        m.solution(new String[] {
                "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"
        }, new int[] {
                2,3,5
        });
        m.solution(new String[] {
                "XYZ", "XWY", "WXA"
        }, new int[] {
                2,3,4
        });
    }
}
