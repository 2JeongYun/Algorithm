package this_is_coding_test.ch6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ScoreBoard {
    public static void main(String[] args) throws IOException {
        ScoreBoard sb = new ScoreBoard();
        sb.doit();
    }

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        line = br.readLine();

        int n = Integer.parseInt(line);
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);

            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            students[i] = new Student(score, name);
        }
        Arrays.sort(students);
        for (Student s : students) {
            System.out.print(s + " ");
        }
    }

    public class Student implements Comparable<Student> {
        int score;
        String name;

        Student(int score, String name) {
            this.score = score;
            this.name = name;
        }

        @Override
        public int compareTo(Student otherStudent) {
            return (otherStudent.score > score) ? -1 : 1;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
