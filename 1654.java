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
		int K = Integer.parseInt(st.nextToken()); // 오영식이 가지고 있는 랜선의 개수
		int N = Integer.parseInt(st.nextToken()); // 만들어야하는 랜선의 개수

		long[] kLen = new long[K + 1];
		long scope = Integer.MIN_VALUE;
		for (int i = 1; i <= K; i++) {
			int temp = Integer.parseInt(br.readLine());
			kLen[i] = temp;
			scope = Math.max(scope, temp);
		}

		bw.write(binarySearch(kLen, scope, N) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static long binarySearch(long[] kLen, long scope, int n) {
		long first = 1;
		long last = scope;
		long mid = 0;
		long result = 0;

		while (first <= last) {
			mid = (first + last) / 2;
			int total = 0;
			for (int i = 1; i < kLen.length; i++) {
				total += kLen[i] / mid;
			}

			if (n <= total) {
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
