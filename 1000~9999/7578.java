import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> B = new HashMap<>(); // key - 식별번호, value - 인덱스
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int val = Integer.parseInt(st.nextToken());
			B.put(val, i);
		}

		tree = new long[N * 4];
		long ans = 0;

		for (int i = 1; i <= N; i++) {
			int valA = A[i];
			int valB = B.get(valA); // A[i]와 같은 식별번호가 있는 인덱스를 찾음.

			// valB보다 큰 인덱스 중에 이미 방문한 적 있는 인덱스의 개수를 구함.
			ans += sum(1, N, 1, valB + 1, N);

			// valB를 방문했다는 의미로 1을 더해 줌.
			// 동시에 valB이 포함된 구간합은 모두 1씩 더해질 것임.
			update(1, N, 1, valB, 1);
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static long sum(int start, int end, int node, int left, int right) {
		if (end < left || right < start) {
			return 0;
		}

		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}

	public static void update(int start, int end, int node, int idx, int dif) {
		if (idx < start || idx > end) {
			return;
		}

		tree[node] += dif;

		if (start != end) {
			int mid = (start + end) / 2;
			update(start, mid, node * 2, idx, dif);
			update(mid + 1, end, node * 2 + 1, idx, dif);
		}

	}

}