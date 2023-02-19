package algorithm.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class q_문제_제목_붙이기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            HashSet<Byte> set = new HashSet<>();
            for (int i = 0; i < n; i++)
                set.add((byte)br.readLine().charAt(0));
            Byte[] array = set.toArray(new Byte[0]);

            int check = 65;
            int result = 0;
            for (int i = 0; i < array.length; i++)
                if (array[i] == check++) result++;
                else break;
            System.out.printf("#%d %d\n", t + 1, result);
        }
    }
}
