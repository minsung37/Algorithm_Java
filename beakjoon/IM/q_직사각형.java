package algorithm.beakjoon.IM;

import java.util.Scanner;

public class q_직사각형 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // x y p q
        int[] rectangle1 = new int[4];
        int[] rectangle2 = new int[4];
        for (int i = 0; i < 4; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int p1 = scanner.nextInt();
            int q1 = scanner.nextInt();

            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int p2 = scanner.nextInt();
            int q2 = scanner.nextInt();

            if (x1 == x2 && y1 == y2) {
                System.out.println("a");
                continue;
            }
            if ((x1 == x2 && y1 < y2) || (x1 < x2 && y1 == y2))  {
                rectangle1[0] = x1;
                rectangle1[1] = y1;
                rectangle1[2] = p1;
                rectangle1[3] = q1;

                rectangle2[0] = x2;
                rectangle2[1] = y2;
                rectangle2[2] = p2;
                rectangle2[3] = q2;
            }


            // 안만나는 경우
            if ((p1 < x2) || (q1 < y2)) {
                System.out.println("d");
            }

        }
    }
}
