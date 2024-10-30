import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 신입사원
 * @date : 2024. 10. 30. 오전 11:17
 * @modifyed : $
 **/
public class 신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t;

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Score> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String[] temp = br.readLine().split(" ");
                list.add(new Score(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
            }
            list.sort(Comparator.comparingInt(o -> o.resumeScore));
            int result = 1;
            int curInterviewScore = list.get(0).interviewScore;
            for (int j = 1; j < n; j++) {
                Score cur = list.get(j);
                if(cur.interviewScore< curInterviewScore){
                    result++;
                    curInterviewScore = cur.interviewScore;
                }
            }
            sb.append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    public static class Score {
        public int resumeScore;
        public int interviewScore;

        public Score(int resumeScore, int interviewScore) {
            this.resumeScore = resumeScore;
            this.interviewScore = interviewScore;
        }

    }
}
