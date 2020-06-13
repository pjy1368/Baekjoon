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
			int Sm = Integer.parseInt(st.nextToken()); // 배열의 크기
			int Sc = Integer.parseInt(st.nextToken()); // 명령어의 길이
			int Si = Integer.parseInt(st.nextToken()); // input의 길이

			String programCode = br.readLine();
			String inputCode = br.readLine();

			int[] arr = new int[Sm];
			int pointerPos = 0; // 포인터가 가리키는 위치.
			int inputPos = 0; // inputCode의 현재 입력받아야하는 위치.

			Stack<Integer> stack = new Stack<>();
			int[] bracket = new int[Sc]; // 서로 연결되어있는 괄호의 위치.
			for (int i = 0; i < Sc; i++) {
				char c = programCode.charAt(i);

				if (c == '[') {
					stack.add(i);
				} else if (c == ']') { // 닫는 괄호와 여는 괄호를 서로 연결시켜 줌.
					int temp = stack.peek();
					bracket[i] = temp; // 여는 괄호에는 닫는 괄호의 위치를
					bracket[temp] = i; // 닫는 괄호에는 여는 괄호의 위치를 저장함.
					stack.pop();
				}
			}

			int maxCloseBracket = 0; // 이것을 사용하는 이유는 아래에서 기술함.
			int cnt = 0; // 반복 횟수.
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
						i = bracket[i]; // 현재 위치를 닫는 괄호의 위치로 점프함.
					}
					break;
				case ']':
					if (arr[pointerPos] != 0) {
						// 닫는 위치의 최댓값을 구하는 이유.
						// 무한루프가 돈다는 의미는 어떠한 위치에서 앞쪽으로 계속 왔다갔다한다는 의미이므로
						// 무한루프가 돌지 않는다면, 닫는 괄호의 위치는 점점 뒤쪽으로 가게 될 것임.
						maxCloseBracket = Math.max(maxCloseBracket, i);
						i = bracket[i]; // 현재 위치를 여는 괄호의 위치로 점프함.
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