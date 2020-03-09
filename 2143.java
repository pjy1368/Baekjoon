import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Map<Long, Long> map = new HashMap<>();

		int T = Integer.parseInt(br.readLine());

		int N = Integer.parseInt(br.readLine());
		long[] A = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			long sum = 0;
			for (int j = i; j < N; j++) {
				sum += A[j];
				if (map.containsKey(sum)) {
					map.put(sum, map.get(sum) + 1);
				} else {
					map.put(sum, (long) 1);
				}
			}
		}

		int M = Integer.parseInt(br.readLine());
		long[] B = new long[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Long.parseLong(st.nextToken());
		}

		long ans = 0;
		for (int i = 0; i < M; i++) {
			long sum = 0;
			for (int j = i; j < M; j++) {
				sum += B[j];
				if (map.containsKey(T - sum)) {
					ans += map.get(T - sum);
				}
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
