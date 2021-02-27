import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String input = br.readLine();

    bw.write((isPPAP(input) ? "PPAP" : "NP"));
    bw.flush();
    bw.close();
    br.close();
  }

  static boolean isPPAP(String input) {
    int cnt = 0;
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);

      if (c == 'P') {
        cnt++;
        continue;
      }

      if (i != input.length() - 1 && cnt >= 2 && input.charAt(i + 1) == 'P') {
        cnt--;
        i++;
      } else {
        return false;
      }
    }

    return cnt == 1;
  }

}