import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String input = "";

		while (!(input = br.readLine()).equals("0")) {
			st = new StringTokenizer(input);

			int N = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			boolean[] visit = new boolean[N];
			DFS(arr, visit, N, 0, 0);
			System.out.println();
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static void DFS(int[] arr, boolean[] visit, int N, int start, int cnt) {
		if (cnt == 6) {
			for (int i = 0; i < N; i++) {
				if (visit[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}

		for (int i = start; i < N; i++) {
			visit[i] = true;
			DFS(arr, visit, N, i + 1, cnt + 1);
			visit[i] = false;
		}
	}

}
