import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		int[] rope = new int[N];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(rope);
		
		for(int i = N - 1; i >= 0; i--) {
			max = Math.max(max, rope[i] * (N - i));
		}
		
		bw.write(max + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
