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
		long N = Long.parseLong(st.nextToken()); // 나무의 수
		long M = Long.parseLong(st.nextToken()); // 집으로 가져가야하는 나무의 길이

		long[] kLen = new long[1000001];
		st = new StringTokenizer(br.readLine());
		long scope = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			long temp = Long.parseLong(st.nextToken());
			kLen[i] = temp;
			scope = Math.max(scope, temp);
		}

		bw.write(binarySearch(kLen, scope, N, M) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static long binarySearch(long[] kLen, long scope, long N, long M) {
		long first = 0;
		long last = scope;
		long mid = 0;
		long result = Long.MIN_VALUE;

		while (first <= last) {
			mid = (first + last) / 2;
			long total = 0;

			for (int i = 1; i <= N; i++) {
				if (kLen[i] <= mid) {
					continue;
				}

				total += kLen[i] - mid;
			}

			if (M <= total) {
				if (result < mid) {
					result = mid;
					first = mid + 1;
				}
			} else {
				last = mid - 1;
			}

		}

		return result;
	}

}
