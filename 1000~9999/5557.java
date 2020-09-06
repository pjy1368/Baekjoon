import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] operand;
	static long[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		operand = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			operand[i] = Integer.parseInt(st.nextToken());
		}

		dp = new long[21][100];

		for (int i = 0; i <= 20; i++) {
			for (int j = 0; j < 100; j++) {
				dp[i][j] = -1;
			}
		}

		bw.write(recursion(operand[0], 0) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static long recursion(int sum, int idx) {
		// sum의 범위는 0부터 20까지.
		if (sum < 0 || sum > 20) {
			return 0;
		}

		// operand[0] ~ operand[N - 2] 까지 연산을 완료했으면
		// 여태까지의 값과 operand[N - 1]을 비교해야 함.
		if (idx == N - 2) {
			return (sum == operand[N - 1]) ? 1 : 0;
		}

		if (dp[sum][idx] != -1) {
			return dp[sum][idx];
		}

		dp[sum][idx] = 0;
		
		return dp[sum][idx] += recursion(sum + operand[idx + 1], idx + 1) + recursion(sum - operand[idx + 1], idx + 1);
	}

}