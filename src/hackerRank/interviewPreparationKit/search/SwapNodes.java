package hackerRank.interviewPreparationKit.search;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class SwapNodes {
    static int index = 0;

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int[][] ret = new int[queries.length][indexes.length];
        int idx = 0;
        for (int swapDepth : queries) {
            index = 0;
            treeSwap(indexes, 1, swapDepth, 1);
            printInOrder(indexes, 1, ret[idx++]);
        }
        return ret;
    }

    static void treeSwap(int[][] tree, int rootNode, int swapDepth, int depth) {
        if (rootNode == -1) {
            return;
        }
        if (depth % swapDepth == 0) {
            int temp = tree[rootNode - 1][0];
            tree[rootNode - 1][0] = tree[rootNode - 1][1];
            tree[rootNode - 1][1] = temp;
        }

        treeSwap(tree, tree[rootNode - 1][0], swapDepth, depth + 1);
        treeSwap(tree, tree[rootNode - 1][1], swapDepth, depth + 1);
    }

    static void printInOrder(int[][] tree, int rootNode, int[] ret) {
        if (rootNode == -1) {
            return;
        }
        printInOrder(tree, tree[rootNode - 1][0], ret);
        ret[index++] = rootNode;
        printInOrder(tree, tree[rootNode - 1][1], ret);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
