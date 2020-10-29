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
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		int idx = 1;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

					if (arr[i][j] == 1) {
						System.out.println("fucking!");
					}
				}
			}

			int res = 0;
			
			// 각 행에서 소인수의 거듭제곱 수의 합을 구한다.
			// 그리고 그 합끼리 XOR합을 취한다.
			for (int i = 0; i < N; i++) {
				int total = 0;
				for (int j = 0; j < M; j++) {
					total += factorization(arr[i][j]);
				}
				res ^= total;
			}

			sb.append("Case #" + idx + ": " + ((res == 0) ? "NO\n" : "YES\n"));
			idx++;
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 소인수분해
	public static int factorization(int n) {
		if (n == 1) {
			return 0;
		}

		int cnt = 1;

		while (n != 1) {
			boolean isPrime = true;

			for (int i = 2; i * i <= n; i++) {
				if (n % i == 0) {
					isPrime = false;
					n /= i;
					cnt++;
					break;
				}
			}

			if (isPrime) {
				break;
			}
		}

		return cnt;
	}

}