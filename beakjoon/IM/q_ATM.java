package algorithm.beakjoon.IM;

import java.util.Arrays;
import java.util.Scanner;

public class q_ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();
        Arrays.sort(array);
        int result = 0;
        for (int i = n - 1; i >= 0; i--)
            result = result + array[i] * (n - i);
        System.out.println(result);
    }
}
