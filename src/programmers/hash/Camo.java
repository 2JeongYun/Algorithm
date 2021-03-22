package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Camo {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        int ans = 1;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans *= entry.getValue() + 1;
        }

        return ans - 1;
    }
}
