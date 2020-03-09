import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		if (N == 0) {
			bw.write("0\n");
			bw.flush();
			bf.close();
			bw.close();
			return;
		}

		StringBuffer result = new StringBuffer();
		while (N != 0) {
			result.append(Math.abs(N % -2));
			int temp = (int) Math.ceil((double) N / -2);
			N = temp;
		}

		result.reverse();
		bw.write(result + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
