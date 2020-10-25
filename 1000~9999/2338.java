import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String A = br.readLine();
		String B = br.readLine();

		BigInteger b1 = new BigInteger(A);
		BigInteger b2 = new BigInteger(B);

		bw.write(b1.add(b2) + "\n");
		bw.write(b1.subtract(b2) + "\n");
		bw.write(b1.multiply(b2) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}