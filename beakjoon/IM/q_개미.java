package algorithm.beakjoon.IM;

import java.util.Scanner;

public class q_개미 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int t = scanner.nextInt();

        // 반복구간 찾기
        int xt = (t + x) % (w * 2);
        int yt = (t + y) % (h * 2);

        // 순환 찾기
        int row[] = new int[w * 2];
        int col[] = new int[h * 2];
        boolean check = false;
        int width = 0;
        int height = 0;
        for (int i = 0; i < 2 * w; i++) {
            if (!check) {
                row[i] = width++;
            } else {
                row[i] = width--;
            }
            if (width == w)
                check = true;
        }
        check = false;
        for (int i = 0; i < 2 * h; i++) {
            if (!check) {
                col[i] = height++;
            } else {
                col[i] = height--;
            }
            if (height == h)
                check = true;
        }
        System.out.println(row[xt] + " " + col[yt]);
    }
}