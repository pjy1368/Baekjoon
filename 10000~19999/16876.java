import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String N;
	static int M;
	static int[][] dp; // dp[i][j] = x -> j턴이고 i수일 때, x값 (0이면 패배, 1이면 승리).

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = st.nextToken();
		M = Integer.parseInt(st.nextToken());

		dp = new int[10001][101];
		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}

		bw.write(recursion(0, N) == 1 ? "koosaga" : "cubelover");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int recursion(int turn, String num) {
		int newN = Integer.parseInt(num);

		// 기저 사례
		if (turn == M) {
			int intN = Integer.parseInt(N);

			// turn이 짝수 : koosaga 차례이므로 newN > intN일 때, 게임에서 승리
			// turn이 홀수 : cubelover 차례이므로 newN <= intN일 때, 게임에서 승리
			return turn % 2 == 1 ? (newN <= intN ? 1 : 0) : (newN > intN ? 1 : 0);
		}

		if (dp[newN][turn] != -1) {
			return dp[newN][turn];
		}

		dp[newN][turn] = 0;

		// 네 자리 문자열에서 각 자리 수에 +1 해서 다음 턴으로 보냄.
		for (int i = 0; i < 4; i++) {
			StringBuilder sb = new StringBuilder(num);

			char c = 0;
			if (sb.charAt(i) == '9') {
				c = '0';
			} else {
				c = (char) (sb.charAt(i) + 1);
			}

			sb.setCharAt(i, c);

			// 다음 턴의 상대방이 패배하면, 현재는 승리함.
			// 다음 턴의 상대방이 모두 승리하면, 현재는 패배함.
			if (recursion(turn + 1, sb.toString()) == 0) {
				dp[newN][turn] = 1;
			}
		}

		return dp[newN][turn];
	}

}