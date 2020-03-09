import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();

		if (input.contains("dz=")) {
			input = input.replace("dz=", "0");
		}

		if (input.contains("z=")) {
			input = input.replace("z=", "0");
		}

		if (input.contains("lj")) {
			input = input.replace("lj", "0");
		}

		if (input.contains("nj")) {
			input = input.replace("nj", "0");
		}

		if (input.contains("c=")) {
			input = input.replace("c=", "0");
		}

		if (input.contains("c-")) {
			input = input.replace("c-", "0");
		}

		if (input.contains("d-")) {
			input = input.replace("d-", "0");
		}

		if (input.contains("s=")) {
			input = input.replace("s=", "0");
		}

		bw.write((input.length()) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
