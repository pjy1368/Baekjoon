package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		String explosion = br.readLine();

		char[] output = new char[str.length()];
		int index = 0; // output�� index

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// ���� ���ڿ��� �� ���� c�� ���� ���
			if (explosion.charAt(explosion.length() - 1) == c) {
				if (index < explosion.length() - 1) { // output���� ���� ���ڿ��� �˻��� ��ŭ�� ���̰� Ȯ���Ǿ����� ���� ���.
					output[index++] = c; // output�� c�� �̾� ����.
				} else { // output���� ���� ���ڿ��� �˻��� ��ŭ�� ���̰� Ȯ���Ǿ��ִ� ���.
					boolean ok = true;
					// output���� c�� �������� �� ���� ���ڿ��� ���� ���ڿ��� �������� Ȯ��.
					for (int j = index - 1, k = explosion.length() - 2; k >= 0; j--, k--) {
						if (output[j] != explosion.charAt(k)) { // ���� ���ڿ��� �ٸ� ���ڰ� ����.
							ok = false;
							break;
						}
					}

					if (ok) { // ���� ���ڿ��� ��ġ��.
						index = index - (explosion.length() - 1); // index�� ���� ���ڿ� �������� �ǵ���.
					} else { // ���� ���ڿ��� ��ġ���� ����.
						output[index++] = c; // output�� c�� �̾� ����.
					}
				}
			} else { // ���� ���ڿ��� �� ���� c�� �ٸ� ���
				output[index++] = c; // output�� c�� �̾� ����.
			}
		}

		StringBuilder ans = new StringBuilder();
		if (index == 0) { // output�� ���ڿ��� ������� ���� ���.
			ans.append("FRULA");
		} else { // output�� ���ڿ��� ����ִ� ���.
			for (int i = 0; i < index; i++) {
				ans.append(output[i]);
			}
		}

		bw.write(ans.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}