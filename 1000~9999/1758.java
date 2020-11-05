import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Comparator.reverseOrder()); // 배열을 내림차순으로 정렬.

        long ans = 0;
        for (int i = 0; i < N; i++) {
            // 팁이 0원이 될 경우 반복문을 종료.
            if (arr[i] - i <= 0) {
                break;
            }

            ans += arr[i] - i;
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}