package algorithm.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class q_스도쿠_검증 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int size = 9;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int isSudoku = 1;
            // 스도쿠 입력받기
            int[][] sudoku = new int[size][size];
            for (int i = 0; i < size; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < size; j++)
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
            // 스도쿠 검사
            HashSet<Integer> checkSet = new HashSet<Integer>();
            Loop1:
            for (int x = 0; x < size; x++) {
                checkSet.clear();
                for (int y = 0; y < size; y++)
                    checkSet.add(sudoku[x][y]);
                if (checkSet.size() != 9) {
                    isSudoku = 0;
                    break Loop1;
                }
            }

            if (isSudoku == 1) {
                Loop1:
                for (int x = 0; x < size; x++) {
                    checkSet.clear();
                    for (int y = 0; y < size; y++)
                        checkSet.add(sudoku[y][x]);
                    if (checkSet.size() != 9) {
                        isSudoku = 0;
                        break Loop1;
                    }
                }
            }

            if (isSudoku == 1) {
                Loop1:
                for (int x = 0 ; x < size; x = x + 3) {
                    checkSet.clear();
                    for (int y = 0 ; y < size; y = y + 3) {
                        for (int nx = 0; nx < 3; nx++)
                            for (int ny = 0; ny < 3; ny++)
                                checkSet.add(sudoku[x + nx][y + ny]);
                        if (checkSet.size() != 9) {
                            isSudoku = 0;
                            break Loop1;
                        }
                    }
                }
            }
            System.out.println("#" + (t + 1) + " " +  isSudoku);
        }
    }
}