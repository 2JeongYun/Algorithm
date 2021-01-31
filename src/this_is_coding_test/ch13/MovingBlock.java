package this_is_coding_test.ch13;

public class MovingBlock {
    public int solution(int[][] board) {
        int answer = 0;
        return answer;
    }

    class Robot {
        static final int HEAD = 100;
        static final int TAIL = 200;
        Pair head;
        Pair tail;

        public boolean rotate(Pair direction, int[][] board) {
        }

        public boolean move(Pair direction, int[][] board) {
            Pair oHead = head;
            Pair oTail = tail;
            head.add(direction);
            tail.add(direction);
            if (isCrash(board)) {
                head = oHead;
                tail = oTail;
            }
        }

        pubilc boolean isCrash(int[][] board) {
            if (board[head.y][head.x] == 1 || board[tail.y][tail.x] == 1) {
                return true;
            }
            return false;
        }
    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void add(Pair other) {
            x += other.x;
            y += other.y;
        }

        public boolean isEqual(Pair other) {
            if (x == other.x && y == other.y) {
                return true;
            }
            return false;
        }
    }
}
