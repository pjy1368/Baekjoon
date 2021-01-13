import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Assignment {

  int day;
  int weight;

  Assignment(int day, int weight) {
    this.day = day;
    this.weight = weight;
  }
}

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    List<Assignment> assignmentList = new ArrayList<>();
    int maximumDay = 0;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      assignmentList.add(new Assignment(d, w));
      maximumDay = Math.max(maximumDay, d);
    }

    int totalScore = 0;
    for (int i = maximumDay; i > 0; i--) {
      totalScore += getMaximumScoreInDay(assignmentList, i);
    }

    bw.write(totalScore + "\n");
    bw.flush();
    bw.close();
    br.close();
  }

  public static int getMaximumScoreInDay(List<Assignment> assignmentList, int now) {
    int idx = -1;
    int result = 0;
    for (int i = 0; i < assignmentList.size(); i++) {
      if (assignmentList.get(i).day >= now && result < assignmentList.get(i).weight) {
        idx = i;
        result = assignmentList.get(i).weight;
      }
    }

    if (result == 0) {
      return 0;
    }

    assignmentList.remove(idx);
    return result;
  }

}