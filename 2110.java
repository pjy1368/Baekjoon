import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, C;
	static long[] points;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 집의 개수
		C = Integer.parseInt(st.nextToken()); // 공유기의 개수

		points = new long[N + 1]; // 집의 좌표
		for (int i = 1; i <= N; i++) {
			points[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(points);
		long ans = binarySearch();
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static long binarySearch() {
		long left = 1;
		long right = points[N] - points[1];
		long start = 0;
		long mid = 0;
		long d = 0;
		long ans = 0;
		int cnt = 0;

		while (left <= right) {
			mid = (right + left) / 2;
			start = points[1];
			cnt = 1;

			for (int i = 2; i <= N; i++) {
				d = points[i] - start;
				if (mid <= d) {
					cnt++;
					start = points[i];
				}
			}

			if (cnt >= C) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}
		return ans;
	}

}
