import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M + 1];
		int[][] dp = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 첫째 줄
		dp[1][1] = map[1][1];
		for (int i = 2; i <= M; i++) {
			dp[1][i] += map[1][i] + dp[1][i - 1];
		}

		int[][] temp = new int[2][M + 1];

		for (int k = 2; k <= N; k++) {
			// 왼 -> 오
			temp[0][1] = dp[k - 1][1] + map[k][1];
			for (int i = 2; i <= M; i++) {
				temp[0][i] = Math.max(dp[k - 1][i], temp[0][i - 1]) + map[k][i];
			}

			// 오 -> 왼
			temp[1][M] = dp[k - 1][M] + map[k][M];
			for (int i = M - 1; i >= 1; i--) {
				temp[1][i] = Math.max(dp[k - 1][i], temp[1][i + 1]) + map[k][i];
			}

			for (int i = 1; i <= M; i++) {
				dp[k][i] = Math.max(temp[0][i], temp[1][i]);
			}
		}

		bw.write(dp[N][M] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
