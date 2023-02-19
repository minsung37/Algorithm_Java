package algorithm.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_성공적인_공연_기획 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String people = br.readLine();
            int hire = 0, slap = Character.getNumericValue(people.charAt(0));
            for (int i = 1; i < people.length(); i++) {
                // 박수칠수 있는경우
                if (i <= slap) {
                    slap = slap + Character.getNumericValue(people.charAt(i));
                // 박수못침
                } else {
                    hire = hire + (i - slap);
                    slap = slap + (i - slap) + Character.getNumericValue(people.charAt(i));
                }
            }
            System.out.printf("#%d %d\n", t + 1, hire);
        }
    }
}