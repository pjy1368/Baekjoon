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
		if (N <= 1) {
			bw.write("0\n");
			bw.flush();
			bf.close();
			bw.close();
			return;
		}
		
		int two = 0;
		int five = 0;

		for (int i = 2; i <= N; i++) {
			int temp = i;
			while (temp % 5 == 0) {
				five++;
				temp /= 5;
			}
			while (temp % 2 == 0) {
				two++;
				temp /= 2;
			}
		}
		
		bw.write(Math.min(two, five) + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
