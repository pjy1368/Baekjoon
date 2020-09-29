import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			String input = bf.readLine();
			if (input.equals("top")) {
				if (stack.empty()) {
					bw.write("-1" + "\n");
				} else {
					bw.write(stack.lastElement() + "\n");
				}
			} else if (input.equals("size")) {
				bw.write(stack.size() + "\n");
			} else if (input.equals("empty")) {
				if (stack.empty()) {
					bw.write("1" + "\n");
				} else {
					bw.write("0" + "\n");
				}
			} else if (input.equals("pop")) {
				if (stack.empty()) {
					bw.write("-1" + "\n");
				} else {
					int pop = stack.pop();
					bw.write(pop + "\n");
				}
			} else {
				StringTokenizer st = new StringTokenizer(input);
				st.nextToken();
				stack.push(Integer.parseInt(st.nextToken()));
			}
		}

		bw.flush();
		bf.close();
		bw.close();
	}

}
