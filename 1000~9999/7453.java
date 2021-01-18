import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());

    int[][] arr = new int[N][4];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 4; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[] AB = new int[N * N];
    int[] CD = new int[N * N];
    int idx = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        AB[idx] = arr[i][0] + arr[j][1];
        CD[idx] = arr[i][2] + arr[j][3];
        idx++;
      }
    }
    Arrays.sort(CD);

    long ans = 0;
    for (int key : AB) {
      int upper = upperBound(CD, -key);
      int lower = lowerBound(CD, -key);
      ans += (upper - lower);
    }

    bw.write(ans + "\n");
    bw.flush();
    bw.close();
    br.close();
  }

  static int upperBound(int[] arr, int find) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (arr[mid] <= find) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  static int lowerBound(int[] arr, int find) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (arr[mid] < find) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

}