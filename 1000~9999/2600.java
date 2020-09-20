import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] B = new int[3];
		for (int i = 0; i < 3; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[501];
		dp[0] = 0;

		boolean[] check = new boolean[4];
		for (int i = 1; i <= 500; i++) {
			Arrays.fill(check, false);

			// 범위에 맞는 다음 상태의 그런디 수를 true로 초기화 함.
			for (int j = 0; j < 3; j++) {
				if (i - B[j] >= 0) {
					check[dp[i - B[j]]] = true;
				}
			}

			// mex를 구하는 과정.
			int mex = 0;
			while (check[mex]) {
				mex++;
			}
			dp[i] = mex;
		}

		int T = 5;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int k1 = Integer.parseInt(st.nextToken());
			int k2 = Integer.parseInt(st.nextToken());

			bw.write((dp[k1] ^ dp[k2]) == 0 ? "B\n" : "A\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}