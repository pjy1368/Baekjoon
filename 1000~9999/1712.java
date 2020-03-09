import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken()); // 고정 가격
		long B = Long.parseLong(st.nextToken()); // 가변 가격
		long C = Long.parseLong(st.nextToken()); // 판매 가격
		
		if(C - B <= 0) {
			bw.write("-1\n");
			bw.flush();
			br.close();
			bw.close();
			return;
		}
		
		long sale = A / (C - B);
		
		bw.write((sale + 1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
