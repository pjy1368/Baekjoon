package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		long[][] arr = new long[N][4];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Long.parseLong(st.nextToken());
			}
		}

		long[] AB = new long[N * N];
		Map<Long, Long> map = new HashMap<>();
		int idx = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				AB[idx++] = arr[i][0] + arr[j][1];
				long sum = arr[i][2] + arr[j][3];

				if (map.containsKey(sum)) {
					map.put(sum, map.get(sum) + 1);
				} else {
					map.put(sum, 1L);
				}
			}
		}

		long ans = 0;
		for (int i = 0; i < AB.length; i++) {
			long key = -AB[i];

			if (map.containsKey(key)) {
				ans += map.get(key);
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}