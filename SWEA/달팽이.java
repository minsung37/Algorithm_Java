import java.util.Scanner;

public class 달팽이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 우 하 좌 상
        int [] dx = {0, 1, 0, -1};
        int [] dy = {1, 0, -1, 0};
        for (int i = 0; i < n; i++) {
            int size = sc.nextInt();
            int[][] snail = new int[size][size];
            int number = 1;
            // 초기는 우
            int direction = 0;
            int x = 0;
            int y = 0;
            for (int k = 0; k < size * size; k++) {
                snail[x][y] = number++;
                int nx = x + dx[direction];
                int ny = y + dy[direction];
                // 좌표에서 벗어나면 방향 전환
                if (nx < 0 || nx >= size || ny < 0 || ny >= size) {
                    direction = (direction + 1) % 4;
                // 좌표 안벗어낫지만 이미 방문한 경우
                } else {
                    if (snail[nx][ny] != 0) {
                        direction = (direction + 1) % 4;
                    }
                }
                x = x + dx[direction];
                y = y + dy[direction];
            }
            System.out.println("#" + (i + 1));
            for (int[] a : snail) {
                for (int b : a) {
                    System.out.print(b + " ");
                }
                System.out.println();
            }
        }
    }
}
