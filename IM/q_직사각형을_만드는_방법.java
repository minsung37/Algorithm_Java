package algorithm.IM;
import java.util.Scanner;

public class q_직사각형을_만드는_방법 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int result = 0;
		for (int i = 1; i < n + 1; i++)
			for (int j = 1; j <= Math.round(Math.sqrt(i)); j++)
				if (i % j == 0)
					result++;
		System.out.println(result);
	}
}
