import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		int[] dp = new int[100001]; // 방법의 최솟값(최소 가짓수)

		int maxNum = 0;
		int q = 0;
		int r = 0;

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		for (int i = 4; i <= N; i++) {
			dp[i] = i;
			for (int j = 2; j * j <= i; j++) {
				q = i / (j * j);
				r = i % (j * j);
				dp[i] = Math.min(dp[i], q + dp[r]);
			}
		}

		bw.write(dp[N] + "\n");
		bw.flush();
		bw.close();
		bf.close();
	}

}
