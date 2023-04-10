import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q11721 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        for(int i=0; i<str.length(); i++){
            if(i%10==0&&i!=0)
                sb.append("\n");
            sb.append(str.charAt(i));


        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}