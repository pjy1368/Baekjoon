import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, C;
	static int[] arr;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정수의 개수
		C = Integer.parseInt(st.nextToken()); // 최종적으로 만들어야하는 정수

		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		boolean[] visited = new boolean[N];

		ans = 0;
		for (int i = 1; i <= N; i++) {
			combination(arr, visited, 0, N, i);
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			int total = 0;
			for (int i = 0; i < n; i++) {
				if (visited[i] == true) {
					total += arr[i];
				}
			}

			ans = (total == C) ? ans + 1 : ans;
			return;
		} else {
			for (int i = start; i < n; i++) {
				visited[i] = true;
				combination(arr, visited, i + 1, n, r - 1);
				visited[i] = false;
			}
		}
	}

}
