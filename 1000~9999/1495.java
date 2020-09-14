import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] volume;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		volume = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			volume[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[M + 1][N];

		// 문제에서 볼륨을 조절하여 맨 마지막 곡에 도달할 수 없는 경우 -1을 반환한다고 하였음.
		// 하지만, 우리가 흔히 dp에서 값을 저장하지 않았을 때 -1을 할당함.
		// 이는 -1을 사용하는 목적이 중복되므로 시간초과가 발생할 수 있음.
		for (int[] arr : dp) {
			Arrays.fill(arr, -2);
		}

		bw.write(recursion(S, 0) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int recursion(int sum, int idx) {
		// 볼륨의 범위를 벗어났을 경우
		if (sum > M || sum < 0) {
			return -1;
		}

		// 기저 사례
		if (idx == N) {
			return sum;
		}

		if (dp[sum][idx] != -2) {
			return dp[sum][idx];
		}

		return dp[sum][idx] = Math.max(dp[sum][idx],
				Math.max(recursion(sum + volume[idx], idx + 1), recursion(sum - volume[idx], idx + 1)));
	}

}