package myutil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KMPTest {

    private KMP kmp;

    @BeforeEach
    public void setUp() {
        kmp = new KMP();
    }

    @Test
    public void kmp_테이블_만들기() throws Exception {
        int[] result = kmp.makeTable("abcabc");
        assertThat(result).containsExactly(0, 0, 0, 1, 2, 3);
    }

    @Test
    public void kmp_테스트() throws Exception {
        List<Pair> q = new ArrayList<>();
        q.add(new Pair("aaaeaaaeaaeaeaaa", new Integer[] {2, 6, 9, 11}));
        q.add(new Pair("aaaa", new Integer[] {0, 1, 2, 3}));
        q.add(new Pair("abqieiooabcdaoioaboidlabababcdoe", new Integer[] {8, 26}));
        q.add(new Pair("aaaabbaa", new Integer[] {2}));

        ArrayList<String> patterns = new ArrayList<>();
        patterns.add("ae");
        patterns.add("a");
        patterns.add("abcd");
        patterns.add("aabbaa");

        int patIdx = 0;
        for (Pair p : q) {
            assertThat(kmp.search(p.key, patterns.get(patIdx++)))
                    .containsExactly(p.value);
        }
    }

    class Pair {
        String key;
        Integer[] value;

        Pair(String key, Integer[] value) {
            this.key = key;
            this.value = value;
        }
    }
}
