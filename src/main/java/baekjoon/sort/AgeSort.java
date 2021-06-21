package baekjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AgeSort {

    class User implements Comparable<User> {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            if (this.age < o.age)
                return -1;
            else if (this.age == o.age)
                return 0;
            else
                return 1;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.valueOf(br.readLine());

        User[] users = new User[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            users[i] = new User(Integer.valueOf(st.nextToken()), st.nextToken());
        }
        Arrays.sort(users);

        for (User u : users)
            sb.append(String.format("%d %s\n", u.age, u.name));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        AgeSort a = new AgeSort();
        a.solution();
    }
}
