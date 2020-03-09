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
		String N = st.nextToken(); 
		int B = Integer.parseInt(st.nextToken());
		int result = 0;

		if (B < 10) {
			for(int i = 0; i < N.length(); i++) {
				result += Integer.parseInt(String.valueOf(N.charAt(i))) * (int) Math.pow((double) B, N.length() - (i + 1));
			}
		} else if (B == 10) {
			result = Integer.parseInt(N);
		} else {
			for(int i = 0; i < N.length(); i++) {
				if(N.charAt(i) >= 'A' && N.charAt(i) <= 'Z') {
					int temp = N.charAt(i) - 'A' + 10;
					result += temp * (int) Math.pow((double) B, N.length() - (i + 1));
					continue;
				}
				result += Integer.parseInt(String.valueOf(N.charAt(i))) * (int) Math.pow((double) B, N.length() - (i + 1));
			}
		}

		bw.write(result + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
