import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static int N, S, half;
	static Vector<Long> v;
	static Map<Long, Long> map;
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		half = N / 2;
		v = new Vector<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			v.add(Long.parseLong(st.nextToken()));
		}

		map = new HashMap<>();

		ans = 0;
		dfsLeft(0, 0);
		dfsRight(half, 0);

		if (S == 0) {
			ans--;
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfsLeft(int idx, long sum) {
		if (idx == half) {
			if (map.containsKey(sum)) {
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, (long) 1);
			}
			return;
		}

		dfsLeft(idx + 1, sum);
		dfsLeft(idx + 1, sum + v.get(idx));
	}

	public static void dfsRight(int idx, long sum) {
		if (idx == N) {
			if (map.containsKey(S - sum)) {
				ans += map.get(S - sum);
			}
			return;
		}

		dfsRight(idx + 1, sum);
		dfsRight(idx + 1, sum + v.get(idx));
	}

}
