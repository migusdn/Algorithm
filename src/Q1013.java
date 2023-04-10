

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Q1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        //정규 표현 문제
        Pattern pattern = Pattern.compile("((100+1+)|(01))+");
        Matcher matcher;
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T; i++){
            matcher = pattern.matcher(br.readLine());
            sb.append(matcher.matches() ? "YES\n":"NO\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}