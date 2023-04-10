import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q1259 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String tmp = br.readLine();
        while(!tmp.equals("0")){
            char[] tmpChars = tmp.toCharArray();
            int leng =tmpChars.length/2;
            boolean flag = false;
            for(int i=0;i<leng;i++){
                if(tmpChars[i]!=tmpChars[tmpChars.length-i-1]){
                    flag = true;
                    break;
                }
            }
            if(flag)
                sb.append("no\n");
            else
                sb.append("yes\n");

            tmp = br.readLine();
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

}