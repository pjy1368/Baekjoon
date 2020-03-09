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
		String input = bf.readLine();
		if(input.equals("0")) {
			bw.write("0\n");
			bw.flush();
			bw.close();
			bf.close();
			return;
		}
		
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);
			switch (temp) {
			case '0':
				result.append("000");
				break;
			case '1':
				result.append("001");
				break;
			case '2':
				result.append("010");
				break;
			case '3':
				result.append("011");
				break;
			case '4':
				result.append("100");
				break;
			case '5':
				result.append("101");
				break;
			case '6':
				result.append("110");
				break;
			case '7':
				result.append("111");
				break;
			}
		}
		
		while(result.charAt(0) == '0') {
			result.deleteCharAt(0);
		}
		
		bw.write(result + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
