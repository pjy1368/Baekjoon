package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			TreeMap<Long, Long> map = new TreeMap<>(); // key는 정수, value는 입력받은 횟수

			int N = Integer.parseInt(br.readLine());
			while (N-- > 0) {
				st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				long val = Long.parseLong(st.nextToken());

				if (command.equals("I")) {
					if (map.containsKey(val)) {
						map.put(val, map.get(val) + 1);
					} else {
						map.put(val, 1L);
					}
				} else {
					if (map.isEmpty()) {
						continue;
					} else {
						if (val == -1) {
							long minKey = map.firstKey();
							long next = map.get(minKey) - 1;

							if (next == 0) {
								map.remove(minKey);
							} else {
								map.put(minKey, next);
							}
						} else {
							long maxKey = map.lastKey();
							long next = map.get(maxKey) - 1;

							if (next == 0) {
								map.remove(maxKey);
							} else {
								map.put(maxKey, next);
							}
						}
					}
				}
			}
			if (map.isEmpty()) {
				bw.write("EMPTY\n");
			} else {
				bw.write((map.lastKey()) + " " + (map.firstKey()) + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
