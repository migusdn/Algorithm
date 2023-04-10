import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q15904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        char[] ucpc=new char[]{'U','C','P','C'};
        int idx=0;
        int i=0;
        while(i<4){
            char c = ucpc[i];
            int check = str.indexOf(c,idx);
            if(check==-1){
                sb.append("I hate UCPC");
                break;
            }else{
                i++;
                idx=check;
            }
        }
        if(sb.length()==0)
            sb.append("I love UCPC");
        bw.write(sb.toString());
        bw.close();
        br.close();


    }
}