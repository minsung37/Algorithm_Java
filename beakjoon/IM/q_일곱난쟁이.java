package algorithm.beakjoon.IM;

import java.util.Arrays;
import java.util.Scanner;

public class q_일곱난쟁이 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dwarfList = new int[9];
        for (int i = 0; i < 9; i++) {
            dwarfList[i] = scanner.nextInt();
        }
        Arrays.sort(dwarfList);
        int remove1 = 0;
        int remove2 = 0;
        int check = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i != j){
                    check = 0;
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j)
                            continue;
                        check = check + dwarfList[k];
                    }
                    if (check == 100){
                        remove1 = i;
                        remove2 = j;
                        for (int k = 0; k < 9; k++) {
                            if (k == remove1 || k == remove2)
                                continue;
                            System.out.println(dwarfList[k]);
                        }
                        System.exit(0);
                    }
                }
            }
        }
    }
}
