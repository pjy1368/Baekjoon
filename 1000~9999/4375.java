import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        final StringBuilder answer = new StringBuilder();

        String input = "";
        while ((input = bufferedReader.readLine()) != null) {
            final int n = Integer.parseInt(input);

            long temp = 1;
            int size = 1;
            while (true) {
                if (temp % n == 0) {
                    answer.append(size).append("\n");
                    break;
                }
                temp = (10 * temp + 1) % n;
                size++;
            }
        }

        bufferedWriter.write(answer.toString());
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
