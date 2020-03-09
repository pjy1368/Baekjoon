import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();

		// 조건 1. 숫자의 맨 끝이 0이어야 함. 그러기 위해서는 1차적으로 0이 있는지 확인해야 함.
		boolean isZero = false;
		if (input.contains("0")) {
			isZero = true;
		}

		if (!isZero) {
			bw.write("-1\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		// 조건 2. 각자리 숫자의 합이 3의 배수여야 함.
		int total = 0;
		for (int i = 0; i < input.length(); i++) {
			total += Integer.parseInt(String.valueOf(input.charAt(i)));
		}

		if (total % 3 != 0) {
			bw.write("-1\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		// 위 조건을 충족시켰다면, input을 내림차순으로 정렬.
		input = reverseStr(input);

		bw.write(input + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static String reverseStr(String str) {
		String[] array = str.split("");
		Arrays.sort(array, Collections.reverseOrder());

		return String.join("", array);
	}

}
