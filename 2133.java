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
		int[] dp = new int[31];
		
		dp[0] = 1;
		dp[2] = 3;
		
		if(N % 2 != 0) {
			bw.write(0 + "\n");
			bw.flush();
			bw.close();
			bf.close();
			return;
		}
		
		for(int i = 4; i <= N; i += 2) {
			dp[i] = dp[i - 2];
			for(int j = 0; j <= i - 2; j += 2) {
				dp[i] += 2 * dp[j];
			}
		}
		
		bw.write(dp[N] + "\n");
		bw.flush();
		bw.close();
		bf.close();
	}

}
