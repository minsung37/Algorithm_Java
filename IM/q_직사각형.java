package algorithm.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_직사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] box = new int[8];
        for (int t = 0 ; t < 4; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++)
                box[i] = Integer.parseInt(st.nextToken());
            int x1 = 0, y1 = 1, p1 = 2, q1 = 3, x2 = 4, y2 = 5, p2 = 6, q2 = 7;
            // 안만남
            if (box[p1] < box[x2]) {
                System.out.println('d');
                continue;
            }
            if (box[p2] < box[x1]) {
                System.out.println('d');
                continue;
            }
            if (box[y1] > box[q2]) {
                System.out.println('d');
                continue;
            }
            if (box[q1] < box[y2]) {
                System.out.println('d');
                continue;
            }
            // 점
            if (box[x1] == box[p2] && box[y1] == box[q2]) {
                System.out.println('c');
                continue;
            }
            if (box[p1] == box[x2] && box[y1] == box[q2]) {
                System.out.println('c');
                continue;
            }
            if (box[p1] == box[x2] && box[q1] == box[y2]) {
                System.out.println('c');
                continue;
            }
            if (box[x1] == box[p2] && box[q1] == box[y2]) {
                System.out.println('c');
                continue;
            }
            // 변
            if (box[q1] == box[y2]) {
                System.out.println('b');
                continue;
            }
            if (box[x1] == box[p2]) {
                System.out.println('b');
                continue;
            }
            if (box[y1] == box[q2]) {
                System.out.println('b');
                continue;
            }
            if (box[p1] == box[x2]) {
                System.out.println('b');
                continue;
            }
            // 직사각형
            if (box[x1] < box[p2] && box[y1] < box[q2]) {
                System.out.println('a');
                continue;
            }
            if (box[p1] > box[x2] && box[y1] < box[q2]) {
                System.out.println('a');
                continue;
            }
            if (box[p1] > box[x2] && box[q1] > box[y2]) {
                System.out.println('a');
                continue;
            }
            if (box[x1] < box[p2] && box[q1] > box[y2]) {
                System.out.println('a');
                continue;
            }
            System.out.println("NOT REACH");
        }
    }
}