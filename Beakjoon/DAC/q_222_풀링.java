package algorithm.Beakjoon.DAC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_222_풀링 {

    public static int[][] numbers;

    public static int dac(int x, int y, int size) {
        int[] array = new int[4];
        int index = 0;

        if (size == 2) {
            for (int i = x; i < x + 2; i++)
                for (int j = y; j < y + 2; j++)
                    array[index++] = numbers[i][j];
        } else {
            size = size / 2;
            array[index++] = dac(x, y, size);
            array[index++] = dac(x + size, y, size);
            array[index++] = dac(x, y + size, size);
            array[index] = dac(x + size, y + size, size);
        }

        Arrays.sort(array);
        return array[2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dac(0, 0, n));
    }
}
