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
		int N = Integer.parseInt(bf.readLine());
		long[] sequence = new long[100001]; // 수열
		long[] dp = new long[100001]; // 부분합

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sequence[i] = temp;
		}

		long sum = 0;
		long num = 0;

		for (int i = 1; i <= N; i++) {
			num = sum = sequence[i];
			for (int j = i + 1; j <= N; j++) {
				num += sequence[j];
				sum = Math.max(sum, num);
			}
			dp[i] = sum;
		}

		long ans = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, dp[i]);
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		bf.close();
	}

}
