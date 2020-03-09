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
		int[] sequence = new int[1001]; // 수열
		int[] dp = new int[1001]; // 부분 길이

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sequence[i] = temp;
		}
		
		int length = 0;
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (sequence[i] < sequence[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
			length = Math.max(length, dp[i]);
		}

		bw.write(length + "\n");
		bw.flush();
		bw.close();
		bf.close();
	}

}
