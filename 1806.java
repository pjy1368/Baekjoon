import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ans = Integer.MAX_VALUE;
		int sum = 0;
		int lo = 0;
		int hi = 0;

		while (true) {
			if (sum >= S) {
				sum -= arr[lo++];
				ans = Math.min(ans, hi - lo + 1);
			} else if (hi == N) {
				break;
			} else {
				sum += arr[hi++];
			}

		}

		bw.write(((ans != Integer.MAX_VALUE) ? ans : 0) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
