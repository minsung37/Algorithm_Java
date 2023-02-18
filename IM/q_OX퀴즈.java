package algorithm.IM;

import java.util.Scanner;

public class q_OX퀴즈 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String quiz = scanner.next();
            int score = 0;
            int result = 0;
            for (int j = 0; j < quiz.length(); j++) {
                if (quiz.charAt(j) == 'O') {
                    score = score + 1;
                    result = result + score;
                } else {
                    score = 0;
                }
            }
            System.out.println(result);
        }
    }
}
