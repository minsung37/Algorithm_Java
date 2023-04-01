package algorithm.Beakjoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 소수의연속합 {

    public static boolean[] eratos;
    public static List<Integer> primeNumberList;
    public static int n, result;

    public static void makePrimeNumberList() {
        eratos = new boolean[n];
        Arrays.fill(eratos, true);
        eratos[0] = false;
        eratos[1] = false;

        for (int i = 2; i < Math.sqrt(n); i++)
            for (int j = i + i; j < n; j = j + i)
                eratos[j] = false;

        for (int i = 0; i < n; i++)
            if (eratos[i])
                primeNumberList.add(i);
        getPrimeNumberSumCount();
    }

    public static void getPrimeNumberSumCount() {
        for (int i = 0; i < primeNumberList.size(); i++) {
            int sum = primeNumberList.get(i);
            if (sum == n - 1)
                result++;
            for (int j = i + 1; j < primeNumberList.size(); j++) {
                if (sum == n - 1)
                    result++;
                sum = sum + primeNumberList.get(j);
                if (sum > n)
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()) + 1;
        primeNumberList = new ArrayList<>();
        result = 0;
        makePrimeNumberList();
        System.out.println(result);
    }
}
