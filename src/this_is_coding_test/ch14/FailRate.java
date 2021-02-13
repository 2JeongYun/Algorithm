package this_is_coding_test.ch14;
import java.util.*;

class FailRate {
    public int[] solution(int N, int[] stages) {
        int allClear = 0;
        int[] stageCount = new int[N];
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] == N + 1) {
                allClear++;
            } else {
                stageCount[stages[i] - 1]++;
            }
        }

        int sum = allClear;
        Pair[] failRates = new Pair[N];
        for (int i = N - 1; i >= 0; i--) {
            sum += stageCount[i];
            if (sum == 0) {
                double failRate = (stageCount[i] > 0) ? 100 : 0;
                failRates[i] = new Pair(failRate, i);
            } else {
                failRates[i] = new Pair((double) stageCount[i] / sum, i);
            }
        }
        Arrays.sort(failRates);

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = failRates[i].index + 1;
        }
        return ans;
    }

    class Pair implements Comparable<Pair> {
        double failRate;
        int index;

        Pair (double failRate, int index) {
            this.failRate = failRate;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.failRate < other.failRate) {
                return 1;
            } else if (this.failRate == other.failRate) {
                if (this.index > other.index) {
                    return 1;
                }
            }
            return -1;
        }
    }
}
