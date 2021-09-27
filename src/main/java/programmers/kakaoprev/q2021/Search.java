package programmers.kakaoprev.q2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Search {

    static final int CPP = 0, JAVA = 1, PYTHON = 2;
    static final int BACKEND = 0, FRONTEND = 1;
    static final int JUNIOR = 0, SENIOR = 1;
    static final int CHICKEN = 0, PIZZA = 1;
    static final int ALL = -1;

    public int[] solution(String[] info, String[] query) {
        int[] ret = new int[query.length];

        // 이 정렬 부분이 잘못되었다.
        Arrays.sort(info, ((o1, o2) -> {
            int idx = o1.length() - 1;
            int depth = 1;
            int score1 = 0, score2 = 0;
            while (o1.charAt(idx) != ' ') {
                score1 += (o1.charAt(idx) - '0') * depth;
                depth *= 10;
                idx--;
            }

            idx = o2.length() - 1;
            depth = 1;
            while (o2.charAt(idx) != ' ') {
                score2 += (o2.charAt(idx) - '0') * depth;
                depth *= 10;
                idx--;
            }

            if (score1 < score2) {
                return -1;
            } else {
                return 0;
            }
        }));

        System.out.println(Arrays.toString(info));

        ArrayList<Integer>[][][][] candidates = new ArrayList[3][2][2][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        candidates[i][j][k][l] = new ArrayList<>();
                    }
                }
            }
        }
        for (String apply : info) {
            StringTokenizer st = new StringTokenizer(apply);
            int lang = convert(st.nextToken());
            int field = convert(st.nextToken());
            int skill = convert(st.nextToken());
            int food = convert(st.nextToken());
            candidates[lang][field][skill][food].add(convert(st.nextToken()));
        }

        for (int i = 0; i < query.length; i++) {
            ret[i] = process(query[i], candidates);
        }

        System.out.println(Arrays.toString(ret));
        return ret;
    }

    private int process(String query, ArrayList<Integer>[][][][] candidates) {
        int ret = 0;

        StringTokenizer st = new StringTokenizer(query);
        int lang = convert(st.nextToken()), langEnd = lang;
        if (lang == ALL) {
            lang = 0;
            langEnd = 2;
        }
        st.nextToken();
        int field = convert(st.nextToken()), fieldEnd = field;
        if (field == ALL) {
            field = 0;
            fieldEnd = 1;
        }
        st.nextToken();
        int skill = convert(st.nextToken()), skillEnd = skill;
        if (skill == ALL) {
            skill = 0;
            skillEnd = 1;
        }
        st.nextToken();
        int food = convert(st.nextToken()), foodEnd = food;
        if (food == ALL) {
            food = 0;
            foodEnd = 1;
        }
        int score = convert(st.nextToken());

        for (int l = lang; l <= langEnd; l++) {
            for (int fi = field; fi <= fieldEnd; fi++) {
                for (int s = skill; s <= skillEnd; s++) {
                    for (int fo = food; fo <= foodEnd; fo++) {
                        ArrayList<Integer> arr = candidates[l][fi][s][fo];
                        int idx = biSearch(arr, 0, arr.size() - 1, score);

                        int cnt = arr.size() - idx;
                        if (cnt >= 0) {
                            ret += cnt;
                        }
                    }
                }
            }
        }

        return ret;
    }

    public int convert(String info) {
        switch (info) {
            case "cpp":
                return CPP;
            case "java":
                return JAVA;
            case "python":
                return PYTHON;
            case "backend":
                return BACKEND;
            case "frontend":
                return FRONTEND;
            case "junior":
                return JUNIOR;
            case "senior":
                return SENIOR;
            case "chicken":
                return CHICKEN;
            case "pizza":
                return PIZZA;
            case "-":
                return ALL;
        }

        return Integer.valueOf(info);
    }

    private int biSearch(ArrayList<Integer> arr, int s, int e, int target) {
        int ans = e + 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (arr.get(m) >= target) {
                ans = m;
                e = m - 1;
            } else s = m + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Search s = new Search();
        s.solution(new String[]{
                "cpp backend senior pizza 260",
                "cpp backend senior pizza 260",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        }, new String[]{
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150"
        });
    }
}
