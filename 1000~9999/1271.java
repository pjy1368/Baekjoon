import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String N = st.nextToken();
		String M = st.nextToken();
		
		BigInteger b1 = new BigInteger(N);
		BigInteger b2 = new BigInteger(M);
		
	
		bw.write(b1.divide(b2) + "\n");
		bw.write(b1.mod(b2) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}