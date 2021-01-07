package this_is_coding_test.ch12;

// Unsolved
public class Wall {
    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;

        int[][] weakDist = new int[weak.length][weak.length];
        for (int i = 0; i < weak.length; i++) {
            for (int j = i; j < weak.length; j++) {
                weakDist[i][j] = weak[j] - weak[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Wall w = new Wall();
        int n = 12;
        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};
        System.out.println(w.solution(n, weak, dist));
    }
}
