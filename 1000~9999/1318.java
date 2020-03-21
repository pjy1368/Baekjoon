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

	// 중위표기식을 후위표기식으로 변환하는 함수.
	public static String[] Prefix_Notation(String[] element, int bracket) {
		String[] prefix = new String[element.length - bracket]; // 괄호는 표시할 필요 없다.
		Stack<String> stack = new Stack<>();

		int cnt = 0;
		for (int i = 0; i < element.length; i++) {
			String str = element[i];

			// 피연산자라면 stack에 넣지 않고, prefix 배열에 넣는다.
			if (!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/") && !str.equals("(")
					&& !str.equals(")")) {
				prefix[cnt++] = str;
			} else {
				if (!str.equals("(") && !str.equals(")")) { // 연산자일 경우 stack에 넣는다.
					if (str.equals("+") || str.equals("-")) {
						// str이 '+' 혹은 '-'일 경우 '('를 제외한 나머지 연산자가 우선순위가 높으므로 무조건 스택에서 pop한다.
						while (!stack.isEmpty()) {
							String now = stack.peek();
							if (now.equals("(")) {
								break;
							} else {
								prefix[cnt++] = stack.pop();
							}
						}
					} else { // str이 '*' 혹은 '/'일 경우 본인보다 우선순위가 낮은 요소를 스택에서 찾게 되면 pop하지 말고 그대로 break한다.
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
						while (!stack.peek().equals("(")) { // ")"을 만났을 경우, "("까지 pop한다.
							str = stack.pop();
							prefix[cnt++] = str;
						}
						stack.pop(); // "("을 pop.

					}
				}
			}
		}

		while (!stack.isEmpty()) { // stack에 남은 연산자가 있을 경우 모두 pop한다.
			String str = stack.pop();
			prefix[cnt++] = str;
		}

		return prefix;
	}

}
