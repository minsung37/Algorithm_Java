package algorithm.IM;

import java.util.Scanner;

public class q_스위치_켜고_끄기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] light = new int[n];
        for (int i = 0; i < n; i++)
            light[i] = scanner.nextInt();

        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int gender = scanner.nextInt();
            int spot = scanner.nextInt();
            if (gender == 1) {
                for (int j = spot - 1; j < n; j = j + spot)
                    light[j] = (light[j] + 1) % 2;
            } else {
                spot = spot - 1;
                int index = 1;
                light[spot] = (light[spot] + 1) % 2;
                while (true) {
                    if (0 <= spot - index && spot + index < n) {
                        if (light[spot - index] == light[spot + index]) {
                            light[spot - index] = (light[spot - index] + 1) % 2;
                            light[spot + index] = (light[spot + index] + 1) % 2;
                            index++;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < light.length; i++) {
            System.out.print(light[i] + " ");
            if((i+1) % 20 == 0)
                System.out.println();
        }
    }
}