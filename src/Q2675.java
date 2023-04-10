import java.io.*;
import java.util.StringTokenizer;

public class Q2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<t; i++){
            st=new StringTokenizer(br.readLine());
            int tmp=Integer.parseInt(st.nextToken());
            char[] str = st.nextToken().toCharArray();
            for(int j=0; j<str.length; j++){
                for(int k=0;k<tmp;k++)
                    sb.append(str[j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
