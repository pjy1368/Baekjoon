import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int K = scan.nextInt();
		int total = 0;
		for (int i = 0; i < K; i++) {
			int input = scan.nextInt();
			if (input == 0) {
				stack.pop();
			} else {
				stack.push(input);
			}
		}

		int size = stack.size();
		for (int i = 0; i < size; i++) {
			total += stack.pop();
		}

		System.out.println(total);
	}

}
