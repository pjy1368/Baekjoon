import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int count;
	static boolean[] visited;
	static boolean[] finished;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			visited = new boolean[n + 1]; // 노드의 방문 여부
			finished = new boolean[n + 1]; // 노드의 중복 사이클 시작점
			// 예를 들어, 1->3->3이라고 하고, 2->1->3->3이라 할 때, 1은 2에서 finished 역할을 함.
			count = 0; // 사이클을 이루는 요소의 개수

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				dfs(i);
			}

			bw.write((n - count) + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int now) {
		if (visited[now]) {
			return;
		}

		visited[now] = true;
		int next = arr[now];

		if (!visited[next]) {
			dfs(next);
		} else {
			if (!finished[next]) {
				// 노드가 끝나려면 싸이클을 무조건 거쳐야한다.
				// 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재
				count++;
				for (int i = next; i != now; i = arr[i])
					count++;
			}
		}

		// 모든 작업이 끝나서 더이상 사용하지 않음
		finished[now] = true;
	}
}
