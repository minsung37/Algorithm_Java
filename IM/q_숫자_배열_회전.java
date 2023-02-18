package algorithm.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q_숫자_배열_회전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] numberArray = new int[n][n];
            List<List<Integer>> numberArray90 = new ArrayList<>();
            List<List<Integer>> numberArray180 = new ArrayList<>();
            List<List<Integer>> numberArray270 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++)
                    numberArray[i][j] = Integer.parseInt(st.nextToken());
            }
            // 배열회전
            for (int i = 0; i < n; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < n; j++)
                    temp.add(numberArray[n - 1 - j][i]);
                numberArray90.add(temp);
            }
            for (int i = 0; i < n; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < n; j++)
                    temp.add(numberArray90.get(n - 1 - j).get(i));
                numberArray180.add(temp);
            }
            for (int i = 0; i < n; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < n; j++)
                    temp.add(numberArray180.get(n - 1 - j).get(i));
                numberArray270.add(temp);
            }
            // 출력
            System.out.println("#" + (t + 1));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(numberArray90.get(i).get(j));
                System.out.print(" ");
                for (int j = 0; j < n; j++)
                    System.out.print(numberArray180.get(i).get(j));
                System.out.print(" ");
                for (int j = 0; j < n; j++)
                    System.out.print(numberArray270.get(i).get(j));
                System.out.println();
            }
        }
    }
}
