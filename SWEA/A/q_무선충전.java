package algorithm.SWEA.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q_무선충전 {

    public static int moveCount, bcCount, Acharge, Bcharge, charge;
    public static int[] A, B;
    public static final int 좌 = 1, 하 = 2, 우 = 3, 상 = 4;
    public static int[] dx = {0, -1, 0, 1, 0};
    public static int[] dy = {0, 0, 1, 0, -1};
    public static List<int[]>[][] ground;

    public static void solution(int ax, int ay, int bx, int by) {
        int axx = ax;
        int ayy = ay;
        int bxx = bx;
        int byy = by;

        for (int m = 0; m < moveCount + 1; m++) {
            // a이동
            int nax = axx + dx[A[m]];
            int nay = ayy + dy[A[m]];
            // b이동
            int nbx = bxx + dx[B[m]];
            int nby = byy + dy[B[m]];

            List<int[]> abattery = ground[nax][nay];
            List<int[]> bbattery = ground[nbx][nby];

            // 비교해서 같은거 있는경우
            // 둘다 한개만 => 반띵 or 각자 충전
            if (bbattery.size() == 0 && abattery.size() == 0) {
                axx = nax;
                ayy = nay;
                bxx = nbx;
                byy = nby;
                continue;
            }
            if (bbattery.size() == 0) {
                // a 최대 찾아서 더하기
                int power = 0;
                for (int j = 0; j < abattery.size(); j++)
                    if (power < abattery.get(j)[2])
                        power = abattery.get(j)[2];
                Acharge = Acharge + power;
                axx = nax;
                ayy = nay;
                bxx = nbx;
                byy = nby;
                continue;
            }
            if (abattery.size() == 0) {
                // b최대 찾아서 더하기
                int power = 0;
                for (int j = 0; j < bbattery.size(); j++)
                    if (power < bbattery.get(j)[2])
                        power = bbattery.get(j)[2];
                Bcharge = Bcharge + power;
                axx = nax;
                ayy = nay;
                bxx = nbx;
                byy = nby;
                continue;
            }

            if (abattery.size() == 1 && bbattery.size() == 1) {
                boolean half = false;
                for (int[] aInfo : abattery) {
                    for (int[] bInfo: bbattery) {
                        if (aInfo[0] == bInfo[0]) {
                            half = true;
                        }
                    }
                }
                if (half) {
                    Acharge = Acharge + abattery.get(0)[2] / 2;
                    Bcharge = Bcharge + bbattery.get(0)[2] / 2;
                    charge = charge + abattery.get(0)[2];
                } else {
                    Acharge = Acharge + abattery.get(0)[2];
                    Bcharge = Bcharge + bbattery.get(0)[2];
                    charge = charge + abattery.get(0)[2] + bbattery.get(0)[2];
                }
                // 둘이 합쳐 3개이상인경우
            } else {
                int maxa = 0;
                int maxb = 0;
                for (int j = 0; j < abattery.size(); j++) {
                    for (int k = 0; k < bbattery.size(); k++) {
                        if (abattery.get(j)[0] != bbattery.get(k)[0]) {
                            if (maxa + maxb < abattery.get(j)[2] + bbattery.get(k)[2]) {
                                maxa = abattery.get(j)[2];
                                maxb = bbattery.get(k)[2];
                            }
                        }
                    }
                }
                Acharge = Acharge + maxa;
                Bcharge = Bcharge + maxb;
            }
            // 이동하기
            axx = nax;
            ayy = nay;
            bxx = nbx;
            byy = nby;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            moveCount = Integer.parseInt(st.nextToken());
            bcCount = Integer.parseInt(st.nextToken());

            // A, B 이동정보
            A = new int[moveCount + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < moveCount + 1; i++)
                A[i] = Integer.parseInt(st.nextToken());
            B = new int[moveCount + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < moveCount + 1; i++)
                B[i] = Integer.parseInt(st.nextToken());

            // 배터리 정보 입력받기
            ground = new ArrayList[10][10];
            for (int i = 0; i < 10; i++)
                for (int j = 0; j < 10; j++)
                    ground[i][j] = new ArrayList<>();

            for (int i = 0; i < bcCount; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                int[] info = new int[] {i + 1, c, p};
                ground[y][x].add(info);
                for (int row = x - c; row <= x + c; row++) {
                    for (int col = y - c; col <= y + c; col++){
                        if (row == x && col == y)
                            continue;
                        if (row < 0 || row >= 10 || col < 0 || col >= 10)
                            continue;
                        if (Math.abs(x - row) + Math.abs(y - col) <= c) {
                            ground[col][row].add(info);
                        }
                    }
                }
            }
            Acharge = 0;
            Bcharge = 0;
            charge = 0;
            solution(0, 0, 9, 9);
            System.out.printf("#%d %d\n", t + 1, Acharge + Bcharge);
        }
    }
}
