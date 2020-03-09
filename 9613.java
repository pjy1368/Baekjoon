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
			int N = Integer.parseInt(st.nextToken());
			Long[] arr = new Long[101];
			for(int g = 1; g <= N; g++) {
				arr[g] = Long.parseLong(st.nextToken());
			}
			
			long sum = 0;
			for(int j = 1; j < N; j++) {
				for(int k = j + 1; k <= N; k++) {
					sum += GCD(arr[j], arr[k]);
				}
			}
			
			bw.write(sum + "\n");
		}

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

	// public static int LCM(int A, int B) {
	// return A * B / GCD(A, B);
	// }

}
