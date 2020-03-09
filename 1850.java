import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = bf.readLine();
		StringTokenizer st = new StringTokenizer(input);
		Long num1 = Long.parseLong(st.nextToken());
		Long num2 = Long.parseLong(st.nextToken());
		Long gcd = GCD(num1, num2);
		
		for(int i = 0; i < gcd; i++) {
			bw.write("1");
		}
		
		bw.write("\n");
		bw.flush();
		bf.close();
		bw.close();
	}

	public static long GCD(long A, long B) {
		if (B == 0) {
			return A;
		}
		return GCD(B, A % B);
	}

	//public static int LCM(int A, int B) {
		//return A * B / GCD(A, B);
	//}

}
