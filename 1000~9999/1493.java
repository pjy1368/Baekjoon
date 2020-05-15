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

		int L = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());

		int[] cube = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());

			cube[t] = f;
		}

		long before = 0; // ������ ���� ť���� ����
		long ans = 0;
		for (int i = N - 1; i >= 0; i--) { // �ݺ����� �� ������, �ڽ��� 2^i x 2^i x 2^i�� �����ؼ� �����Ѵ�.
			// ���� �ڽ��� before���� ������ 1�� �� ���������Ƿ� before�� ������ 2^3��ŭ �÷��־�� �Ѵ�.
			// ���� ���, 4 x 4 x 4 ���� �ܰ迡�� before = 1�̾��ٰ� ����.
			// �׷���, ����� 2 x 2 x 2 ������ �ǹǷ� before = 8�� �ȴ�.
			before <<= 3;

			// �ڽ��� 2^i x 2^i x 2^i��ŭ ������ �ְ�, ���� �ڽ��� ä���� ť���� ����(before)��ŭ �� �ش�.
			// ����, ������ �Ұ����ϴٸ� 0�� ���� ���̴�.
			long possibleCube = (long) (L >> i) * (W >> i) * (H >> i) - before;
			long newCube = Math.min((long) cube[i], possibleCube); // ���Ӱ� �ڽ��� �߰��� ť��

			before += newCube; // ���Ӱ� �߰��� ť��� ���� �ݺ������� ���Ű� �ǹǷ� before�� �߰��� �ش�.
			ans += newCube;
		}

		if (before == (long) L * W * H) { // ������ ����� before�� ���� �ڽ��� ���ǿ� ���ƾ� ��.
			bw.write(ans + "\n");
		} else { // ���� ������, �־��� ť��δ� �ڽ��� ������ �� ����.
			bw.write("-1\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
