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
		int[] P = new int[1001];
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int[] dp = new int[1001];

		for (int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], P[j] + dp[i - j]);
			}
		}
		
		bw.write(dp[N] + "\n");
		bw.flush();
		bw.close();
		bf.close();
	}

}
