package this_is_coding_test.ch10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HalfCity {
    int houseMax, pathMax;
    Edge[] paths;
    int[] roots;

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(".\\src\\this_is_coding_test\\ch10\\input.txt"));
        StringTokenizer st;
        String line;

        line = br.readLine();
        st = new StringTokenizer(line);
        houseMax = Integer.parseInt(st.nextToken());
        pathMax = Integer.parseInt(st.nextToken());

        paths = new Edge[pathMax];
        for (int i = 0; i < pathMax; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            paths[i] = new Edge(a, b, weight);
        }
        Arrays.sort(paths);

        roots = new int[houseMax + 1];
        for (int i = 1; i < houseMax + 1; i++) {
            roots[i] = i;
        }

        ArrayList<Integer> optimizedPath = optimizePath(paths, roots);
        int totalWeight = 0;
        for (int pathNum : optimizedPath) {
            totalWeight += paths[pathNum].weight;
        }
        totalWeight -= paths[optimizedPath.get(optimizedPath.size() - 1)].weight;
        System.out.println(totalWeight);
    }

    public void union(int[] roots, int a, int b) {
        a = findRoot(roots, a);
        b = findRoot(roots, b);
        if (a < b) {
            roots[b] = a;
        } else {
            roots[a] = b;
        }
    }

    public int findRoot(int[] roots, int houseNum) {
        if (houseNum != roots[houseNum]) {
            roots[houseNum] = findRoot(roots, roots[houseNum]);
        }
        return roots[houseNum];
    }

    public ArrayList<Integer> optimizePath(Edge[] paths, int[] roots) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < paths.length; i++) {
            Edge path = paths[i];
            int aHouse = path.aNode;
            int bHouse = path.bNode;
            if (findRoot(roots, aHouse) != findRoot(roots, bHouse)) {
                union(roots, aHouse, bHouse);
                ret.add(i);
            }
        }
        return ret;
    }

    public class Edge implements Comparable<Edge> {
        public int aNode;
        public int bNode;
        public int weight;

        Edge(int aNode, int bNode, int weight) {
            this.aNode = aNode;
            this.bNode = bNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if (o.weight < this.weight)
                return 1;
            else if (o.weight == this.weight)
                return 0;
            else
                return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        HalfCity hc = new HalfCity();
        hc.doit();
    }
}
