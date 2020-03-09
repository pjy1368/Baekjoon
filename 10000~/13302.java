import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int[][] dp = new int[101][101]; // 날짜와 쿠폰 개수
	public static int N;
	public static int M;
	public static boolean[] check = new boolean[101]; // 방문 못하는 날짜

	public static int WES(int day, int coupon) {
		if (day > N) {
			return 0;
		}

		if (dp[day][coupon] == -1) {
			if (check[day]) {
				dp[day][coupon] = WES(day + 1, coupon);
			} else {
				dp[day][coupon] = Math.min(coupon >= 3 ? WES(day + 1, coupon - 3) : WES(day + 1, coupon) + 10000,
						Math.min(WES(day + 3, coupon + 1) + 25000, WES(day + 5, coupon + 2) + 37000));
			}
		}
		return dp[day][coupon];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = bf.readLine();
		StringTokenizer st = new StringTokenizer(input);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = bf.readLine();
		if (M != 0) {
			st = new StringTokenizer(input);
			for (int i = 1; i <= M; i++) {
				check[Integer.parseInt(st.nextToken())] = true;
			}
		}

		for (int i = 1; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				dp[i][j] = -1;
			}
		}

		bw.write(WES(1, 0) + "\n");
		bw.flush();
		bw.close();
		bf.close();
	}

}
