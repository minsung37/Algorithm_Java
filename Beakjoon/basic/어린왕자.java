package algorithm.Beakjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어린왕자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int starCount = Integer.parseInt(br.readLine());
            for (int i = 0; i < starCount; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                // 별과 두 행성 사이거리
                int distanceDepart = (cx - x) * (cx - x) + (cy - y) * (cy - y);
                int distanceArrive = (cx - p) * (cx - p) + (cy - q) * (cy - q);
                // 별의 반지름 제곱
                int distanceToStar = r * r;
                // 행성이 별 안에 있는지 밖에있는지 비교
                if (distanceDepart < distanceToStar && distanceArrive < distanceToStar)
                    continue;
                else if (distanceDepart < distanceToStar)
                    count++;
                else if (distanceArrive < distanceToStar)
                    count++;
            }
            System.out.println(count);
        }
    }
}