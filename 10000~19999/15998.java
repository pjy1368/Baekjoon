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
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		long a, b;
		long minB = (long) 10e18; // �Ʒ��� ��޵� b�� �ּڰ�
		long balance = 0; // ���� �ܾ�

		boolean valid = true;
		long M = 0; // �ּ� ��� �ݾ�
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Long.parseLong(st.nextToken()); // �Ա� �Ǵ� ��ݾ�
			b = Long.parseLong(st.nextToken()); // �Ա� �Ǵ� ����� �� �� ���� �ܾ�

			// ���� �ܾ׿��� ��ݾ��� �Q�� ��, ������ ���� ���
			// ���¿��� M��ŭ ����ؾ� ��.
			if (balance + a < 0) {
				// (balance + M x n) + a = b -> n�� M�� ����ϴ� Ƚ��.
				// M x n = b - a - balance
				// �ڵ� �����׿� ���� ���� M x n�̹Ƿ�
				// ��� �ڵ� �������� M�� ����� �����ٴ� ����� �� �� �ִ�.
				// ���������, �� ������ �����ϴ� �ݺ����� �� ������ M�� �ִ������� �ʱ�ȭ���ָ� �ȴ�.
				// M�� �ӽ� ������ temp�� �ξ���.
				long temp = b - a - balance;

				// minB�� b�� �ּڰ��� �ǵ��� �ʱ�ȭ.
				if (b != 0 && b < minB) {
					minB = b;
				}

				if (M == 0) {
					// M�� 0�� ����
					// �ܼ��� temp�� �����ϸ� ��.
					M = temp;
				} else {
					// M�� 0�� �ƴ� ����
					// M�� temp�� �ִ������� ���ؼ�
					// M�� ������.
					M = GCD(M, temp);

					// ��� �Ǵ� �Ա��� �ϰ� �� ��, minB�� M���� ũ�ų� ������ ���.
					// ��, minB = (long)10e18�� ���� minB�� �ʱ� �����̹Ƿ�
					// ���� ����� ������� ������ �� ����.
					if (M <= minB && minB != (long) 10e18) {
						valid = false;
						break;
					}
				}
			} else { // ���� �ܾ׿��� �Ա��� �ϰų�, ���� �ܾ��� �ʰ����� �ʴ� ��ŭ ����� �� ���
				// ���� �ܾ׿��� �Ա��ϰų� ����� �� ����� b�� �ٸ��� ���.
				if (balance + a != b) {
					valid = false;
					break;
				}
			}

			// ���� �ܾ��� ���� �ܾ����� �ʱ�ȭ.
			balance = b;
		}

		if (valid && M != 0) {
			// ����� �߻����� �ʾҰ�, M�� 1�̻��� �ִ� ������� ���� ���
			bw.write(M + "\n");
		} else if (valid && M == 0) {
			// ����� �߻����� �ʾ�����, �Ա� �Ǵ� ����� ���� ��
			// ���� �ܾ��� ������ �߻����� �ʾƼ� M�� ����� ���� ���� ���
			bw.write("1\n");
		} else {
			// ����� �߻��� ���
			bw.write("-1\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	// ��Ŭ���� ȣ����
	public static long GCD(long a, long b) {
		while (b > 0) {
			long tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}
}