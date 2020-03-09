import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

class Cave {
	int vertex;
	int weight;

	Cave(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}

public class Main {
	static int N, R1, R2;
	static ArrayList<ArrayList<Cave>> a;
	static boolean[] visit;
	static Stack<Integer> stack;
	static Vector<Integer> v;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 동굴의 방의 개수
		R1 = Integer.parseInt(st.nextToken()); // 첫 번째 로봇이 위치한 방
		R2 = Integer.parseInt(st.nextToken()); // 두 번째 로봇이 위치한 방
		
		if(R1 == R2) {
			bw.write("0\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		a = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			a.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			a.get(t).add(new Cave(f, w));
			a.get(f).add(new Cave(t, w));
		}

		visit = new boolean[N + 1];
		stack = new Stack<>();
		v = new Vector<>();
		DFS(R1, 0);

		bw.flush();
		bw.close();
		br.close();
	}

	public static void DFS(int R1, int w) {
		visit[R1] = true;

		if (w != 0) {
			stack.push(w);
		}

		if (R1 == R2) {
			while (!stack.empty()) {
				v.add(stack.pop());
			}

			int[] weight = new int[v.size()];
			int sum = 0;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < v.size(); i++) {
				weight[i] = v.get(i);
				sum += weight[i];
				max = Math.max(max, weight[i]);
			}

			System.out.println((sum - max) + "\n");
			System.exit(0);
		}

		for (Cave c : a.get(R1)) {
			if (!visit[c.vertex]) {
				DFS(c.vertex, c.weight);
			}
		}
		
		if (!stack.empty()) {
			visit[R1] = false;
			stack.pop();
		}
	}
}
