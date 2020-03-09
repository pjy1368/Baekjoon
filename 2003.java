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
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0, sum = 0, lo = 0, hi = 0;
		while (true) {
			if (sum >= M) {
				sum -= arr[lo++];
			} else if (hi == N) {
				break;
			} else {
				sum += arr[hi++];
			}

			if (sum == M) {
				result++;
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
