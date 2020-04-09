package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 파티의 수
		boolean[] known = new boolean[N + 1]; // 어떤 사람이 진실을 알고있는지 판별하는 배열

		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
		if (t > 0) {
			for (int i = 1; i <= t; i++) {
				int temp = Integer.parseInt(st.nextToken());
				known[temp] = true;
			}
		} else { // t = 0일 경우 모든 파티에서 과장되게 말할 수 있음.
			bw.write(M + "\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		int m = M;
		int[][] people = new int[M][];
		int ans = 0;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 파티에 참여하는 사람.

			if (num >= 1) {
				people[M - m - 1] = new int[num]; // 파티에 참여하는 사람의 배열.
				for (int i = 0; i < num; i++) {
					people[M - m - 1][i] = Integer.parseInt(st.nextToken());
				}

				boolean isTrue = false; // 이 파티에서 진실되게 말해야하는가?
				for (int i = 0; i < num; i++) {
					if (known[people[M - m - 1][i]]) { // 파티에 오는 사람 중 진실을 아는 사람이 있다면
						isTrue = true;
						break;
					}
				}

				if (isTrue) {
					for (int i = 0; i < num; i++) {
						known[people[M - m - 1][i]] = true; // 현재 파티에 참석한 사람 모두를 진실을 아는 사람으로 판정.
					}
				}
			} else {
				ans++;
			}
		}

		// 연쇄적으로 진실을 아는 사람 판정.
		for (int n = 0; n < 100; n++) {
			for (int i = 0; i < people.length; i++) {
				if (people[i] == null) {
					continue;
				}

				boolean isTrue = false;
				for (int j = 0; j < people[i].length; j++) {
					if (known[people[i][j]]) { // 진실이 아는 사람이 존재한다면
						isTrue = true;
						break;
					}
				}

				if (isTrue) {
					for (int k = 0; k < people[i].length; k++) {
						known[people[i][k]] = true; // 그 파티의 모든 사람을 아는 사람 목록에 추가
					}
				}
			}
		}

		for (int i = 0; i < people.length; i++) {
			if (people[i] == null) {
				continue;
			}

			boolean isTrue = false;
			for (int j = 0; j < people[i].length; j++) {
				if (known[people[i][j]]) { // 진실을 아는 사람이 존재한다면
					isTrue = true;
					break;
				}
			}

			if (!isTrue) { // 진실을 아는 사람이 존재하지 않는다면
				ans++;
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}