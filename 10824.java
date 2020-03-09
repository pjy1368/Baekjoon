import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = bf.readLine();
		StringTokenizer st = new StringTokenizer(input);
		long num1 = Long.parseLong(st.nextToken() + st.nextToken());
		long num2 = Long.parseLong(st.nextToken() + st.nextToken());
	
		bw.write((num1 + num2) + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
