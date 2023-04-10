import java.io.*;
import java.util.StringTokenizer;

class Q16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        while(start!=target){
            if((target%10!=1&&target%2!=0)||target<start) {
                result=-1;
                break;
            }
            if(target%10==1)
                target/=10;
            else
                target/=2;
            result++;
        }
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}