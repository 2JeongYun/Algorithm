package this_is_coding_test.ch11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MuziFood {
    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./src/this_is_coding_test/ch11/input.txt"));
        StringTokenizer st;

        int kSecond = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int foodCnt = st.countTokens();
        int[] foodTimes = new int[foodCnt];
        for (int i = 0; i < foodCnt; i++) {
            foodTimes[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(foodTimes, kSecond));
    }

    public int solution(int food_times[], long k) {
        int answer = 0;
        int foodCnt = food_times.length;
        long second = 0;
        long hopCnt = 0;
        long ate = 0;
        boolean[] zero = new boolean[food_times.length];
        PriorityQueue<Food> pQue = new PriorityQueue<>();

        for (int i = 0; i < food_times.length; i++) {
            pQue.add(new Food(food_times[i], i));
        }
        while (!pQue.isEmpty()) {
            Food cur = pQue.poll();
            long minFood = cur.time - ate;

            if (minFood * foodCnt + second > k) {
                hopCnt = (k - second) % (long) foodCnt;
                break;
            } else {
                second += minFood * foodCnt;
                foodCnt--;
                zero[cur.num] = true;
                ate += minFood;
            }
        }

        if (pQue.isEmpty()) {
            return -1;
        }

        for (int i = 0; i < food_times.length; i++) {
            if (!zero[i]) {
                if (hopCnt == 0) {
                    answer = i + 1;
                    break;
                } else {
                    hopCnt--;
                }
            }
        }

        return answer;
    }

    public class Food implements Comparable<Food> {
        public int time;
        public int num;
        Food(int time, int num) {
            this.time = time;
            this.num = num;
        }

        @Override
        public int compareTo(Food other) {
            if (other.time < this.time) {
                return 1;
            } else if (other.time == this.time) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        MuziFood mf = new MuziFood();
        mf.doit();
    }
}
