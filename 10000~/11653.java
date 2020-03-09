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
		int n = Integer.parseInt(bf.readLine());

		for (int i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				bw.write(i + "\n");
				n /= i;
			}
		}
		
		if (n > 1) {
			bw.write(n + "\n");
		}

		bw.flush();
		bf.close();
		bw.close();
	}

}
