import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1]; // 각각의 작업을 수행하는 데 걸리는 시간

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			dp[i] = time;
			for (int j = 0; j < num; j++) {
				int temp = Integer.parseInt(st.nextToken());

				// 가장 긴 수행 시간으로 설정해야 함.
				dp[i] = Math.max(dp[i], dp[temp] + time);
			}

			ans = Math.max(ans, dp[i]);
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}