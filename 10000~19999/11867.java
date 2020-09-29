import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		dp = new int[101][101]; // A가 이기면 1, B가 이기면 0.

		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// N이 M보다 작은 경우로 통일.
		if (N > M) {
			int temp = N;
			N = M;
			M = temp;
		}

		bw.write((recursion(N, M) == 1) ? "A\n" : "B\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int recursion(int x, int y) {
		// 범위를 벗어나는 경우.
		if (x == 0 || y == 0 || x > y) {
			return 0;
		}

		// 기저 사례
		if (x == 1 && y == 1) {
			return 2;
		}

		if (dp[x][y] != -1) {
			return dp[x][y];
		}

		dp[x][y] = 0;

		// y에 대하여 돌을 나누는 경우.
		for (int i = 1; i <= y / 2; i++) {
			int temp = recursion(i, y - i);

			// 다음 게임의 상황이 패배하거나, 기저 사례라면
			// 현재 게임의 상황은 승리함.
			if (temp == 0 || temp == 2) {
				return dp[x][y] = 1;
			}
		}

		// x에 대하여 돌을 나누는 경우.
		for (int i = 1; i <= x / 2; i++) {
			int temp = recursion(i, x - i);

			// 다음 게임의 상황이 패배하거나, 기저 사례라면
			// 현재 게임의 상황은 승리함.
			if (temp == 0 || temp == 2) {
				return dp[x][y] = 1;
			}
		}

		return dp[x][y];
	}

}