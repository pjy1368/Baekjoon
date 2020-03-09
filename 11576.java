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
		String input = bf.readLine();
		StringTokenizer st = new StringTokenizer(input);

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(bf.readLine());
		input = bf.readLine();
		st = new StringTokenizer(input);

		int result = 0;
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken()); // A진법으로 표현된 수
			result += num * Math.pow(A, m - (i + 1));
		}
		
		Stack<Integer> stack = new Stack<>();
		while(result != 0) {
			stack.add(result % B);
			result /= B;
		}
		
		bw.write(Integer.toString(stack.pop()));
		
		while(!stack.empty()) {
			bw.write(" " + stack.pop());
		}
		
		bw.write("\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
