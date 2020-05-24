package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Member implements Comparable<Member> {
    int gender;
    int x;
 
    Member(int gender, int x) {
        this.gender = gender;
        this.x = x;
    }
 
    @Override
    public int compareTo(Member o) {
        return x - o.x;
    }
}
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
 
        final int MAX = 1000000;
        Member[] members = new Member[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
 
            if (gender == 0) { // 남자일 경우 0 대신 -1로 초기화
                gender = -1;
            }
 
            int x = Integer.parseInt(st.nextToken());
 
            members[i] = new Member(gender, x);
        }
        Arrays.sort(members); // x를 기준으로 오름차순.
 
        if (N == 2) { // N이 2일 때는 단순히 둘 사이의 거리를 뺸다. (예외 처리)
            bw.write((members[1].x - members[0].x) + "\n");
            bw.close();
            br.close();
            return;
        }
 
        int[] sum = new int[N]; // gender의 누적합
        sum[0] = members[0].gender;
 
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + members[i].gender;
        }
 
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= N + MAX; i++) {
            a.add(new ArrayList<>());
        }
 
        // 누적합이 같은 것끼리 묶는다.
        for (int i = 0; i < N; i++) {
            a.get(sum[i] + MAX).add(i);
        }
 
        int ans = 0;
        for (int i = 0; i < N + MAX; i++) {
            int temp = 0;
            if (a.get(i).size() > 1) {
                // 누적합이 같은 리스트 중에서 가장 처음 + 1 인덱스와 맨 끝 인덱스에 해당하는
                // members의 x 사이의 거리를 구한다.
                int end = a.get(i).get(a.get(i).size() - 1);
                int start = a.get(i).get(0) + 1;
 
                temp = members[end].x - members[start].x;
            }
            ans = Math.max(ans, temp);
        }
 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
}
