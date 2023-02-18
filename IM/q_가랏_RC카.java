package algorithm.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_가랏_RC카 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int distance = 0;
            int speed = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int controlType = Integer.parseInt(st.nextToken());
                if (controlType == 1) {
                    int speedUp = Integer.parseInt(st.nextToken());
                    speed = speed + speedUp;
                } else if (controlType == 2) {
                    int speedDown = Integer.parseInt(st.nextToken());
                    speed = speed - speedDown;
                    if (speed < 0)
                        speed = 0;
                }
                distance = distance + speed;
            }
            System.out.println("#" + (t + 1) + " " +  distance);
        }
    }
}