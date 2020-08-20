package no.jam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] tree, arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		tree = new int[N * 4];

		init(1, N, 1);
		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				update(1, N, 1, b, c);
			} else if (a == 2) {
				sb.append(query(1, N, 1, b, c) + "\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	// 모든 구간 별로 최솟값의 인덱스을 설정.
	public static void init(int start, int end, int node) {
		if (start == end) {
			tree[node] = start;
		} else {
			int mid = (start + end) / 2;
			init(start, mid, node * 2);
			init(mid + 1, end, node * 2 + 1);

			if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
				tree[node] = tree[node * 2];
			} else {
				tree[node] = tree[node * 2 + 1];
			}
		}
	}

	// left ~ right 중에 최솟값을 반환
	public static int query(int start, int end, int node, int left, int right) {
		if (left > end || right < start) {
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

	public static void update(int start, int end, int node, int idx, int val) {
		if (idx < start || idx > end) {
			return;
		}

		// 리프 노드
		if (start == end) {
			tree[node] = idx;
			arr[idx] = val;
			return;
		}

		int mid = (start + end) / 2;

		// 리프 노드와 연결된 트리의 가지 전체를 업데이트
		update(start, mid, node * 2, idx, val);
		update(mid + 1, end, node * 2 + 1, idx, val);
		
		if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
			tree[node] = tree[node * 2];
		} else {
			tree[node] = tree[node * 2 + 1];
		}
	}

}
