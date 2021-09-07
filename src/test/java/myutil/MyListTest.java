package myutil;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class MyListTest {

    @Test
    public void 리스트_추가() {
        MyList<Integer> list = new MyList<>();
        list.add(3);
        list.add(2);
        list.add(1);

        ArrayList<Integer> ret = new ArrayList<>();
        MyList.Node<Integer> curNode = list.firstNode;
        while (curNode != null) {
            ret.add(curNode.data);
            curNode = curNode.nextNode;
        }

        assertThat(ret).containsExactly(3, 2, 1);
    }
}
