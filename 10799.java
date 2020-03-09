import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = bf.readLine();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(') {
				stack.push('(');
				continue;
			}
			if(input.charAt(i) == ')') {
				if(input.charAt(i - 1) == '(') {
					stack.pop();
					result += stack.size();
				}else {
					stack.pop();
					result++;
				}
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
