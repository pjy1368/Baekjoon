import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[][] dp = new long[201][201];

		for (int i = 1; i <= K; i++) {
			dp[1][i] = i;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
			}
		}

		bw.write(dp[N][K] + "\n");
		bw.flush();
		bw.close();
		bf.close();
	}

}
