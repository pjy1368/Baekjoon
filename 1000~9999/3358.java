import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int N = 1000000;
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] dp = new boolean[N + 1];
		dp[0] = false;
		dp[1] = true;

		// 다음 상황에 선공이 지는 상황이 하나라도 있으면,
		// 현재 지는 상황으로 만들어서 후공에게 넘겨 주어
		// 선공이 이길 수 있음.
		for (int i = 2; i <= N; i++) {
			boolean isWin = false;

			if (i - K >= 0 && !dp[i - K]) {
				isWin = true;
			}

			if (i - L >= 0 && !dp[i - L]) {
				isWin = true;
			}

			if (!dp[i - 1]) {
				isWin = true;
			}

			dp[i] = isWin;
		}

		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());

			sb.append(dp[temp] ? "A" : "B");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}