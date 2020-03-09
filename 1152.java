import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();

		int cnt = 0;
		Vector<Integer> v = new Vector<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (c == ' ') {
				if (cnt != 0) {
					v.add(cnt);
				}
				cnt = 0;
			} else {
				cnt++;
			}

		}

		if (cnt != 0) {
			v.add(cnt);
		}

		bw.write((v.size()) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
