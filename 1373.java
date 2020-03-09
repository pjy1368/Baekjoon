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
		StringBuffer result = new StringBuffer();

		int temp = 0;
		int firstNum = input.length() % 3;
		if (input.length() >= 3) {
			if (firstNum != 0) {
				for (int i = 0; i < firstNum; i++) {
					temp += Integer.parseInt(String.valueOf(input.charAt(i))) * (int) Math.pow(2.0, firstNum - (i + 1));
				}
				if (temp != 0) {
					result.append(Integer.toString(temp));
				}
			}

			temp = 0;
			for (int i = firstNum, cnt = 0; i <= input.length(); i++, cnt++) {
				if (cnt == 3) {
					cnt = 0;
					if (!(result.length() == 0 && temp == 0)) {
						result.append(Integer.toString(temp));
						temp = 0;
					}
				}
				if (i == input.length()) {
					break;
				}
				temp += Integer.parseInt(String.valueOf(input.charAt(i))) * (int) Math.pow(2.0, 3 - (cnt + 1));
			}

		} else {
			if (input.equals("0") || input.equals("00")) {
				result.append("0");
			} else if (input.equals("1") || input.equals("01")) {
				result.append("1");
			} else if (input.equals("10")) {
				result.append("2");
			} else if (input.equals("11")) {
				result.append("3");
			}
		}

		bw.write(result + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
