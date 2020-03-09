import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int tryNum(int N) {
		int[] D = new int[N + 1];
		D[0] = D[1] = 0;
		for (int i = 2; i <= N; i++) {
			D[i] = D[i - 1] + 1;
			
			if (i % 2 == 0) {
				D[i] = Math.min(D[i], D[i / 2] + 1);
			} 
			
			if (i % 3 == 0) {
				D[i] = Math.min(D[i], D[i / 3] + 1);
			} 
		}
		return D[N];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		System.out.println(tryNum(N));
		bf.close();
	}

}
