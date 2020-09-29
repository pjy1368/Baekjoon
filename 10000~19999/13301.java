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
		long[] dp = new long[82];
		
		dp[1] = dp[2] = 1;
		for(int i = 3; i <= N + 1; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		
		bw.write((dp[N] * 2 + dp[N + 1] * 2) + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
