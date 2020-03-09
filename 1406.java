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
		String str = bf.readLine();
		int M = Integer.parseInt(bf.readLine());
		Stack<Character> leftStack = new Stack<>();
		Stack<Character> rightStack = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			leftStack.add(str.charAt(i));
		}
		
		for(int i = 0; i < M; i++) {
			String input = bf.readLine();
			if(input.equals("L")) {
				if(!leftStack.isEmpty()) {
					char temp = leftStack.pop();
					rightStack.add(temp);
				}
			} else if(input.equals("B")) {
				if(!leftStack.isEmpty()) {
					leftStack.pop();
				}
			} else if(input.equals("D")) {
				if(!rightStack.isEmpty()) {
					char temp = rightStack.pop();
					leftStack.add(temp);
				}
			} else {
				StringTokenizer st = new StringTokenizer(input);
				st.nextToken();
				leftStack.add(st.nextToken().charAt(0));
			}
		}
		
		while(!leftStack.isEmpty()) {
			rightStack.add(leftStack.pop());
		}
		
		while(!rightStack.isEmpty()) {
			bw.write(rightStack.pop());
		}
	
		bw.write("\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
