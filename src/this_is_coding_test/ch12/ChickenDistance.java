package this_is_coding_test.ch12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ChickenDistance {
    final int HOME = 1;
    final int CHICKEN = 2;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch12/input.txt"));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][n + 1];
        int chickenCnt = 0;

        ArrayList<Pair> chickenStores = new ArrayList<>();
        ArrayList<Pair> homes = new ArrayList<>();

        for (int y = 1; y < map.length; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x < map.length; x++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == CHICKEN) {
                    chickenStores.add(new Pair(x, y));
                    chickenCnt++;
                }
                if (value == HOME) {
                    homes.add(new Pair(x, y));
                }
                map[y][x] = value;
            }
        }

        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        getCombinations(combinations, new ArrayList<Integer>(), 0, chickenCnt, m);
        ArrayList<Pair> stores = new ArrayList<>();

        int answer = Integer.MAX_VALUE;
        for (ArrayList<Integer> arr : combinations) {
            stores.clear();
            for (int idx : arr) {
                stores.add(chickenStores.get(idx));
            }
            int value = getMinChickenDistance(homes, stores);
            answer = (answer > value) ? value : answer;
        }
        System.out.println(answer);
    }

    public int getMinChickenDistance(ArrayList<Pair> homes, ArrayList<Pair> stores) {
        int min;
        int minTotal = 0;
        for (Pair home : homes) {
            min = Integer.MAX_VALUE;
            for (Pair store : stores) {
                if (home.getDistance(store) < min) {
                    min = home.getDistance(store);
                }
            }
            minTotal += min;
        }
        return minTotal;
    }

    public void getCombinations(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> curArr, int curNum, int max, int target) {
        if (curArr.size() == target) {
            result.add(curArr);
            return;
        } else if (curNum == max) {
            return;
        }
        ArrayList<Integer> arrClone = (ArrayList<Integer>) curArr.clone();
        getCombinations(result, arrClone, curNum + 1, max, target);
        curArr.add(curNum);
        getCombinations(result, curArr, curNum + 1, max, target);
        return;
    }

    public class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistance(Pair other) {
            return Math.abs(other.y - y) + Math.abs(other.x - x);
        }
    }

    public static void main(String[] args) throws IOException {
        ChickenDistance cd = new ChickenDistance();
        cd.solution();
    }
}
