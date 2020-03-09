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
		if(N <= 1) {
			bw.write("1");
			bw.flush();
			bf.close();
			bw.close();
			return;
		}
		long fac = 1;
		
		for(int i = 1; i <= N; i++) {
			fac *= i;
		}
		
		bw.write(fac + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
