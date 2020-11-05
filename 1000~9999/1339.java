import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        // �Է°��� �Ųٷ� �Է¹���.
        // �Է°��� ū �ڸ� �������ε�,
        // �Ųٷ� �Է¹����� �Ʒ� �ݺ������� ���ϰ� ����� �� ����.
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            StringBuilder sb = new StringBuilder(input);
            arr[i] = sb.reverse().toString();
        }

        // ���ڿ��� ���̸� �������� �������� ����.
        Arrays.sort(arr, (s1, s2) -> s2.length() - s1.length());

        Map<Character, Integer> map = new HashMap<>(); // key : ���ĺ�, value : ���ĺ��� �������� ��.
        int start = arr[0].length() - 1; // ���� ū �ڸ���.

        for (int i = start; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                // ���� �ڸ� ������ ���ڿ��� ���̰� ª�� ���.
                if (i >= arr[j].length()) {
                    break;
                }

                char c = arr[j].charAt(i);

                if (!map.containsKey(c)) {
                    map.put(c, (int) Math.pow(10, i));
                } else {
                    map.put(c, map.get(c) + (int) Math.pow(10, i));
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        Iterator<Character> it = map.keySet().iterator();

        // list�� map�� value�� ����.
        while (it.hasNext()) {
            char c = it.next();
            list.add(map.get(c));
        }

        // �������� ����.
        Collections.sort(list, (a, b) -> b - a);

        int num = 9;
        int ans = 0;

        // �������� ���� ���� ū ���ĺ��� ū ���� �Ҵ��ϴ� ���� �ּ���.
        for (int i = 0; i < list.size(); i++) {
            ans += list.get(i) * num--;
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}