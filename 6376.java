import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("n e\n");
		bw.write("- -----------\n");
		bw.write("0 1\n");
		bw.write("1 2\n");
		bw.write("2 2.5\n");
		bw.write("3 2.666666667\n");
		bw.write("4 2.708333333\n");
		
		for(int n = 5; n <= 9; n++) {
			double sum = 0;
			for(int i = 0; i <= n; i++) {
				sum += 1 / Factorial(i);
			}
			bw.write(n + " " + String.format("%.9f", sum) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	public static double Factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}

		int sum = 1;
		for (int i = 2; i <= n; i++) {
			sum *= i;
		}
		return sum;
	}

}
