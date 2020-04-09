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

		int N = Integer.parseInt(st.nextToken()); // ����� ��
		int M = Integer.parseInt(st.nextToken()); // ��Ƽ�� ��
		boolean[] known = new boolean[N + 1]; // � ����� ������ �˰��ִ��� �Ǻ��ϴ� �迭

		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken()); // ������ �ƴ� ����� ��
		if (t > 0) {
			for (int i = 1; i <= t; i++) {
				int temp = Integer.parseInt(st.nextToken());
				known[temp] = true;
			}
		} else { // t = 0�� ��� ��� ��Ƽ���� ����ǰ� ���� �� ����.
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
			int num = Integer.parseInt(st.nextToken()); // ��Ƽ�� �����ϴ� ���.

			if (num >= 1) {
				people[M - m - 1] = new int[num]; // ��Ƽ�� �����ϴ� ����� �迭.
				for (int i = 0; i < num; i++) {
					people[M - m - 1][i] = Integer.parseInt(st.nextToken());
				}

				boolean isTrue = false; // �� ��Ƽ���� ���ǵǰ� ���ؾ��ϴ°�?
				for (int i = 0; i < num; i++) {
					if (known[people[M - m - 1][i]]) { // ��Ƽ�� ���� ��� �� ������ �ƴ� ����� �ִٸ�
						isTrue = true;
						break;
					}
				}

				if (isTrue) {
					for (int i = 0; i < num; i++) {
						known[people[M - m - 1][i]] = true; // ���� ��Ƽ�� ������ ��� ��θ� ������ �ƴ� ������� ����.
					}
				}
			} else {
				ans++;
			}
		}

		// ���������� ������ �ƴ� ��� ����.
		for (int n = 0; n < 100; n++) {
			for (int i = 0; i < people.length; i++) {
				if (people[i] == null) {
					continue;
				}

				boolean isTrue = false;
				for (int j = 0; j < people[i].length; j++) {
					if (known[people[i][j]]) { // ������ �ƴ� ����� �����Ѵٸ�
						isTrue = true;
						break;
					}
				}

				if (isTrue) {
					for (int k = 0; k < people[i].length; k++) {
						known[people[i][k]] = true; // �� ��Ƽ�� ��� ����� �ƴ� ��� ��Ͽ� �߰�
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
				if (known[people[i][j]]) { // ������ �ƴ� ����� �����Ѵٸ�
					isTrue = true;
					break;
				}
			}

			if (!isTrue) { // ������ �ƴ� ����� �������� �ʴ´ٸ�
				ans++;
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}