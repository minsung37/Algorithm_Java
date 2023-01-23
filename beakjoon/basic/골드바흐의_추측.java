package algorithm.beakjoon.basic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 골드바흐의 추측
// https://www.acmicpc.net/problem/9020


public class 골드바흐의_추측 {
    public static void main(String[] args) throws IOException {
        // 배열의 크기를 선언하고 값을 true로 초기화
        int limit = 10001;
        boolean eratos[] = new boolean[limit];
        Arrays.fill(eratos, true);

        // 0, 1 제외
        eratos[0] = false;
        eratos[1] = false;

        // 소수가 아닌것 제외
        for (int i = 2; i < Math.sqrt(limit); i++) {

            for (int j = i + i; j < limit; j = j + i){
                eratos[j] = false;
            }

        }

        // 골드바흐 파티션 찾기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            int x = a / 2;
            int y = a - x;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < x; j++) {
                // 두수 모두 소수인 경우 출력
                if (eratos[x] && eratos[y]) {
                    sb.append(y);
                    sb.append(" ");
                    sb.append(x);
                    System.out.println(sb);
                    break;
                } else {
                    x++;
                    y--;
                }
            }
        }
    }
}

// 소수판별, 배열사용, String builder로 출력