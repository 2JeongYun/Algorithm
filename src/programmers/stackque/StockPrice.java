package programmers.stackque;

import static myutil.Util.*;

import java.util.*;

public class StockPrice {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        int time = 0;
        PriorityQueue<Price> pQue = new PriorityQueue<>();
        pQue.add(new Price(time, prices[0], 0));

        for (int i = 1; i < prices.length; i++) {
            time++;

            int cur = prices[i];
            while (pQue.isEmpty() == false) {
                Price peek = pQue.peek();

                if (cur < peek.price) {
                    answer[peek.index] = time - peek.time;
                    pQue.poll();
                } else {
                    break;
                }
            }

            pQue.add(new Price(time, prices[i], i));
        }

        while (pQue.isEmpty() == false) {
            Price poll = pQue.poll();
            answer[poll.index] = time - poll.time;
        }

        return answer;
    }

    class Price implements Comparable<Price> {
        int time;
        int price;
        int index;

        Price(int time, int price, int index) {
            this.time = time;
            this.price = price;
            this.index = index;
        }

        @Override
        public int compareTo(Price o) {
            return o.price - price;
        }
    }

    public static void main(String[] args) {
        StockPrice p = new StockPrice();

        int t = 1;
        //t = Util.getTestCaseCount();

        for (int i = 0; i < t; i++) {
            /*
             * Type var = getTypeArr[]
             * Type ...
             * ...
             * print(p.solution());
             */

            print(p.solution(getIntArray()));
        }
    }
}
