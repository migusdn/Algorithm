import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

class Q1357 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        bw.write(Rev(Rev(x)+Rev(y))+"");
        bw.close();
        br.close();
    }
    public static int Rev(int n){
        char[] number = String.valueOf(n).toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=number.length-1; i>=0; i--)
            sb.append(number[i]);
//        System.out.println(sb.toString());
        return Integer.parseInt(sb.toString());
    }
}