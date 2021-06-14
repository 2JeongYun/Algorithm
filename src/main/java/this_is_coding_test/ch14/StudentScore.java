package this_is_coding_test.ch14;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class StudentScore {
    public static void main(String[] args) throws IOException {
        StudentScore m = new StudentScore();
        m.doit();
    }

    public void doit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Student> stArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            stArr.add(new Student(korean, english, math, name));
        }

        Collections.sort(stArr);
        for (int i = 0; i < n; i++) {
            sb.append(stArr.get(i).name + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    class Student implements Comparable<Student> {
        int korean;
        int english;
        int math;
        String name;

        Student(int korean, int english, int math, String name) {
            this.korean = korean;
            this.english = english;
            this.math = math;
            this.name = name;
        }

        @Override
        public int compareTo(Student other) {
            if (other.korean > this.korean) {
                return 1;
            } else if (other.korean == this.korean) {
                if (other.english < this.english) {
                    return 1;
                } else if (other.english == this.english) {
                    if (other.math > this.math) {
                        return 1;
                    } else if (other.math == this.math) {
                        return this.name.compareTo(other.name);
                    }
                }
            }
            return -1;
        }
    }
}
