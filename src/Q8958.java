import java.io.*;
import java.util.StringTokenizer;

public class Q8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int result=0;
        for(int i=0 ;i<t; i++){
            char[] temp = br.readLine().toCharArray();
            int tmp=0;
            for(char c:temp)
                if(c=='O') {
                    tmp++;
                    result+=tmp;
                }else{
                    tmp=0;
                }
                sb.append(result+"\n");
                result =0;
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
