import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int v, e;
	static int[] inDegree;
	static int[] rule;
	static ArrayList<ArrayList<Integer>> a;
	static int endV;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int n = 0; n < T; n++) {
			st = new StringTokenizer(br.readLine());

			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			inDegree = new int[v + 1];
			a = new ArrayList<>();

			rule = new int[v + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= v; i++) {
				rule[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i <= v; i++) {
				a.add(new ArrayList<>());
			}

			for (int i = 0; i < e; i++) { // 방향 그래프
				st = new StringTokenizer(br.readLine());
				int t = Integer.parseInt(st.nextToken());
				int f = Integer.parseInt(st.nextToken());

				a.get(t).add(f);
				inDegree[f]++;
			}

			endV = Integer.parseInt(br.readLine());
			topologicalSort();
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void topologicalSort() {
		int[] result = new int[v + 1];
		Queue<Integer> q = new LinkedList<>();

		// 진입 차수가 0인 노드를 큐에 삽입합니다.
		for (int i = 1; i <= v; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
				result[i] = rule[i];
			}
		}

		// 노드의 개수만큼 반복문을 수행합니다.
		for (int i = 1; i <= v; i++) {
			// n개를 방문하기 전에 큐가 비어버리면 사이클이 발생한 것입니다.
			if (q.isEmpty()) {
				// System.out.println("사이클이 발생했습니다.");
				return;
			}

			int x = q.poll();

			if (x == endV) {
				sb.append(result[x] + "\n");
				return;
			}

			for (int j = 0; j < a.get(x).size(); j++) {
				int y = a.get(x).get(j);

				// 새롭게 진입차수가 0인 된 정점을 큐에 추가합니다.
				if (--inDegree[y] == 0) {
					q.offer(y);
				}

				if (result[y] < result[x] + rule[y]) {
					result[y] = result[x] + rule[y];
				}

			}
		}
	}
}
