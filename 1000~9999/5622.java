import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[26];

		for (int i = 0; i < arr.length; i++) {
			if (i >= 15 && i < 19) {
				arr[i] = 8;
			} else if (i >= 22 && i < arr.length) {
				arr[i] = 10;
			} else if (i >= 19 && i < 22) {
				arr[i] = 9;
			} else {
				arr[i] = 3 + i / 3;
			}
		}

		String input = br.readLine();

		int sum = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (c == '0') {
				sum += 11;
			} else if (c == '1') {
				sum += 2;
			} else {
				sum += arr[(int) (c - 'A')];
			}
		}

		bw.write(sum + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
