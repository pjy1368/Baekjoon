package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int Sm = Integer.parseInt(st.nextToken()); // �迭�� ũ��
			int Sc = Integer.parseInt(st.nextToken()); // ��ɾ��� ����
			int Si = Integer.parseInt(st.nextToken()); // input�� ����

			String programCode = br.readLine();
			String inputCode = br.readLine();

			int[] arr = new int[Sm];
			int pointerPos = 0; // �����Ͱ� ����Ű�� ��ġ.
			int inputPos = 0; // inputCode�� ���� �Է¹޾ƾ��ϴ� ��ġ.

			Stack<Integer> stack = new Stack<>();
			int[] bracket = new int[Sc]; // ���� ����Ǿ��ִ� ��ȣ�� ��ġ.
			for (int i = 0; i < Sc; i++) {
				char c = programCode.charAt(i);

				if (c == '[') {
					stack.add(i);
				} else if (c == ']') { // �ݴ� ��ȣ�� ���� ��ȣ�� ���� ������� ��.
					int temp = stack.peek();
					bracket[i] = temp; // ���� ��ȣ���� �ݴ� ��ȣ�� ��ġ��
					bracket[temp] = i; // �ݴ� ��ȣ���� ���� ��ȣ�� ��ġ�� ������.
					stack.pop();
				}
			}

			int maxCloseBracket = 0; // �̰��� ����ϴ� ������ �Ʒ����� �����.
			int cnt = 0; // �ݺ� Ƚ��.
			for (int i = 0; i < Sc; i++) {
				char c = programCode.charAt(i);

				switch (c) {
				case '-':
					arr[pointerPos] = (arr[pointerPos] - 1) < 0 ? 255 : (arr[pointerPos] - 1);
					break;
				case '+':
					arr[pointerPos] = (arr[pointerPos] + 1) > 255 ? 0 : (arr[pointerPos] + 1);
					break;
				case '<':
					pointerPos = (pointerPos - 1) == -1 ? Sm - 1 : (pointerPos - 1);
					break;
				case '>':
					pointerPos = (pointerPos + 1) == Sm ? 0 : (pointerPos + 1);
					break;
				case '[':
					if (arr[pointerPos] == 0) {
						i = bracket[i]; // ���� ��ġ�� �ݴ� ��ȣ�� ��ġ�� ������.
					}
					break;
				case ']':
					if (arr[pointerPos] != 0) {
						// �ݴ� ��ġ�� �ִ��� ���ϴ� ����.
						// ���ѷ����� ���ٴ� �ǹ̴� ��� ��ġ���� �������� ��� �Դٰ����Ѵٴ� �ǹ��̹Ƿ�
						// ���ѷ����� ���� �ʴ´ٸ�, �ݴ� ��ȣ�� ��ġ�� ���� �������� ���� �� ����.
						maxCloseBracket = Math.max(maxCloseBracket, i);
						i = bracket[i]; // ���� ��ġ�� ���� ��ȣ�� ��ġ�� ������.
					}
					break;
				case '.':
					break;
				case ',':
					arr[pointerPos] = (inputPos == Si) ? 255 : (int) inputCode.charAt(inputPos++);
				}

				if (++cnt == 50000000) {
					ans.append("Loops " + bracket[maxCloseBracket] + " " + maxCloseBracket + " \n");
					break;
				}
			}

			if (cnt < 50000000) {
				ans.append("Terminates\n");
			}
		}

		bw.write(ans.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}