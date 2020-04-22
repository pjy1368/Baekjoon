package no.jam;

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

		long A = Long.parseLong(st.nextToken()) - 1;
		long B = Long.parseLong(st.nextToken());

		bw.write((sum(B) - sum(A)) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static long sum(long n) {
		long result = 0;
		long token = 1; // 2^0, 2^1, 2^2, ... �Ʒ��� �ִ� now�� �������� now�� ������ ������ ��Ʈ���� ����.
		long prev = 0; // �Ʒ��� �ִ� now�� 1�� ��, now ���Ϸ� �����ϴ� ������ ��Ʈ���� ����� ��(1�� ����).

		for (int i = 0; i < 55; i++) {
			long now = n & token; // ��Ʈ������ ���� ����Ű�� ��ġ. (�� �����ʺ��� �� ĭ�� �������� �̵�.)

			if (now != 0) {
				// n = 1111 �̰�, ���� now�� �ǿ����� ��Ʈ�� ����Ű�� �ִٸ�,
				// 1110 ~ 1111 �߿� �ǿ����� ��Ʈ�� 1�� ��츦 ��.

				result += prev + 1;
				prev += token; // token�� Ŀ���Ƿ� prev�� ���� ������Ʈ�� �־����.
			}

			if (n - prev == 0) { // n�� prev�� ��������, ���̻� �տ� ��Ʈ�� �������� �ʴ´ٴ� �ǹ��̹Ƿ� Ž���� ������.
				break;
			}

			// now�� �������� now�� ������ ������ ��Ʈ���� ����� �� * ���� ��Ʈ���� ������ ��.
			// ���� ���, n = 1111�̰�, now = 1(�� ������)�� ���, 0000 ~ 1101(1110 ���� �ϳ� ���� ��) �߿� �ǿ�����
			// �ڸ� ���� 1�� ��츦 ��� ��.

			// ���� ���, n = 1111�̰�, now = 1(�����ʿ��� 2��°)�� ���, 0000 ~ 1011(1100���� �ϳ� ���� ��) �߿�
			// �����ʿ��� 2��° �ڸ����� 1�� ��츦 ��� ��.

			result += token * (n >> (i + 1));

			token <<= 1;
		}
		return result;
	}

}