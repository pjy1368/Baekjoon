package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] element = (br.readLine()).split("");
		int bracket = 0;

		for (int i = 0; i < element.length; i++) {
			if (element[i].equals("(") || element[i].equals(")")) {
				bracket++;
			}
		}

		String[] prefix = Prefix_Notation(element, bracket);
		for (int i = 0; i < prefix.length; i++) {
			bw.write(prefix[i]);
		}

		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}

	// ����ǥ����� ����ǥ������� ��ȯ�ϴ� �Լ�.
	public static String[] Prefix_Notation(String[] element, int bracket) {
		String[] prefix = new String[element.length - bracket]; // ��ȣ�� ǥ���� �ʿ� ����.
		Stack<String> stack = new Stack<>();

		int cnt = 0;
		for (int i = 0; i < element.length; i++) {
			String str = element[i];

			// �ǿ����ڶ�� stack�� ���� �ʰ�, prefix �迭�� �ִ´�.
			if (!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/") && !str.equals("(")
					&& !str.equals(")")) {
				prefix[cnt++] = str;
			} else {
				if (!str.equals("(") && !str.equals(")")) { // �������� ��� stack�� �ִ´�.
					if (str.equals("+") || str.equals("-")) {
						// str�� '+' Ȥ�� '-'�� ��� '('�� ������ ������ �����ڰ� �켱������ �����Ƿ� ������ ���ÿ��� pop�Ѵ�.
						while (!stack.isEmpty()) {
							String now = stack.peek();
							if (now.equals("(")) {
								break;
							} else {
								prefix[cnt++] = stack.pop();
							}
						}
					} else { // str�� '*' Ȥ�� '/'�� ��� ���κ��� �켱������ ���� ��Ҹ� ���ÿ��� ã�� �Ǹ� pop���� ���� �״�� break�Ѵ�.
						while (!stack.isEmpty()) {
							String now = stack.peek();
							if (now.equals("(") || now.equals("+") || now.equals("-")) {
								break;
							} else {
								prefix[cnt++] = stack.pop();
							}
						}
					}
					stack.push(str);
				} else {
					if (str.equals("(")) {
						stack.push(str);
					} else {
						while (!stack.peek().equals("(")) { // ")"�� ������ ���, "("���� pop�Ѵ�.
							str = stack.pop();
							prefix[cnt++] = str;
						}
						stack.pop(); // "("�� pop.

					}
				}
			}
		}

		while (!stack.isEmpty()) { // stack�� ���� �����ڰ� ���� ��� ��� pop�Ѵ�.
			String str = stack.pop();
			prefix[cnt++] = str;
		}

		return prefix;
	}

}
