import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class City {
	int vertex;
	int weight;

	City(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}

public class Main {
	static int v;
	static ArrayList<ArrayList<City>> a;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		v = Integer.parseInt(br.readLine());

		a = new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			a.add(new ArrayList<>());
		}

		for (int i = 1; i <= v; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < v; j++) {
				a.get(i).add(new City(j + 1, Integer.parseInt(st.nextToken())));
			}
		}

		boolean[] visit = new boolean[v + 1];
		ans = Integer.MAX_VALUE;

		for (int i = 1; i <= v; i++) {
			visit[i] = true;
			DFS(i, i, visit, 0, 0);
			visit[i] = false;
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void DFS(int start, int node, boolean[] visit, int w, int cnt) {
		if (cnt == v - 1) {
			for (City c : a.get(node)) {
				if (c.vertex == start && c.weight != 0) {
					ans = Math.min(ans, w + c.weight);
					return;
				}
			}
		} else {
			for (City c : a.get(node)) {
				if (c.weight == 0) {
					continue;
				}

				if (!visit[c.vertex]) {
					visit[c.vertex] = true;
					DFS(start, c.vertex, visit, w + c.weight, cnt + 1);
					visit[c.vertex] = false;
				}
			}
		}
	}

}
