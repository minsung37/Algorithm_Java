package algorithm.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_테네스의_특별한_소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String d = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 에라토스테네스의 체
            boolean[] eratos = new boolean[b + 1];
            Arrays.fill(eratos,true);
            eratos[0] = false;
            eratos[1] = false;
            for (int i = 2; i < (int) Math.sqrt(b) + 1; i++)
                if (eratos[i])
                    for (int j = i + i; j < b + 1; j = j + i)
                        eratos[j] = false;
            // 출력
            int result = 0;
            for(int i = a; i <= b; i++)
                if (eratos[i] && Integer.toString(i).contains(d))
                    result++;
            System.out.println("#" + (t + 1) + " " + result);
        }
    }
}
