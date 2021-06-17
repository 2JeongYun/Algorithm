package baekjoon.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Size {

    class Person {
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public boolean isBiggerThan(Person p) {
            if (this.weight > p.weight && this.height > p.height)
                return true;
            return false;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        final int N = Integer.valueOf(br.readLine());
        Person[] people = new Person[N];
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            people[i] = new Person(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (people[j].isBiggerThan(people[i]))
                    rank++;
            }
            answer[i] = rank;
        }

        for (int rank : answer) {
            bw.write(String.format("%d ", rank));
        }
        bw.flush();

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        Size s = new Size();
        s.solution();
    }
}
