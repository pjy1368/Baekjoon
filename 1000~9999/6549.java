import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			if (N == 0) {
				break;
			}

			arr = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			tree = new int[N * 4];
			init(1, 1, N);

			sb.append(getMax(1, N, N) + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	// 각 구간 별로 높이가 낮은 인덱스를 저장.
	public static void init(int node, int start, int end) {
		// 리프 노드에는 start index를 넣음.
		if (start == end) {
			tree[node] = start;
		} else {
			int mid = (start + end) / 2;
			init(node * 2, start, mid);
			init(node * 2 + 1, mid + 1, end);

			// 각 구간에서 가장 높이가 낮은 값의 index을 노드에 넣음.
			if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
				tree[node] = tree[node * 2];
			} else {
				tree[node] = tree[node * 2 + 1];
			}
		}
	}

	// 특정 구간 내의 최소 높이의 인덱스를 구함.
	public static int query(int start, int end, int node, int left, int right) {
		if (right < start || end < left) {
			return -1;
		}

		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;
		int m1 = query(start, mid, node * 2, left, right);
		int m2 = query(mid + 1, end, node * 2 + 1, left, right);
		
		if (m1 == -1) {
			return m2;
		} else if (m2 == -1) {
			return m1;
		} else {
			if (arr[m1] <= arr[m2]) {
				return m1;
			} else {
				return m2;
			}
		}
	}

	public static long getMax(int start, int end, int N) {
		int m = query(1, N, 1, start, end);

		long area = (end - start + 1) * (long) arr[m];

		// 왼쪽 막대 존재 여부 확인
		if (start <= m - 1) {
			long tmp = getMax(start, m - 1, N);

			area = Math.max(area, tmp);
		}

		// 오른쪽 막대 존재 여부 확인
		if (m + 1 <= end) {
			long tmp = getMax(m + 1, end, N);

			area = Math.max(area, tmp);
		}

		return area;
	}

}