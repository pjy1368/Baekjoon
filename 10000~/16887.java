import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[34];
		dp[1] = 1;

		// 피보나치 수열
		for (int i = 2; i < 34; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		// 1 ~ 3000000 각각의 그런디 수
		int[] grundyArr = new int[3000001];
		grundyArr[0] = 0;
		grundyArr[1] = 1;
		grundyArr[2] = 2;
		grundyArr[3] = 3;

		boolean[] check = new boolean[16];
		for (int i = 4; i <= 3000000; i++) {
			Arrays.fill(check, false);

			for (int j = 2; j < 34; j++) {
				if (dp[j] <= i) { // 피보나치 수만큼 돌을 뺄 수 있는 경우
					check[grundyArr[i - dp[j]]] = true;
				} else {
					// mex 값을 구하는 과정
					for (int k = 0; k < 16; k++) {
						if (!check[k]) {
							grundyArr[i] = k;
							break;
						}
					}
				}
			}
		}

		st = new StringTokenizer(br.readLine());

		int result = 0;
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());

			result ^= grundyArr[temp];
		}

		bw.write((result != 0) ? "koosaga" : "cubelover");
		bw.flush();
		bw.close();
		br.close();
	}

}