import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] people = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(people);
		
		int[] dp = new int[N];
		dp[0] = people[0];
		
		int sum = people[0];
		for(int i = 1; i < N; i++) {
			dp[i] = people[i] + dp[i - 1];
			sum += dp[i];
		}
		
		bw.write(sum + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
