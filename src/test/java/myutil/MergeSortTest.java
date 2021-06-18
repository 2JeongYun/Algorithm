package myutil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortTest {

    private MergeSort mergeSort;

    @BeforeEach
    public void setUp() {
        mergeSort = new MergeSort();
    }

    @Test
    public void 머지소트() throws Exception {
        int[] test1 = {5, 4, 3, 2, 1};
        int[] test2 = {1, 2, 3};
        int[] test3 = {6, 9, 10, 1, 4, 6, 2, 10};
        int[] test4 = {1};
        mergeSort.mergeSort(test1, 0, test1.length - 1);
        mergeSort.mergeSort(test2, 0, test2.length - 1);
        mergeSort.mergeSort(test3, 0, test3.length - 1);
        mergeSort.mergeSort(test4, 0, test4.length - 1);
        assertThat(test1).containsExactly(1, 2, 3, 4, 5);
        assertThat(test2).containsExactly(1, 2, 3);
        assertThat(test3).containsExactly(1, 2, 4, 6, 6, 9, 10, 10);
        assertThat(test4).containsExactly(1);
    }
}
