import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = "";
		outer: while (!(input = br.readLine()).equals(".")) {
			Stack<Character> bracket = new Stack<>();

			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '(') {
					bracket.push('(');
				} else if (input.charAt(i) == ')') {
					if (bracket.isEmpty()) {
						bw.write("no\n");
						continue outer;
					}

					char c = bracket.pop();
					if (c != '(') {
						bw.write("no\n");
						continue outer;
					}
				} else if (input.charAt(i) == '[') {
					bracket.push('[');
				} else if (input.charAt(i) == ']') {
					if (bracket.isEmpty()) {
						bw.write("no\n");
						continue outer;
					}

					char c = bracket.pop();
					if (c != '[') {
						bw.write("no\n");
						continue outer;
					}
				}
			}

			if (!bracket.isEmpty()) {
				bw.write("no\n");
				continue outer;
			}

			bw.write("yes\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
