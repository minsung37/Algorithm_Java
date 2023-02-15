package algorithm.beakjoon.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_블랙잭 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            array[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(array);
        int result = 0;
        for (int i = 0; i < n ; i++) {
            if (array[i] > m)
                break;
            int first = array[i];
            for (int j = i + 1; j < n ; j++) {
                if (first + array[j] > m)
                    break;
                int second = first + array[j];
                for (int k = j + 1; k < n ; k++) {
                    if (second + array[k] > m)
                        break;
                    result = Math.max(second + array[k], result);
                }
            }
        }
        System.out.println(result);
    }
}
