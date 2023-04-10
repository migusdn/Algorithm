import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q1924 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        final int[] days = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        final String[] dayName=new String[]{"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int day=d;
        for(int i=1;i<m;i++){
            day+=days[i];
        }
        bw.write(dayName[day%7]);
        bw.close();
        br.close();
    }
}