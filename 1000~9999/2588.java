import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int A = Integer.parseInt(br.readLine());
		String B = br.readLine();

		for (int i = B.length() - 1; i >= 0; i--) {
			int temp = A * Integer.parseInt(String.valueOf(B.charAt(i)));
			bw.write(temp + "\n");
		}
		bw.write((A * Integer.parseInt(B)) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
