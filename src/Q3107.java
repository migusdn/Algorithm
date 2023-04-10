import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q3107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] ipv6 = br.readLine().split("::");
        String[] left;
        String[] right;
        if(ipv6.length==2){
            left = ipv6[0].split(":");
            right = ipv6[1].split(":");
        }else{
            left = ipv6[0].split(":");
            right = new String[0];
        }
        for(int i=0; i<left.length;i++){
            String tmp = left[i];
            for(int j=0;j<4-tmp.length(); j++){
                sb.append('0');
            }
            sb.append(tmp).append(":");
        }
        for(int i=0;i<8-(left.length+right.length);i++){
            sb.append("0000:");
        }

        for(int i=0; i<right.length;i++){
            String tmp = right[i];
            for(int j=0;j<4-tmp.length(); j++){
                sb.append('0');
            }
            sb.append(tmp).append(":");
        }
        bw.write(sb.substring(0,39));
        bw.close();
        br.close();


    }
}