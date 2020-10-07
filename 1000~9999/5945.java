import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] coins;
	static int[][][] dp; // 각자의 차례, 카드의 맨 왼쪽, 카드의 맨 오른쪽 -> dp 값은 선공이 얻는 점수임.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		coins = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		dp = new int[2][N + 1][N + 1];
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					dp[i][j][k] = -1;
				}
			}
		}

		bw.write(recursion(0, 1, N) + "\n");
		bw.close();
		br.close();
	}

	public static int recursion(int turn, int start, int end) {
		if (dp[turn][start][end] != -1) {
			return dp[turn][start][end];
		}

		// 기저 사례
		if (start >= end) {
			if (turn == 0) { // 선공 차례
				return coins[start];
			} else { // 후공 차례
				return 0;
			}
		}

		dp[turn][start][end] = 0;

		if (turn == 0) { // 선공 차례에 경우는 왼쪽 카드를 뽑았을 떄와 오른쪽 카드를 뽑았을 때 중, 숫자의 합이 크도록 설정.
			dp[turn][start][end] = Math.max(recursion(turn + 1, start + 1, end) + coins[start],
					recursion(turn + 1, start, end - 1) + coins[end]);
		} else { // 후공 차례에 경우는 선공이 더 작은 카드를 뽑게 해야하므로, 왼쪽 카드를 뽑았을 때와 오른쪽 카드를 뽑았을 때 중, 숫자의 합이 작도록
					// 설정.
			dp[turn][start][end] = Math.min(recursion(turn - 1, start + 1, end), recursion(turn - 1, start, end - 1));
		}

		return dp[turn][start][end];
	}
}