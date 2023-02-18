package algorithm.IM;

import java.util.Scanner;

public class q_벌집 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int center = 1;
        int room = 1;
        while (room < n) {
            room = room + 6 * center;
            // System.out.println(room);
            center++;
        }
        System.out.println(center);
    }
}
