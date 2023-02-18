package algorithm.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q_중간_평균값_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            List<Double> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++)
                list.add(Double.parseDouble(st.nextToken()));
            System.out.println("#" + (t + 1) + " " + (int) Math.round((list.stream().mapToDouble(Double::doubleValue).sum() - Collections.max(list) - Collections.min(list)) / 8));
        }
    }
}