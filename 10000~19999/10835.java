import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] A, B;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		A = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		B = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N][N];
		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}

		bw.write(recursion(0, 0) + "\n");
		bw.close();
		br.close();
	}

	public static int recursion(int left, int right) {
		if (left == N || right == N) { // 기저 사례
			return 0;
		}

		if (dp[left][right] != -1) {
			return dp[left][right];
		}

		dp[left][right] = 0;

		int result1 = recursion(left + 1, right); // 왼쪽 카드 제거
		int result2 = recursion(left + 1, right + 1); // 왼쪽, 오른쪽 카드 제거

		int result3 = 0;
		if (A[left] > B[right]) { // 오른쪽 카드 제거
			result3 = B[right] + recursion(left, right + 1);
		}

		return dp[left][right] = Math.max(result1, Math.max(result2, result3));
	}

}