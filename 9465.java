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
		int T = Integer.parseInt(bf.readLine());
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(bf.readLine());
			long[][] scores = new long[2][100001];
			long[][] dp = new long[2][100001];
			for(int j = 0; j < 2; j++) {
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for(int k = 1; k <= N; k++) {
					int temp = Integer.parseInt(st.nextToken());
					scores[j][k] = temp;
				}
			}
			dp[0][1] = scores[0][1];
			dp[1][1] = scores[1][1];
			for(int k = 2; k <= N; k++) {
				dp[0][k] = scores[0][k] + Math.max(dp[1][k - 1], dp[1][k - 2]);
				dp[1][k] = scores[1][k] + Math.max(dp[0][k - 1], dp[0][k - 2]);
			}
			
			bw.write(Math.max(dp[0][N], dp[1][N]) + "\n");
		}
		
		bw.flush();
		bw.close();
		bf.close();
	}

}
