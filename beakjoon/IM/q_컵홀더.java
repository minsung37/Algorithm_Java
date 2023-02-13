package algorithm.beakjoon.IM;
import java.util.Scanner;

public class q_컵홀더 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String holder = scanner.next();
		int s = 0;
		int l = 0;
		// 컵홀더 count
		for (int i = 0; i < n; i++) {		
			if (holder.charAt(i) == 'S') {
				s++;
			} else {
				l++;
			}				
		}
		
		// 컵홀더가 더 많은 경우 모두 놓을수 있다.
		int max = (s + l / 2 + 1);
		if (max > n) {
			System.out.println(n);
		} else {
			System.out.println(max);
		}
	}
}