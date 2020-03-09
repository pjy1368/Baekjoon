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
		long[] numbers = new long[1000000];
		boolean isZero = false;

		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(bf.readLine());
			if(numbers[i] == 0) {
				isZero = true;
			}
		}
		
		Arrays.sort(numbers);
		for(int i = 0; i < N; i++) {
			if(isZero && numbers[i] == 0) {
				bw.write(0 + "\n");
				isZero = !isZero;
				continue;
			} else if(!isZero && numbers[i] == 0) {
				N++;
				continue;
			}
			bw.write(numbers[i] + "\n");
		}

		

		bw.flush();
		bw.close();
		bf.close();
	}

}
