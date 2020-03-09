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
		int[] stairs = new int[301]; // 수열
		int[] dp = new int[301]; // 부분합

		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(bf.readLine());
		}

		dp[0] = 0;
		dp[1] = stairs[1];
		dp[2] = Math.max(stairs[1] + stairs[2], stairs[2]);

		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(stairs[i] + stairs[i - 1] + dp[i - 3], stairs[i] + dp[i - 2]);
		}

		bw.write(dp[N] + "\n");
		bw.flush();
		bw.close();
		bf.close();
	}

}
