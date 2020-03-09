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
		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			String input = bf.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			bw.write(LCM(A, B) + "\n");
		}

		bw.flush();
		bf.close();
		bw.close();
	}

	public static int GCD(int A, int B) {
		if (B == 0) {
			return A;
		}
		return GCD(B, A % B);
	}

	public static int LCM(int A, int B) {
		return A * B / GCD(A, B);
	}

}
